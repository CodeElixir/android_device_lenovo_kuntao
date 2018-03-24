/*
 * Copyright (C) 2016 The CyanogenMod Project
 * Copyright (C) 2017 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device.actions;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import org.lineageos.settings.device.util.FileUtils;

public class Constants {

    public static final boolean DEBUG = false;

    private static final String TAG = "LineageActions";

    // FP actions
    public static final int ACTION_HOME = 100;
    public static final int ACTION_POWER = 101;
    public static final int ACTION_BACK = 102;
    public static final int ACTION_RECENTS = 103;
    public static final int ACTION_VOLUME_UP = 104;
    public static final int ACTION_VOLUME_DOWN = 105;
    public static final int ACTION_VOICE_ASSISTANT = 106;
    public static final int ACTION_PLAY_PAUSE = 107;
    public static final int ACTION_PREVIOUS_TRACK = 108;
    public static final int ACTION_NEXT_TRACK = 109;
    public static final int ACTION_FLASHLIGHT = 110;
    public static final int ACTION_CAMERA = 111;
    public static final int ACTION_SCREENSHOT = 112;
    public static final int ACTION_BROWSER = 116;
    public static final int ACTION_DIALER = 117;
    public static final int ACTION_EMAIL = 118;
    public static final int ACTION_MESSAGES = 119;
    public static final int ACTION_LAST_APP = 121;
    public static final int[] sFPSupportedActions = new int[]{
            ACTION_HOME,
            ACTION_POWER,
            ACTION_BACK,
            ACTION_RECENTS,
            ACTION_VOLUME_UP,
            ACTION_VOLUME_DOWN,
            ACTION_VOICE_ASSISTANT,
            ACTION_PLAY_PAUSE,
            ACTION_PREVIOUS_TRACK,
            ACTION_NEXT_TRACK,
            ACTION_FLASHLIGHT,
            ACTION_CAMERA,
            ACTION_SCREENSHOT,
            ACTION_LAST_APP
    };
    public static final int[] sFPSupportedActionsScreenOff = new int[]{
            ACTION_POWER,
            ACTION_VOLUME_UP,
            ACTION_VOLUME_DOWN,
            ACTION_PLAY_PAUSE,
            ACTION_PREVIOUS_TRACK,
            ACTION_NEXT_TRACK,
            ACTION_FLASHLIGHT,
            ACTION_CAMERA
    };

    // Screen off gestures
    public static final int GESTURE_SWIPE_RIGHT_SCANCODE = 622;
    public static final int GESTURE_SWIPE_LEFT_SCANCODE = 623;
    public static final int GESTURE_SWIPE_DOWN_SCANCODE = 624;
    public static final int GESTURE_SWIPE_UP_SCANCODE = 625;
    public static final int GESTURE_DOUBLE_TAP_SCANCODE = 626;
    public static final int[] sSupportedScreenOffGestures = new int[]{
            GESTURE_SWIPE_RIGHT_SCANCODE,
            GESTURE_SWIPE_LEFT_SCANCODE,
            GESTURE_SWIPE_DOWN_SCANCODE,
            GESTURE_SWIPE_UP_SCANCODE,
            GESTURE_DOUBLE_TAP_SCANCODE
    };
    public static final int[] sScreenOffSupportedActions = new int[]{
            ACTION_POWER,
            ACTION_PLAY_PAUSE,
            ACTION_PREVIOUS_TRACK,
            ACTION_NEXT_TRACK,
            ACTION_FLASHLIGHT,
            ACTION_CAMERA,
            ACTION_BROWSER,
            ACTION_DIALER,
            ACTION_EMAIL,
            ACTION_MESSAGES
    };

    // List of screen off gestures keys
    public static final String GESTURE_SWIPE_RIGHT = "screen_off_gestures_swipe_right";
    public static final String GESTURE_SWIPE_LEFT = "screen_off_gestures_swipe_left";
    public static final String GESTURE_SWIPE_DOWN = "screen_off_gestures_swipe_down";
    public static final String GESTURE_SWIPE_UP = "screen_off_gestures_swipe_up";

    // Screen off gestures nodes
    public static final String GESTURE_SWIPE_RIGHT_NODE = "/sys/android_touch/gesture_swipe_right";
    public static final String GESTURE_SWIPE_LEFT_NODE = "/sys/android_touch/gesture_swipe_left";
    public static final String GESTURE_SWIPE_DOWN_NODE = "/sys/android_touch/gesture_swipe_down";
    public static final String GESTURE_SWIPE_UP_NODE = "/sys/android_touch/gesture_swipe_up";
    public static final String GESTURE_DOUBLE_TAP_NODE = "/sys/board_properties/tpd_suspend_status";
    
    // Screen off gestures haptic
    public static final String KEY_GESTURE_ENABLE_HAPTIC_FEEDBACK = "screen_off_gesture_haptic_feedback";
    public static final String KEY_GESTURE_ENABLE_PROXIMITY_SENSOR = "screen_off_gesture_proximity_sensor";

    // Holds <preference_key> -> <proc_node> mapping
    public static final Map<String, String> sBooleanNodePreferenceMap = new HashMap<>();

    // Holds <preference_key> -> <default_values> mapping
    public static final Map<String, Object> sNodeDefaultMap = new HashMap<>();

    public static final String[] sPrefKeys = {
        GESTURE_SWIPE_RIGHT,
        GESTURE_SWIPE_LEFT,
        GESTURE_SWIPE_DOWN,
        GESTURE_SWIPE_UP
    };

    static {
        sBooleanNodePreferenceMap.put(GESTURE_SWIPE_RIGHT, GESTURE_SWIPE_RIGHT_NODE);
        sBooleanNodePreferenceMap.put(GESTURE_SWIPE_LEFT, GESTURE_SWIPE_LEFT_NODE);
        sBooleanNodePreferenceMap.put(GESTURE_SWIPE_DOWN, GESTURE_SWIPE_DOWN_NODE);
        sBooleanNodePreferenceMap.put(GESTURE_SWIPE_UP, GESTURE_SWIPE_UP_NODE);
        sNodeDefaultMap.put(GESTURE_SWIPE_RIGHT, "0");
        sNodeDefaultMap.put(GESTURE_SWIPE_LEFT, "0");
        sNodeDefaultMap.put(GESTURE_SWIPE_DOWN, "0");
        sNodeDefaultMap.put(GESTURE_SWIPE_UP, "0");
    }

    public static boolean isPreferenceEnabled(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, (Boolean) sNodeDefaultMap.get(key));
    }

    public static String GetPreference(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, (String) sNodeDefaultMap.get(key));
    }

    public static void writePreference(Context context, String pref) {

        String value = "1";

        if (!pref.equals(GESTURE_SWIPE_RIGHT) && !pref.equals(GESTURE_SWIPE_LEFT) && !pref.equals(GESTURE_SWIPE_DOWN) && !pref.equals(GESTURE_SWIPE_UP))
            value = isPreferenceEnabled(context, pref) ? "1" : "0";
        else
            value = GetPreference(context, pref);

        String node = sBooleanNodePreferenceMap.get(pref);

        if (!FileUtils.writeLine(node, value)) {
            Log.w(TAG, "Write " + value + " to node " + node +
                "failed while restoring saved preference values");
        }
    }
}
