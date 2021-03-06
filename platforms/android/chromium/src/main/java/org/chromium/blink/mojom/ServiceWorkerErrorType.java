
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/service_worker_error_type.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ServiceWorkerErrorType {


    public static final int NONE = (int) (0L);

    public static final int ABORT = NONE + 1;

    public static final int ACTIVATE = ABORT + 1;

    public static final int DISABLED = ACTIVATE + 1;

    public static final int INSTALL = DISABLED + 1;

    public static final int NAVIGATION = INSTALL + 1;

    public static final int NETWORK = NAVIGATION + 1;

    public static final int NOT_FOUND = NETWORK + 1;

    public static final int SCRIPT_EVALUATE_FAILED = NOT_FOUND + 1;

    public static final int SECURITY = SCRIPT_EVALUATE_FAILED + 1;

    public static final int STATE = SECURITY + 1;

    public static final int TIMEOUT = STATE + 1;

    public static final int TYPE = TIMEOUT + 1;

    public static final int UNKNOWN = TYPE + 1;

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

    private ServiceWorkerErrorType() {}

}