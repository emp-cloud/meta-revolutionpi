DESCRIPTION = "Revolution Pi Base Files" 

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=3d26203303a722dedc6bf909d95ba815"

SRC_URI = "https://packages.revolutionpi.de/pool/main/r/revpi-base-files/revpi-base-files_1.3.0.orig.tar.gz;name=orig \
           file://revpi_mac.patch \
           "

SRC_URI[orig.sha256sum] = "882c49b69a77cb8a989200a94b6f5e52ff23f791b701f64d29af3c241422cfcf"

inherit cmake pkgconfig

# scdoc needed to generate manpages
DEPENDS += "systemd scdoc-native"

# Add example script for revpi compact led control to default package
FILES:${PN}-doc:remove = "${docdir}"
FILES:${PN} += " \
                ${systemd_system_unitdir}/* \
                ${docdir} \
                "
