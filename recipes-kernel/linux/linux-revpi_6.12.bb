LINUX_VERSION ?= "6.12.91-revpi0"
LINUX_RPI_BRANCH ?= "revpi-6.12"
LINUX_RPI_KMETA_BRANCH ?= "yocto-6.12"

SRCREV_machine = "756591ec4845ec0114ee7a3a99768f69bcd8bed3"
SRCREV_meta = "3f0dcb29edf14029f130bc493a939b67ea27852e"

KMETA = "kernel-meta"

SRC_URI = " \
    git://gitlab.com/revolutionpi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    "

require recipes-kernel/linux/linux-raspberrypi.inc

KBUILD_DEFCONFIG:revpi ?= "revpi-v8_defconfig"

FILESEXTRAPATHS:prepend := "${THISDIR}/../../../meta-raspberrypi/recipes-kernel/linux/files:"

KERNEL_DTC_FLAGS += "-@ -H epapr"
