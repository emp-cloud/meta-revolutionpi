ENABLE_DWC2_HOST:revpi = "1"
# Enable DRM VC4 V3D driver
RPI_EXTRA_CONFIG:append:revpi = "\nmax_framebuffers=1\n"
RPI_EXTRA_CONFIG:append:revpi = "\n## Run in 64-bit mode"
RPI_EXTRA_CONFIG:append:revpi = "\narm_64bit=1\n"
RPI_EXTRA_CONFIG:append:revpi = "\n# Run as fast as firmware / board allows"
RPI_EXTRA_CONFIG:append:revpi = "\narm_boost=1\n"
RPI_EXTRA_CONFIG:append:revpi = "\n# Don't have the firmware create an initial video= setting in cmdline.txt."
RPI_EXTRA_CONFIG:append:revpi = "\n# Use the kernel's default instead."
RPI_EXTRA_CONFIG:append:revpi = "\ndisable_fw_kms_setup=1"

do_deploy:append:revpi() {
    echo "# have a properly sized image" >> $CONFIG
    echo "disable_overscan=1" >> $CONFIG

    echo "" >> $CONFIG

    echo "# Enable audio (loads snd_bcm2835)" >> $CONFIG
    echo "dtparam=audio=on" >> $CONFIG
}

