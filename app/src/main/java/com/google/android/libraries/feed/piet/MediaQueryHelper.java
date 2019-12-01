// Copyright 2018 The Feed Authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.android.libraries.feed.piet;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.VisibleForTesting;
import com.google.android.libraries.feed.common.logging.Logger;
import com.google.android.libraries.feed.common.ui.LayoutUtils;
import com.google.android.libraries.feed.piet.host.AssetProvider;
import com.google.search.now.ui.piet.ErrorsProto.ErrorCode;
import com.google.search.now.ui.piet.MediaQueriesProto.MediaQueryCondition;
import java.util.List;

/** Provides methods for filtering by MediaQueryConditions. */
public class MediaQueryHelper {
  private static final String TAG = "MediaQueryHelper";

  private final int frameWidthPx;
  private final AssetProvider assetProvider;
  private final Context context;

  MediaQueryHelper(int frameWidthPx, AssetProvider assetProvider, Context context) {
    this.frameWidthPx = frameWidthPx;
    this.assetProvider = assetProvider;
    this.context = context;
  }

  boolean areMediaQueriesMet(List<MediaQueryCondition> conditions) {
    for (MediaQueryCondition condition : conditions) {
      if (!isMediaQueryMet(condition)) {
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings("UnnecessaryDefaultInEnumSwitch")
  @VisibleForTesting
  boolean isMediaQueryMet(MediaQueryCondition condition) {
    switch (condition.getConditionCase()) {
      case FRAME_WIDTH:
        int targetWidth = (int) LayoutUtils.dpToPx(condition.getFrameWidth().getWidth(), context);
        switch (condition.getFrameWidth().getCondition()) {
          case EQUALS:
            return frameWidthPx == targetWidth;
          case GREATER_THAN:
            return frameWidthPx > targetWidth;
          case LESS_THAN:
            return frameWidthPx < targetWidth;
          case NOT_EQUALS:
            return frameWidthPx != targetWidth;
          default:
            throw new PietFatalException(
                ErrorCode.ERR_INVALID_MEDIA_QUERY_CONDITION,
                String.format(
                    "Unhandled ComparisonCondition: %s", condition.getFrameWidth().getCondition()));
        }
      case ORIENTATION:
        int deviceOrientation = context.getResources().getConfiguration().orientation;
        switch (condition.getOrientation().getOrientation()) {
          case LANDSCAPE:
            return deviceOrientation == Configuration.ORIENTATION_LANDSCAPE;
          case UNSPECIFIED:
            Logger.w(TAG, "Got UNSPECIFIED orientation; defaulting to PORTRAIT");
            // fall through
          case PORTRAIT:
            return deviceOrientation == Configuration.ORIENTATION_PORTRAIT
                || deviceOrientation == Configuration.ORIENTATION_SQUARE;
          default:
            throw new PietFatalException(
                ErrorCode.ERR_INVALID_MEDIA_QUERY_CONDITION,
                String.format(
                    "Unhandled Orientation: %s", condition.getOrientation().getOrientation()));
        }
      case DARK_LIGHT:
        switch (condition.getDarkLight().getMode()) {
          case DARK:
            return assetProvider.isDarkTheme();
          case UNSPECIFIED:
            Logger.w(TAG, "Got UNSPECIFIED DarkLightMode; defaulting to LIGHT");
            // fall through
          case LIGHT:
            return !assetProvider.isDarkTheme();
          default:
            throw new PietFatalException(
                ErrorCode.ERR_INVALID_MEDIA_QUERY_CONDITION,
                String.format("Unhandled DarkLightMode: %s", condition.getDarkLight().getMode()));
        }
      default:
        throw new PietFatalException(
            ErrorCode.ERR_INVALID_MEDIA_QUERY_CONDITION,
            String.format("Unhandled MediaQueryCondition: %s", condition.getConditionCase()));
    }
  }
}
