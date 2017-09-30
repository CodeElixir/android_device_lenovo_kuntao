# Basic apps
PRODUCT_PACKAGES += \
    Stk \
    Torch \
    Snap \
    Jelly  

# FMRadio
PRODUCT_PACKAGES += \
    FMRadio

# exFAT
PRODUCT_PACKAGES += \
    mount.exfat \
    fsck.exfat \
    mkfs.exfat

# NTFS
PRODUCT_PACKAGES += \
    fsck.ntfs \
    mkfs.ntfs \
    mount.ntfs

# Filesystem management tools
PRODUCT_PACKAGES += \
    e2fsck \
    fibmap.f2fs \
    fsck.f2fs \
    mkfs.f2fs \
    make_ext4fs \
    resize2fs \
	setup_fs \
	ext4_resize \
    resize_ext4 \
	superumount 
	
# USB
PRODUCT_PACKAGES += \
    com.android.future.usb.accessory

# WallpaperPicker
PRODUCT_PACKAGES += \
    WallpaperPicker

 # Live Display
 PRODUCT_PACKAGES += \
 	libjni_livedisplay

# Bootanimation
#PRODUCT_COPY_FILES += \
    device/lenovo/kuntao/prebuilt/bootanimation/bootanimation.zip:system/media/bootanimation.zip

PRODUCT_BUILD_PROP_OVERRIDES += BUILD_UTC_DATE=0

# Doze
#PRODUCT_PACKAGES += \
    LenovoDoze
