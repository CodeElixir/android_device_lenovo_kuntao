/*
 * Copyright (C) 2014 The CyanogenMod Project
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

package org.lineageos.hardware;

import com.synaptics.fingerprint.Fingerprint;

import org.lineageos.internal.util.FileUtils;

/*
 * Disable fingerprint gestures
 */
public class KeyDisabler {
    private static Fingerprint sFingerprint = new Fingerprint(null);
    private static String CONTROL_PATH = "/sys/homebutton/enable";

    public static boolean isSupported() {
        return FileUtils.isFileWritable(CONTROL_PATH);
    }

    public static boolean isActive() {
        return (FileUtils.readOneLine(CONTROL_PATH).equals("0") && Fingerprint.isNavEnabled());
    }

    public static boolean setActive(boolean state) {
    	Log.i("KeyDisabler", "setActive " + state);
        return Fingerprint.enableNav(!state) == 0;
    }
}
