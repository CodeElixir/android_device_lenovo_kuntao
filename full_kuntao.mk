#
# Copyright (C) 2017 The LineageOS Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Product common configurations
# 64-bit support
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)

# Inherit from the common Open Source product configuration
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/languages_full.mk)

# Inherit from hardware-specific part of the product configuration
$(call inherit-product, device/lenovo/kuntao/device.mk)

# Release name
PRODUCT_RELEASE_NAME := kuntao

EXTENDED_FONT_FOOTPRINT := true

# Device identifier. This must come after all inclusions
TARGET_VENDOR := Lenovo
PRODUCT_DEVICE := kuntao
PRODUCT_NAME := full_kuntao
PRODUCT_BRAND := Lenovo
PRODUCT_MODEL := Lenovo P2
PRODUCT_MANUFACTURER := Lenovo

PRODUCT_DEFAULT_LANGUAGE := en
PRODUCT_DEFAULT_REGION   := US