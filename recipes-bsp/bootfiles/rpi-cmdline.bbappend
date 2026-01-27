# Beispiel: Den Root-Pfad oder Dateisystemtyp ändern
CMDLINE_ROOTFS_FSTYPE:append = " fsck.repair=yes"

# Oder zusätzliche Parameter erzwingen
CMDLINE:append = " console=tty1 nosplash plymouth.ignore-serial-consoles"
