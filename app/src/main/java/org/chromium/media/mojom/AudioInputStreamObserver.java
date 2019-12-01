
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/audio_input_stream.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface AudioInputStreamObserver extends org.chromium.mojo.bindings.Interface {



    public static final class DisconnectReason {


        public static final int DEFAULT = (int) (0L);

        public static final int PLATFORM_ERROR = (int) (1L);

        public static final int TERMINATED_BY_CLIENT = (int) (2L);

        public static final int STREAM_CREATION_FAILED = (int) (3L);

        public static final int DOCUMENT_DESTROYED = (int) (4L);

        public static final int MIN_VALUE = (int) (0);
        public static final int MAX_VALUE = (int) (4);

        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            switch (value) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    return true;
            }
            return false;
        }

        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value))
                return;

            throw new DeserializationException("Invalid enum value.");
        }

        private DisconnectReason() {}

    }


    public interface Proxy extends AudioInputStreamObserver, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AudioInputStreamObserver, AudioInputStreamObserver.Proxy> MANAGER = AudioInputStreamObserver_Internal.MANAGER;


    void didStartRecording(
);


}
