SUMMARY = "Kernel module for piControl"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://src/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

SRC_URI = "git://gitlab.com/revolutionpi/piControl.git;protocol=https;branch=master"

SRCREV = "7980b36f361a8c31680dbd1cbc8d567a7afa4a38"

S = "${WORKDIR}/git"

# Use KDIR instead of KERNEL_SRC
EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR}"

# load module on boot
KERNEL_MODULE_AUTOLOAD += "piControl"

