DESCRIPTION = "Revolution Pi Base Files" 

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=3d26203303a722dedc6bf909d95ba815"

SRC_URI = "https://packages.revolutionpi.de/pool/main/r/revpi-base-files/revpi-base-files_4.1.2.orig.tar.gz;name=orig \
           file://revpi_mac.patch \
           file://0001-disable-interfaces-install.patch \
           file://0002-man-look-up-scdoc-as-native-dependency.patch \
           file://0003-setup_cpu_affinity-port-to-POSIX-sh.patch \
           file://50-revpi.patch \
           file://revpi-mac@.service \
           file://10-disable-pibridge.network \
           "

SRC_URI[orig.sha256sum] = "87a0c58bd2e362e9f49756001eab72099207e76bba330900530a519f3c210dea"

inherit meson pkgconfig systemd features_check

REQUIRED_DISTRO_FEATURES = "systemd"

EXTRA_OEMESON += "-Dtests=disabled -Dman-pages=enabled"

SYSTEMD_SERVICE:${PN} = "revpi-mac@.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

# scdoc needed to generate manpages
DEPENDS += "systemd scdoc-native"

do_install:append() {
    # systemd unit
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/revpi-mac@.service ${D}${systemd_system_unitdir}/

    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-disable-pibridge.network \
        ${D}${sysconfdir}/systemd/network/
}

# Add example script for revpi compact led control to default package
FILES:${PN}-doc:remove = "${docdir}"
FILES:${PN} += " \
                ${systemd_system_unitdir}/* \
                ${systemd_unitdir}/logind.conf.d \
                ${systemd_unitdir}/journald.conf.d \
                ${docdir} \
                "
