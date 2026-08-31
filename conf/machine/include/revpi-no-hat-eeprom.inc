MACHINEOVERRIDES =. "revpi:"
require conf/machine/revpi.conf

RPI_EXTRA_CONFIG:append = "\n# Load the ${REVPI_DT_OVERLAY} device tree overlay\ndtoverlay=${REVPI_DT_OVERLAY}\n"

# These devices have no HAT EEPROM, so they need their own product-specific
# dt-blob.bin instead of the generic HAT-EEPROM one installed by revpi.conf.
IMAGE_BOOT_FILES:remove = " revpi-dt-blob.dtbo;dt-blob.bin"
IMAGE_BOOT_FILES:append = " ${REVPI_DT_OVERLAY}-dt-blob.dtbo;dt-blob.bin"
RPI_KERNEL_DEVICETREE = "broadcom/bcm2711-rpi-cm4s.dtb"
