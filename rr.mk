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

$(call inherit-product, device/lenovo/kuntao/full_kuntao.mk)

# Inherit RR's custom product configuration
$(call inherit-product, vendor/rr/config/common_full_phone.mk)

PRODUCT_NAME := lineage_kuntao
BOARD_VENDOR := Lenovo

PRODUCT_GMS_CLIENTID_BASE := android-lenovo

PRODUCT_BUILD_PROP_OVERRIDES += \
	    PRIVATE_BUILD_DESC="kuntao_row-user 7.0 NRD90N P2a42_S251_171107_ROW release-keys" 

# Set BUILD_FINGERPRINT variable to be picked up by both system and vendor build.prop
BUILD_FINGERPRINT := "Lenovo/kuntao_row/P2a42:7.0/NRD90N/P2a42_S251_171107_ROW:user/release-keys"
