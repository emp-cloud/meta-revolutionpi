FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Scarthgap's Kconfiglib cannot parse Linux 6.18's transitional symbols.
SRC_URI += "file://0001-tools-Kconfiglib-add-support-for-transitional-attribut.patch"
