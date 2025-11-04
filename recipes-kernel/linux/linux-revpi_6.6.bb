LINUX_VERSION ?= "6.6.84"
LINUX_RPI_BRANCH ?= "revpi-6.6"
LINUX_RPI_KMETA_BRANCH ?= "yocto-6.6"

SRCREV_machine = "fe0aa6034a477f1ee3c68843beebbf31b4c0c8cb"
SRCREV_meta = "52ff0d75713ce61962b325a2090bd55e216f0cf3"

SRC_URI[machine.sha256sum] = "c1582b9a200a38e23481facc0427b80fd40e9bf2ab7d18893b8518ee8729f595"

KMETA = "kernel-meta"

SRC_URI = " \
    git://gitlab.com/revolutionpi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    file://powersave.cfg \
    file://android-drivers.cfg \
    "

require recipes-kernel/linux/linux-raspberrypi.inc

KBUILD_DEFCONFIG:revpi ?= "revpi-v8_defconfig"

FILESEXTRAPATHS:prepend := "${THISDIR}/../../../meta-raspberrypi/recipes-kernel/linux/files:"

KERNEL_DTC_FLAGS += "-@ -H epapr"

DEPLOYDEP = ""
do_deploy[depends] += "${DEPLOYDEP}"
