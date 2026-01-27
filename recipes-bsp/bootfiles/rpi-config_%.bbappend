ENABLE_DWC2_HOST = "1"
# Enable DRM VC4 V3D driver
RPI_EXTRA_CONFIG:append = "\nmax_framebuffers=1\n"
RPI_EXTRA_CONFIG:append = "\n## Run in 64-bit mode"
RPI_EXTRA_CONFIG:append = "\narm_64bit=1\n"
RPI_EXTRA_CONFIG:append = "\n# Run as fast as firmware / board allows"
RPI_EXTRA_CONFIG:append = "\narm_boost=1\n"
RPI_EXTRA_CONFIG:append = "\n# Don't have the firmware create an initial video= setting in cmdline.txt."
RPI_EXTRA_CONFIG:append = "\n# Use the kernel's default instead."
RPI_EXTRA_CONFIG:append = "\ndisable_fw_kms_setup=1"

do_deploy:append() {
    echo "# have a properly sized image" >> $CONFIG
    echo "disable_overscan=1" >> $CONFIG

    echo "" >> $CONFIG

    echo "# Enable audio (loads snd_bcm2835)" >> $CONFIG
    echo "dtparam=audio=on" >> $CONFIG
}

