DESCRIPTION = "Firmware for RevPi exentsion modules"

LICENSE = "BSD-3-Clause & GPL-2.0-or-later"
SECTION = "kernel"
LIC_FILES_CHKSUM = "\
    file://LICENSES/BSD-3-Clause.txt;md5=4e91b9e6ef320f74590c8c7a64a9188a \
    file://LICENSES/GPL-2.0-or-later.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    "
SRCREV_orig = "9bb01e6c5ad63b96759d12049d3061edc65b0f84"

SRC_URI = "git://gitlab.com/revolutionpi/revpi-firmware.git;name=orig;branch=master;protocol=https \
           "

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/revpi/
    cp -r ${S}/*.fwu ${D}${nonarch_base_libdir}/firmware/revpi/
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/revpi"
