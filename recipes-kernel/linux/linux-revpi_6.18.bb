LINUX_VERSION ?= "6.18.57-revpi0"
LINUX_RPI_BRANCH ?= "revpi-6.18"
LINUX_RPI_KMETA_BRANCH ?= "yocto-6.18"

SRCREV_machine = "494b36568711263bca1049e0c2bd3057479efaeb"
SRCREV_meta = "cf1eb35154969907fb08e980fe6d1881c97d6a97"

KMETA = "kernel-meta"

SRC_URI = " \
    git://gitlab.com/revolutionpi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA};protocol=https \
    "

require recipes-kernel/linux/linux-raspberrypi.inc

KBUILD_DEFCONFIG:revpi ?= "revpi-v8_defconfig"

# The fragments added by linux-raspberrypi.inc live next to it
FILESEXTRAPATHS:prepend := "${@os.path.dirname(bb.utils.which(d.getVar('BBPATH'), 'recipes-kernel/linux/linux-raspberrypi.inc'))}/files:"

KERNEL_DTC_FLAGS += "-@ -H epapr"
