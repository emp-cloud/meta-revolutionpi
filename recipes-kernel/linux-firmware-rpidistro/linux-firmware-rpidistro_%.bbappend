# RevPi uses the standard variant, like upstream does for raspberrypi5
CYFMAC43455_SDIO_FIRMWARE:revpi ??= "standard"

do_install:append:revpi() {
        ln -sf ../cypress/cyfmac43455-sdio.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.bin
        ln -sf ../cypress/cyfmac43455-sdio.clm_blob ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.clm_blob
}
