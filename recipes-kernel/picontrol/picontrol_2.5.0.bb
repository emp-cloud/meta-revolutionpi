SUMMARY = "Kernel module for piControl"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://src/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

SRC_URI = "git://gitlab.com/revolutionpi/piControl.git;protocol=https;branch=master \
           file://0001-Add-modules_install-target-to-Makefile.patch \
           "

SRCREV = "417c4c01b5c2904c8917c6f5ca058af095a27e96"

S = "${WORKDIR}/git"

PREFERRED_PROVIDER_virtual/kernel = "linux-revpi"
REQUIRED_VERSION_linux-revpi = "6.12%"

# Use KDIR instead of KERNEL_SRC
EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR}"

# load module on boot
KERNEL_MODULE_AUTOLOAD += "piControl"

