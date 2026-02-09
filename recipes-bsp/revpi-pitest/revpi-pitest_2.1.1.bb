SUMMARY = "Revpi piTest allows reading and writing to the I/O and gateway modules attached to a RevPi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT.txt;md5=7dda4e90ded66ab88b86f76169f28663"

# Git URL with submodule support
SRC_URI = "gitsm://gitlab.com/revolutionpi/revpi-pitest.git;protocol=https;branch=master \
           "

# Git Revision for tag 2.1.1
SRCREV = "59a06c00929a8803e97669edfaea2314c9842053"

# set source path
S = "${WORKDIR}/git"

# activate CMake support
inherit cmake

DEPENDS += "scdoc-native"

do_install:append() {
    cd ${D}${bindir}
    ln -sf piTest piControlReset
}
