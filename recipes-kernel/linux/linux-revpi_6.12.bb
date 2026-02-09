LINUX_VERSION ?= "6.12.56-revpi1"
LINUX_RPI_BRANCH ?= "revpi-6.12"
LINUX_RPI_KMETA_BRANCH ?= "yocto-6.12"

SRCREV_machine = "ab01681ab5652c603a2cebe425f9cc739fac44fc"
SRCREV_meta = "3f0dcb29edf14029f130bc493a939b67ea27852e"

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

do_deploy:append() {
    # Falls du ARM64 baust, wäre es:
    src="${B}/arch/arm64/boot/dts/overlays/hat_map.dtb"

    if [ -f "$src" ]; then
        install -m 0644 "$src" "${DEPLOYDIR}/hat_map.dtb"
    else
        bbwarn "hat_map.dtb not found at $src"
    fi
}

DEPLOYDEP = ""
do_deploy[depends] += "${DEPLOYDEP}"
