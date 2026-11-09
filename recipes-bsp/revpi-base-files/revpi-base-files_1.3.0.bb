DESCRIPTION = "Revolution Pi Base Files" 

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=3d26203303a722dedc6bf909d95ba815"

SRC_URI = "https://packages.revolutionpi.de/pool/main/r/revpi-base-files/revpi-base-files_1.3.0.orig.tar.gz;name=orig \
           file://revpi_mac.patch \
           file://0001-disable-interfaces-install.patch \
           file://50-revpi.patch \
           file://revpi-mac@.service \
           file://10-disable-pibridge.network \
           "

SRC_URI[orig.sha256sum] = "882c49b69a77cb8a989200a94b6f5e52ff23f791b701f64d29af3c241422cfcf"

inherit cmake pkgconfig systemd features_check

REQUIRED_DISTRO_FEATURES = "systemd"

SYSTEMD_SERVICE:${PN} = "revpi-mac@.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

# scdoc needed to generate manpages
DEPENDS += "systemd scdoc-native"

do_install:append() {
    # systemd unit
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/revpi-mac@.service ${D}${systemd_system_unitdir}/

    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${UNPACKDIR}/10-disable-pibridge.network \
        ${D}${sysconfdir}/systemd/network/
}

# Add example script for revpi compact led control to default package
FILES:${PN}-doc:remove = "${docdir}"
FILES:${PN} += " \
                ${systemd_system_unitdir}/* \
                ${docdir} \
                "
