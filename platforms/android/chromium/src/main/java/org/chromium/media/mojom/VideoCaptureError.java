
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/capture/mojom/video_capture_types.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class VideoCaptureError {


    public static final int NONE = 0;

    public static final int VIDEO_CAPTURE_CONTROLLER_INVALID_OR_UNSUPPORTED_VIDEO_CAPTURE_PARAMETERS_REQUESTED = NONE + 1;

    public static final int VIDEO_CAPTURE_CONTROLLER_IS_ALREADY_IN_ERROR_STATE = VIDEO_CAPTURE_CONTROLLER_INVALID_OR_UNSUPPORTED_VIDEO_CAPTURE_PARAMETERS_REQUESTED + 1;

    public static final int VIDEO_CAPTURE_MANAGER_DEVICE_CONNECTION_LOST = VIDEO_CAPTURE_CONTROLLER_IS_ALREADY_IN_ERROR_STATE + 1;

    public static final int FRAME_SINK_VIDEO_CAPTURE_DEVICE_ALERADY_ENDED_ON_FATAL_ERROR = VIDEO_CAPTURE_MANAGER_DEVICE_CONNECTION_LOST + 1;

    public static final int FRAME_SINK_VIDEO_CAPTURE_DEVICE_ENCOUNTERED_FATAL_ERROR = FRAME_SINK_VIDEO_CAPTURE_DEVICE_ALERADY_ENDED_ON_FATAL_ERROR + 1;

    public static final int V4L2_FAILED_TO_OPEN_V4L2_DEVICE_DRIVER_FILE = FRAME_SINK_VIDEO_CAPTURE_DEVICE_ENCOUNTERED_FATAL_ERROR + 1;

    public static final int V4L2_THIS_IS_NOT_AV4L2_VIDEO_CAPTURE_DEVICE = V4L2_FAILED_TO_OPEN_V4L2_DEVICE_DRIVER_FILE + 1;

    public static final int V4L2_FAILED_TO_FIND_A_SUPPORTED_CAMERA_FORMAT = V4L2_THIS_IS_NOT_AV4L2_VIDEO_CAPTURE_DEVICE + 1;

    public static final int V4L2_FAILED_TO_SET_VIDEO_CAPTURE_FORMAT = V4L2_FAILED_TO_FIND_A_SUPPORTED_CAMERA_FORMAT + 1;

    public static final int V4L2_UNSUPPORTED_PIXEL_FORMAT = V4L2_FAILED_TO_SET_VIDEO_CAPTURE_FORMAT + 1;

    public static final int V4L2_FAILED_TO_SET_CAMERA_FRAMERATE = V4L2_UNSUPPORTED_PIXEL_FORMAT + 1;

    public static final int V4L2_ERROR_REQUESTING_MMAP_BUFFERS = V4L2_FAILED_TO_SET_CAMERA_FRAMERATE + 1;

    public static final int V4L2_ALLOCATE_BUFFER_FAILED = V4L2_ERROR_REQUESTING_MMAP_BUFFERS + 1;

    public static final int V4L2_VIDIOC_STREAMON_FAILED = V4L2_ALLOCATE_BUFFER_FAILED + 1;

    public static final int V4L2_VIDIOC_STREAMOFF_FAILED = V4L2_VIDIOC_STREAMON_FAILED + 1;

    public static final int V4L2_FAILED_TO_VIDIOC_REQBUFS_WITH_COUNT0 = V4L2_VIDIOC_STREAMOFF_FAILED + 1;

    public static final int V4L2_POLL_FAILED = V4L2_FAILED_TO_VIDIOC_REQBUFS_WITH_COUNT0 + 1;

    public static final int V4L2_MULTIPLE_CONTINUOUS_TIMEOUTS_WHILE_READ_POLLING = V4L2_POLL_FAILED + 1;

    public static final int V4L2_FAILED_TO_DEQUEUE_CAPTURE_BUFFER = V4L2_MULTIPLE_CONTINUOUS_TIMEOUTS_WHILE_READ_POLLING + 1;

    public static final int V4L2_FAILED_TO_ENQUEUE_CAPTURE_BUFFER = V4L2_FAILED_TO_DEQUEUE_CAPTURE_BUFFER + 1;

    public static final int SINGLE_CLIENT_VIDEO_CAPTURE_HOST_LOST_CONNECTION_TO_DEVICE = V4L2_FAILED_TO_ENQUEUE_CAPTURE_BUFFER + 1;

    public static final int SINGLE_CLIENT_VIDEO_CAPTURE_DEVICE_LAUNCH_ABORTED = SINGLE_CLIENT_VIDEO_CAPTURE_HOST_LOST_CONNECTION_TO_DEVICE + 1;

    public static final int DESKTOP_CAPTURE_DEVICE_WEBRTC_DESKTOP_CAPTURER_HAS_FAILED = SINGLE_CLIENT_VIDEO_CAPTURE_DEVICE_LAUNCH_ABORTED + 1;

    public static final int FILE_VIDEO_CAPTURE_DEVICE_COULD_NOT_OPEN_VIDEO_FILE = DESKTOP_CAPTURE_DEVICE_WEBRTC_DESKTOP_CAPTURER_HAS_FAILED + 1;

    public static final int DEVICE_CAPTURE_LINUX_FAILED_TO_CREATE_VIDEO_CAPTURE_DELEGATE = FILE_VIDEO_CAPTURE_DEVICE_COULD_NOT_OPEN_VIDEO_FILE + 1;

    public static final int ERROR_FAKE_DEVICE_INTENTIONALLY_EMITTING_ERROR_EVENT = DEVICE_CAPTURE_LINUX_FAILED_TO_CREATE_VIDEO_CAPTURE_DELEGATE + 1;

    public static final int DEVICE_CLIENT_TOO_MANY_FRAMES_DROPPED_Y16 = ERROR_FAKE_DEVICE_INTENTIONALLY_EMITTING_ERROR_EVENT + 1;

    public static final int DEVICE_MEDIA_TO_MOJO_ADAPTER_ENCOUNTERED_UNSUPPORTED_BUFFER_TYPE = DEVICE_CLIENT_TOO_MANY_FRAMES_DROPPED_Y16 + 1;

    public static final int VIDEO_CAPTURE_MANAGER_PROCESS_DEVICE_START_QUEUE_DEVICE_INFO_NOT_FOUND = DEVICE_MEDIA_TO_MOJO_ADAPTER_ENCOUNTERED_UNSUPPORTED_BUFFER_TYPE + 1;

    public static final int IN_PROCESS_DEVICE_LAUNCHER_FAILED_TO_CREATE_DEVICE_INSTANCE = VIDEO_CAPTURE_MANAGER_PROCESS_DEVICE_START_QUEUE_DEVICE_INFO_NOT_FOUND + 1;

    public static final int SERVICE_DEVICE_LAUNCHER_LOST_CONNECTION_TO_DEVICE_FACTORY_DURING_DEVICE_START = IN_PROCESS_DEVICE_LAUNCHER_FAILED_TO_CREATE_DEVICE_INSTANCE + 1;

    public static final int SERVICE_DEVICE_LAUNCHER_SERVICE_RESPONDED_WITH_DEVICE_NOT_FOUND = SERVICE_DEVICE_LAUNCHER_LOST_CONNECTION_TO_DEVICE_FACTORY_DURING_DEVICE_START + 1;

    public static final int SERVICE_DEVICE_LAUNCHER_CONNECTION_LOST_WHILE_WAITING_FOR_CALLBACK = SERVICE_DEVICE_LAUNCHER_SERVICE_RESPONDED_WITH_DEVICE_NOT_FOUND + 1;

    public static final int INTENTIONAL_ERROR_RAISED_BY_UNIT_TEST = SERVICE_DEVICE_LAUNCHER_CONNECTION_LOST_WHILE_WAITING_FOR_CALLBACK + 1;

    public static final int CROS_HAL_V3_FAILED_TO_START_DEVICE_THREAD = INTENTIONAL_ERROR_RAISED_BY_UNIT_TEST + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_MOJO_CONNECTION_ERROR = CROS_HAL_V3_FAILED_TO_START_DEVICE_THREAD + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_GET_CAMERA_INFO = CROS_HAL_V3_DEVICE_DELEGATE_MOJO_CONNECTION_ERROR + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_MISSING_SENSOR_ORIENTATION_INFO = CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_GET_CAMERA_INFO + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_OPEN_CAMERA_DEVICE = CROS_HAL_V3_DEVICE_DELEGATE_MISSING_SENSOR_ORIENTATION_INFO + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_INITIALIZE_CAMERA_DEVICE = CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_OPEN_CAMERA_DEVICE + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_CONFIGURE_STREAMS = CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_INITIALIZE_CAMERA_DEVICE + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_WRONG_NUMBER_OF_STREAMS_CONFIGURED = CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_CONFIGURE_STREAMS + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_GET_DEFAULT_REQUEST_SETTINGS = CROS_HAL_V3_DEVICE_DELEGATE_WRONG_NUMBER_OF_STREAMS_CONFIGURED + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_HAL_REQUESTED_TOO_MANY_BUFFERS = CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_GET_DEFAULT_REQUEST_SETTINGS + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_CREATE_GPU_MEMORY_BUFFER = CROS_HAL_V3_BUFFER_MANAGER_HAL_REQUESTED_TOO_MANY_BUFFERS + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_MAP_GPU_MEMORY_BUFFER = CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_CREATE_GPU_MEMORY_BUFFER + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_UNSUPPORTED_VIDEO_PIXEL_FORMAT = CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_MAP_GPU_MEMORY_BUFFER + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_DUP_FD = CROS_HAL_V3_BUFFER_MANAGER_UNSUPPORTED_VIDEO_PIXEL_FORMAT + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_WRAP_GPU_MEMORY_HANDLE = CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_DUP_FD + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_REGISTER_BUFFER = CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_WRAP_GPU_MEMORY_HANDLE + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_PROCESS_CAPTURE_REQUEST_FAILED = CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_REGISTER_BUFFER + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_INVALID_PENDING_RESULT_ID = CROS_HAL_V3_BUFFER_MANAGER_PROCESS_CAPTURE_REQUEST_FAILED + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_DUPLICATED_PARTIAL_METADATA = CROS_HAL_V3_BUFFER_MANAGER_INVALID_PENDING_RESULT_ID + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_INCORRECT_NUMBER_OF_OUTPUT_BUFFERS_RECEIVED = CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_DUPLICATED_PARTIAL_METADATA + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_INVALID_TYPE_OF_OUTPUT_BUFFERS_RECEIVED = CROS_HAL_V3_BUFFER_MANAGER_INCORRECT_NUMBER_OF_OUTPUT_BUFFERS_RECEIVED + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_MULTIPLE_RESULT_BUFFERS_FOR_FRAME = CROS_HAL_V3_BUFFER_MANAGER_INVALID_TYPE_OF_OUTPUT_BUFFERS_RECEIVED + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_UNKNOWN_STREAM_IN_CAMERA3_NOTIFY_MSG = CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_MULTIPLE_RESULT_BUFFERS_FOR_FRAME + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_INVALID_SHUTTER_TIME = CROS_HAL_V3_BUFFER_MANAGER_UNKNOWN_STREAM_IN_CAMERA3_NOTIFY_MSG + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_FATAL_DEVICE_ERROR = CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_INVALID_SHUTTER_TIME + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_FRAME_IS_OUT_OF_ORDER = CROS_HAL_V3_BUFFER_MANAGER_FATAL_DEVICE_ERROR + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_UNWRAP_RELEASE_FENCE_FD = CROS_HAL_V3_BUFFER_MANAGER_RECEIVED_FRAME_IS_OUT_OF_ORDER + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_SYNC_WAIT_ON_RELEASE_FENCE_TIMED_OUT = CROS_HAL_V3_BUFFER_MANAGER_FAILED_TO_UNWRAP_RELEASE_FENCE_FD + 1;

    public static final int CROS_HAL_V3_BUFFER_MANAGER_INVALID_JPEG_BLOB = CROS_HAL_V3_BUFFER_MANAGER_SYNC_WAIT_ON_RELEASE_FENCE_TIMED_OUT + 1;

    public static final int ANDROID_FAILED_TO_ALLOCATE = CROS_HAL_V3_BUFFER_MANAGER_INVALID_JPEG_BLOB + 1;

    public static final int ANDROID_FAILED_TO_START_CAPTURE = ANDROID_FAILED_TO_ALLOCATE + 1;

    public static final int ANDROID_FAILED_TO_STOP_CAPTURE = ANDROID_FAILED_TO_START_CAPTURE + 1;

    public static final int ANDROID_API1_CAMERA_ERROR_CALLBACK_RECEIVED = ANDROID_FAILED_TO_STOP_CAPTURE + 1;

    public static final int ANDROID_API2_CAMERA_DEVICE_ERROR_RECEIVED = ANDROID_API1_CAMERA_ERROR_CALLBACK_RECEIVED + 1;

    public static final int ANDROID_API2_CAPTURE_SESSION_CONFIGURE_FAILED = ANDROID_API2_CAMERA_DEVICE_ERROR_RECEIVED + 1;

    public static final int ANDROID_API2_IMAGE_READER_UNEXPECTED_IMAGE_FORMAT = ANDROID_API2_CAPTURE_SESSION_CONFIGURE_FAILED + 1;

    public static final int ANDROID_API2_IMAGE_READER_SIZE_DID_NOT_MATCH_IMAGE_SIZE = ANDROID_API2_IMAGE_READER_UNEXPECTED_IMAGE_FORMAT + 1;

    public static final int ANDROID_API2_ERROR_RESTARTING_PREVIEW = ANDROID_API2_IMAGE_READER_SIZE_DID_NOT_MATCH_IMAGE_SIZE + 1;

    public static final int ANDROID_SCREEN_CAPTURE_UNSUPPORTED_FORMAT = ANDROID_API2_ERROR_RESTARTING_PREVIEW + 1;

    public static final int ANDROID_SCREEN_CAPTURE_FAILED_TO_START_CAPTURE_MACHINE = ANDROID_SCREEN_CAPTURE_UNSUPPORTED_FORMAT + 1;

    public static final int ANDROID_SCREEN_CAPTURE_THE_USER_DENIED_SCREEN_CAPTURE = ANDROID_SCREEN_CAPTURE_FAILED_TO_START_CAPTURE_MACHINE + 1;

    public static final int ANDROID_SCREEN_CAPTURE_FAILED_TO_START_SCREEN_CAPTURE = ANDROID_SCREEN_CAPTURE_THE_USER_DENIED_SCREEN_CAPTURE + 1;

    public static final int WIN_DIRECT_SHOW_CANT_GET_CAPTURE_FORMAT_SETTINGS = ANDROID_SCREEN_CAPTURE_FAILED_TO_START_SCREEN_CAPTURE + 1;

    public static final int WIN_DIRECT_SHOW_FAILED_TO_GET_NUMBER_OF_CAPABILITIES = WIN_DIRECT_SHOW_CANT_GET_CAPTURE_FORMAT_SETTINGS + 1;

    public static final int WIN_DIRECT_SHOW_FAILED_TO_GET_CAPTURE_DEVICE_CAPABILITIES = WIN_DIRECT_SHOW_FAILED_TO_GET_NUMBER_OF_CAPABILITIES + 1;

    public static final int WIN_DIRECT_SHOW_FAILED_TO_SET_CAPTURE_DEVICE_OUTPUT_FORMAT = WIN_DIRECT_SHOW_FAILED_TO_GET_CAPTURE_DEVICE_CAPABILITIES + 1;

    public static final int WIN_DIRECT_SHOW_FAILED_TO_CONNECT_THE_CAPTURE_GRAPH = WIN_DIRECT_SHOW_FAILED_TO_SET_CAPTURE_DEVICE_OUTPUT_FORMAT + 1;

    public static final int WIN_DIRECT_SHOW_FAILED_TO_PAUSE_THE_CAPTURE_DEVICE = WIN_DIRECT_SHOW_FAILED_TO_CONNECT_THE_CAPTURE_GRAPH + 1;

    public static final int WIN_DIRECT_SHOW_FAILED_TO_START_THE_CAPTURE_DEVICE = WIN_DIRECT_SHOW_FAILED_TO_PAUSE_THE_CAPTURE_DEVICE + 1;

    public static final int WIN_DIRECT_SHOW_FAILED_TO_STOP_THE_CAPTURE_GRAPH = WIN_DIRECT_SHOW_FAILED_TO_START_THE_CAPTURE_DEVICE + 1;

    public static final int WIN_MEDIA_FOUNDATION_ENGINE_IS_NULL = WIN_DIRECT_SHOW_FAILED_TO_STOP_THE_CAPTURE_GRAPH + 1;

    public static final int WIN_MEDIA_FOUNDATION_ENGINE_GET_SOURCE_FAILED = WIN_MEDIA_FOUNDATION_ENGINE_IS_NULL + 1;

    public static final int WIN_MEDIA_FOUNDATION_FILL_PHOTO_CAPABILITIES_FAILED = WIN_MEDIA_FOUNDATION_ENGINE_GET_SOURCE_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_FILL_VIDEO_CAPABILITIES_FAILED = WIN_MEDIA_FOUNDATION_FILL_PHOTO_CAPABILITIES_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_NO_VIDEO_CAPABILITY_FOUND = WIN_MEDIA_FOUNDATION_FILL_VIDEO_CAPABILITIES_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_GET_AVAILABLE_DEVICE_MEDIA_TYPE_FAILED = WIN_MEDIA_FOUNDATION_NO_VIDEO_CAPABILITY_FOUND + 1;

    public static final int WIN_MEDIA_FOUNDATION_SET_CURRENT_DEVICE_MEDIA_TYPE_FAILED = WIN_MEDIA_FOUNDATION_GET_AVAILABLE_DEVICE_MEDIA_TYPE_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_ENGINE_GET_SINK_FAILED = WIN_MEDIA_FOUNDATION_SET_CURRENT_DEVICE_MEDIA_TYPE_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_SINK_QUERY_CAPTURE_PREVIEW_INTERFACE_FAILED = WIN_MEDIA_FOUNDATION_ENGINE_GET_SINK_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_SINK_REMOVE_ALL_STREAMS_FAILED = WIN_MEDIA_FOUNDATION_SINK_QUERY_CAPTURE_PREVIEW_INTERFACE_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_CREATE_SINK_VIDEO_MEDIA_TYPE_FAILED = WIN_MEDIA_FOUNDATION_SINK_REMOVE_ALL_STREAMS_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_CONVERT_TO_VIDEO_SINK_MEDIA_TYPE_FAILED = WIN_MEDIA_FOUNDATION_CREATE_SINK_VIDEO_MEDIA_TYPE_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_SINK_ADD_STREAM_FAILED = WIN_MEDIA_FOUNDATION_CONVERT_TO_VIDEO_SINK_MEDIA_TYPE_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_SINK_SET_SAMPLE_CALLBACK_FAILED = WIN_MEDIA_FOUNDATION_SINK_ADD_STREAM_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_ENGINE_START_PREVIEW_FAILED = WIN_MEDIA_FOUNDATION_SINK_SET_SAMPLE_CALLBACK_FAILED + 1;

    public static final int WIN_MEDIA_FOUNDATION_GET_MEDIA_EVENT_STATUS_FAILED = WIN_MEDIA_FOUNDATION_ENGINE_START_PREVIEW_FAILED + 1;

    public static final int MAC_SET_CAPTURE_DEVICE_FAILED = WIN_MEDIA_FOUNDATION_GET_MEDIA_EVENT_STATUS_FAILED + 1;

    public static final int MAC_COULD_NOT_START_CAPTURE_DEVICE = MAC_SET_CAPTURE_DEVICE_FAILED + 1;

    public static final int MAC_RECEIVED_FRAME_WITH_UNEXPECTED_RESOLUTION = MAC_COULD_NOT_START_CAPTURE_DEVICE + 1;

    public static final int MAC_UPDATE_CAPTURE_RESOLUTION_FAILED = MAC_RECEIVED_FRAME_WITH_UNEXPECTED_RESOLUTION + 1;

    public static final int MAC_DECK_LINK_DEVICE_ID_NOT_FOUND_IN_THE_SYSTEM = MAC_UPDATE_CAPTURE_RESOLUTION_FAILED + 1;

    public static final int MAC_DECK_LINK_ERROR_QUERYING_INPUT_INTERFACE = MAC_DECK_LINK_DEVICE_ID_NOT_FOUND_IN_THE_SYSTEM + 1;

    public static final int MAC_DECK_LINK_ERROR_CREATING_DISPLAY_MODE_ITERATOR = MAC_DECK_LINK_ERROR_QUERYING_INPUT_INTERFACE + 1;

    public static final int MAC_DECK_LINK_COULD_NOT_FIND_A_DISPLAY_MODE = MAC_DECK_LINK_ERROR_CREATING_DISPLAY_MODE_ITERATOR + 1;

    public static final int MAC_DECK_LINK_COULD_NOT_SELECT_THE_VIDEO_FORMAT_WE_LIKE = MAC_DECK_LINK_COULD_NOT_FIND_A_DISPLAY_MODE + 1;

    public static final int MAC_DECK_LINK_COULD_NOT_START_CAPTURING = MAC_DECK_LINK_COULD_NOT_SELECT_THE_VIDEO_FORMAT_WE_LIKE + 1;

    public static final int MAC_DECK_LINK_UNSUPPORTED_PIXEL_FORMAT = MAC_DECK_LINK_COULD_NOT_START_CAPTURING + 1;

    public static final int MAC_AV_FOUNDATION_RECEIVED_AV_CAPTURE_SESSION_RUNTIME_ERROR_NOTIFICATION = MAC_DECK_LINK_UNSUPPORTED_PIXEL_FORMAT + 1;

    public static final int ANDROID_API2_ERROR_CONFIGURING_CAMERA = MAC_AV_FOUNDATION_RECEIVED_AV_CAPTURE_SESSION_RUNTIME_ERROR_NOTIFICATION + 1;

    public static final int CROS_HAL_V3_DEVICE_DELEGATE_FAILED_TO_FLUSH = ANDROID_API2_ERROR_CONFIGURING_CAMERA + 1;

    public static final int MIN_VALUE = (int) (0);
    public static final int MAX_VALUE = (int) (114);

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
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private VideoCaptureError() {}

}