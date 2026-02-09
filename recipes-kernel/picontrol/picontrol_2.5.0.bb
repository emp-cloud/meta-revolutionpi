SUMMARY = "Kernel module for piControl"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://src/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

SRC_URI = "git://gitlab.com/kunbuserik/piControl.git;protocol=https;branch=master"
SRCREV = "3419c76af3b5dc3b0aef39855ff99ea27a4fd5ed"

S = "${WORKDIR}/git"

PREFERRED_PROVIDER_virtual/kernel = "linux-revpi"
REQUIRED_VERSION_linux-revpi = "6.12%"

# Use KDIR instead of KERNEL_SRC
EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR}"

# load module on boot
KERNEL_MODULE_AUTOLOAD += "piControl"

