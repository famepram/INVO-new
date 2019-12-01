
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/platform/modules/webauthn/authenticator.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AuthenticatorStatus {


    public static final int SUCCESS = 0;

    public static final int PENDING_REQUEST = SUCCESS + 1;

    public static final int NOT_ALLOWED_ERROR = PENDING_REQUEST + 1;

    public static final int INVALID_DOMAIN = NOT_ALLOWED_ERROR + 1;

    public static final int CREDENTIAL_EXCLUDED = INVALID_DOMAIN + 1;

    public static final int CREDENTIAL_NOT_RECOGNIZED = CREDENTIAL_EXCLUDED + 1;

    public static final int NOT_IMPLEMENTED = CREDENTIAL_NOT_RECOGNIZED + 1;

    public static final int NOT_FOCUSED = NOT_IMPLEMENTED + 1;

    public static final int RESIDENT_CREDENTIALS_UNSUPPORTED = NOT_FOCUSED + 1;

    public static final int USER_VERIFICATION_UNSUPPORTED = RESIDENT_CREDENTIALS_UNSUPPORTED + 1;

    public static final int ALGORITHM_UNSUPPORTED = USER_VERIFICATION_UNSUPPORTED + 1;

    public static final int EMPTY_ALLOW_CREDENTIALS = ALGORITHM_UNSUPPORTED + 1;

    public static final int ANDROID_NOT_SUPPORTED_ERROR = EMPTY_ALLOW_CREDENTIALS + 1;

    public static final int UNKNOWN_ERROR = ANDROID_NOT_SUPPORTED_ERROR + 1;

    public static final int MIN_VALUE = (int) (0);
    public static final int MAX_VALUE = (int) (13);

    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private AuthenticatorStatus() {}

}