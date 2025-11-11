SUMMARY = "Kernel module for piControl"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://src/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

SRC_URI = "git://gitlab.com/revolutionpi/piControl.git;protocol=https;branch=master"
SRCREV = "a193da23444466592ab53523eda8e657a59fd6e5"
PV = "2.3.7"

S = "${WORKDIR}/git"

DEPENDS += "virtual/kernel"

PREFERRED_PROVIDER_virtual/kernel = "linux-revpi"

# Dem Buildsystem sagen, dass es KDIR statt KERNEL_SRC verwenden soll
EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_BUILDDIR}"

MODULES_MODULE_TARGET = "modules"
MODULES_INSTALL_TARGET = ""

# Optional: Modul beim Boot laden
KERNEL_MODULE_AUTOLOAD += "piControl"

do_install:append() {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/extra
    install -m 0644 ${S}/piControl.ko ${D}/lib/modules/${KERNEL_VERSION}/extra/
}

