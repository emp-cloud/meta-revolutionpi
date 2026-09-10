SUMMARY = "Firmware for NXP IW416 wireless devices"
DESCRIPTION = "NXP IW416 combo firmware used by the RevPi Flat S"
HOMEPAGE = "https://gitlab.com/revolutionpi/imx-firmware"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ca53281cc0caa7e320d4945a896fb837"

SRC_URI = "git://gitlab.com/revolutionpi/imx-firmware.git;protocol=https;branch=upstream"
SRCREV = "2978f3c88d6bcc5695a7b45f1936f18d31eebfa8"

S = "${WORKDIR}/git"

inherit allarch

do_compile[noexec] = "1"

do_install() {
    install -Dm 0644 \
        ${S}/nxp/FwImage_IW416_SD/sdiouartiw416_combo_v0.bin \
        ${D}${nonarch_base_libdir}/firmware/mrvl/sdiouartiw416_combo_v0.bin
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/mrvl/sdiouartiw416_combo_v0.bin"
