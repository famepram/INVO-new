
// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/sync/base/stop_source.h

package org.chromium.components.sync;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    StopSource.PROFILE_DESTRUCTION, StopSource.SIGN_OUT, StopSource.BIRTHDAY_ERROR,
    StopSource.CHROME_SYNC_SETTINGS, StopSource.ANDROID_CHROME_SYNC, StopSource.ANDROID_MASTER_SYNC,
    StopSource.STOP_SOURCE_LIMIT
})
@Retention(RetentionPolicy.SOURCE)
public @interface StopSource {
  int PROFILE_DESTRUCTION = 0;
  int SIGN_OUT = 1;
  int BIRTHDAY_ERROR = 2;
  int CHROME_SYNC_SETTINGS = 3;
  int ANDROID_CHROME_SYNC = 4;
  int ANDROID_MASTER_SYNC = 5;
  int STOP_SOURCE_LIMIT = 6;
}
