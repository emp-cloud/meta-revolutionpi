LINUX_VERSION ?= "6.18.57-revpi0"
LINUX_RPI_BRANCH ?= "revpi-6.18"
LINUX_RPI_KMETA_BRANCH ?= "yocto-6.18"

SRCREV_machine = "494b36568711263bca1049e0c2bd3057479efaeb"
SRCREV_meta = "cf1eb35154969907fb08e980fe6d1881c97d6a97"

KMETA = "kernel-meta"

SRC_URI = " \
    git://gitlab.com/revolutionpi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    "

require recipes-kernel/linux/linux-raspberrypi.inc

KBUILD_DEFCONFIG:revpi ?= "revpi-v8_defconfig"

FILESEXTRAPATHS:prepend := "${THISDIR}/../../../meta-raspberrypi/recipes-kernel/linux/files:"

KERNEL_DTC_FLAGS += "-@ -H epapr"
