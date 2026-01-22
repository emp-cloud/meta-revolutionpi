
do_install:append() {
        ln -s ../cypress/cyfmac43455-sdio-standard.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.bin
        ln -s ../cypress/cyfmac43455-sdio.clm_blob ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.clm_blob
}
