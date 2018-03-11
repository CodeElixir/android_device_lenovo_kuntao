start_copying_prebuilt_qcril_db()
{
    if [ -f /vendor/radio/qcril_database/qcril.db -a ! -f /data/vendor/radio/qcril.db ]; then
        cp /vendor/radio/qcril_database/qcril.db /data/vendor/radio/qcril.db
        chown -h radio.radio /data/vendor/radio/qcril.db
    fi
}

echo 1 > /proc/sys/net/ipv6/conf/default/accept_ra_defrtr

#
# Copy qcril.db if needed for RIL
#
start_copying_prebuilt_qcril_db
echo 1 > /data/vendor/radio/db_check_done

#
# Make modem config folder and copy firmware config to that folder for RIL
#
if [ -f /data/vendor/radio/ver_info.txt ]; then
    prev_version_info=`cat /data/vendor/radio/ver_info.txt`
else
    prev_version_info=""
fi

cur_version_info=`cat /firmware/verinfo/ver_info.txt`
if [ ! -f /firmware/verinfo/ver_info.txt -o "$prev_version_info" != "$cur_version_info" ]; then
    rm -rf /data/vendor/radio/modem_config
    mkdir /data/vendor/radio/modem_config
    chmod 770 /data/vendor/radio/modem_config
    cp  /firmware/image/modem_pr/mcfg/configs/mbn_ota.txt /data/vendor/radio/modem_config/mbn_ota.txt
    cp  /firmware/image/modem_pr/mcfg/configs/mcfg_sw/generic/apac/reliance/commerci/mcfg_sw.mbn /data/vendor/radio/modem_config/rjil.mbn
    cp  /firmware/image/modem_pr/mcfg/configs/mcfg_sw/generic/eu/3uk/3uk/mcfg_sw.mbn /data/vendor/radio/modem_config/3uk_gb.mbn
    cp  /firmware/image/modem_pr/mcfg/configs/mcfg_sw/generic/sea/smartfre/commerci/mcfg_sw.mbn /data/vendor/radio/modem_config/smartfren.mbn
    cp  /firmware/image/modem_pr/mcfg/configs/mcfg_sw/generic/sea/ytl/gen_3gpp/mcfg_sw.mbn /data/vendor/radio/modem_config/ytl.mbn
    cp  /firmware/image/modem_pr/mcfg/configs/mcfg_sw/generic/common/gcf/gen_3gpp/mcfg_sw.mbn /data/vendor/radio/modem_config/gcf.mbn
    cp  /firmware/image/modem_pr/mcfg/configs/mcfg_sw/generic/row/default/gen_3gpp/mcfg_sw.mbn /data/vendor/radio/modem_config/row.mbn
    chown -hR radio.radio /data/vendor/radio/modem_config
    cp /firmware/verinfo/ver_info.txt /data/vendor/radio/ver_info.txt
    chown radio.radio /data/vendor/radio/ver_info.txt
fi
cp /firmware/image/modem_pr/mbn_ota.txt /data/vendor/radio/modem_config
chown radio.radio /data/vendor/radio/modem_config/mbn_ota.txt
echo 1 > /data/vendor/radio/copy_complete

# Check build variant for printk logging
# Current default minimum boot-time-default
buildvariant=`getprop ro.build.type`
case "$buildvariant" in
    "userdebug" | "eng")
        #set default loglevel to KERN_INFO
        echo "6 6 1 7" > /proc/sys/kernel/printk
        ;;
    *)
        #set default loglevel to KERN_WARNING
        echo "4 4 1 4" > /proc/sys/kernel/printk
        ;;
esac
