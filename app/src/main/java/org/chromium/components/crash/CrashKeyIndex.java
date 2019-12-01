
// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/crash/android/crash_keys_android.h

package org.chromium.components.crash;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    CrashKeyIndex.LOADED_DYNAMIC_MODULE, CrashKeyIndex.ACTIVE_DYNAMIC_MODULE,
    CrashKeyIndex.APPLICATION_STATUS, CrashKeyIndex.INSTALLED_MODULES,
    CrashKeyIndex.EMULATED_MODULES, CrashKeyIndex.NUM_KEYS
})
@Retention(RetentionPolicy.SOURCE)
public @interface CrashKeyIndex {
  int LOADED_DYNAMIC_MODULE = 0;
  int ACTIVE_DYNAMIC_MODULE = 1;
  int APPLICATION_STATUS = 2;
  int INSTALLED_MODULES = 3;
  int EMULATED_MODULES = 4;
  int NUM_KEYS = 5;
}
