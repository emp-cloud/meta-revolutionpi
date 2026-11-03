FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:revpi = " file://extra.cfg"

PACKAGE_ARCH:revpi = "${MACHINE_ARCH}"
