/*
 * Copyright (c) 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.car.hvac;

import android.car.hardware.CarPropertyConfig;
import android.car.hardware.hvac.CarHvacManager;
import android.content.Context;

import java.util.List;

public class HvacPolicy {
    private float mMaxHardwareTemp;
    private float mMinHardwareTemp;
    private int mMaxHardwareFanSpeed;

    private final boolean mHardwareUsesCelsius;
    private final boolean mUserUsesCelsius;

    public HvacPolicy(Context context, List<CarPropertyConfig> properties) {
        //TODO handle max / min per each zone
        for (CarPropertyConfig config : properties) {
            switch (config.getPropertyId()) {
                case CarHvacManager.ID_ZONED_FAN_SPEED_SETPOINT: {
                    // 因为我们使用一个最大值来表示所有区域，所以应该找到所有区域的风扇转速的最小最大值。
                    mMaxHardwareFanSpeed = Integer.MAX_VALUE;
                    for(int areaId : config.getAreaIds()) {
                        Integer newValue = (Integer) config.getMaxValue(areaId);
                        if (newValue != null && newValue < mMaxHardwareFanSpeed) {
                            mMaxHardwareFanSpeed = newValue;
                        }
                    }
                } break;

                case CarHvacManager.ID_ZONED_TEMP_SETPOINT: {
                    // 因为我们使用一个最大值和一个最小值来表示所有区域，所以它应该找到所有区域的最小最大值和最大最小温度值。
                    mMaxHardwareTemp = Float.MAX_VALUE;
                    mMinHardwareTemp = -Float.MAX_VALUE;
                    for(int areaId : config.getAreaIds()) {
                        Float newValue = (Float) config.getMaxValue(areaId);
                        if (newValue != null && newValue < mMaxHardwareTemp) {
                            mMaxHardwareTemp = newValue;
                        }
                        newValue = (Float) config.getMinValue(areaId);
                        if (newValue != null && newValue > mMinHardwareTemp) {
                            mMinHardwareTemp = newValue;
                        }
                    }
                } break;
            }
        }

        mHardwareUsesCelsius = context.getResources().getBoolean(R.bool.config_hardwareUsesCelsius);
        mUserUsesCelsius = context.getResources().getBoolean(R.bool.config_userUsesCelsius);
    }

    public float userToHardwareTemp(int temp) {
        if (!mUserUsesCelsius && mHardwareUsesCelsius) {
            return fahrenheitToCelsius(temp);
        }

        if (mUserUsesCelsius && !mHardwareUsesCelsius) {
            return celsiusToFahrenheit(temp);
        }

        return temp;
    }

    public int hardwareToUserTemp(float temp) {
        if (mHardwareUsesCelsius && !mUserUsesCelsius) {
            return (int) celsiusToFahrenheit(temp);
        }

        if (!mHardwareUsesCelsius && mUserUsesCelsius) {
            return (int) fahrenheitToCelsius(temp);
        }

        return (int) temp;
    }

    // 摄氏转华氏
    private float celsiusToFahrenheit(float c) {
        return c * 9 / 5 + 32;
    }

    // 华氏转摄氏
    private float fahrenheitToCelsius(float f) {
        return (f - 32) * 5 / 9;
    }

    public int userToHardwareFanSpeed(int speed) {
        return getMaxHardwareFanSpeed() * speed / 100;
    }

    public int hardwareToUserFanSpeed(int speed) {
        return speed * 100 / getMaxHardwareFanSpeed();
    }

    public int getMaxHardwareFanSpeed() {
        return mMaxHardwareFanSpeed;
    }

    public float getMaxHardwareTemp() {
        return mMaxHardwareTemp;
    }

    public float getMinHardwareTemp() {
        return mMinHardwareTemp;
    }
}
