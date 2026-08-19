# meta-revolutionpi

This layer provides Board Support Package (BSP) metadata for KUNBUS Revolution Pi devices.


## Description

The *meta-revolutionpi* layer provides support for Revolution Pi hardware. It includes kernel configurations, device tree overlays, and specific userspace utilities required for the operation of Revolution Pi devices.

More information can be found at: <https://revolutionpi.com/en/> (Official Site)


## Dependencies

This layer depends on:

    URI: git://git.yoctoproject.org/poky
    branch: scarthgap

    URI: git://git.yoctoproject.org/meta-raspberrypi
    layers: meta-raspberrypi
    branch: scarthgap


## Adding the meta-revolutionpi layer to your build

Run `bitbake-layers add-layer meta-revolutionpi` or add it manually to your *conf/bblayers.conf*.

In your *conf/local.conf*, select one of the supported machines:

| Machine | Use case |
| --- | --- |
| `revpi` | Generic image for RevPi devices with automatic HAT EEPROM detection |
| `revpi-core-s-v1` | RevPi Core S V1.0 without a HAT EEPROM |
| `revpi-connect-s` | RevPi Connect S without a HAT EEPROM |
| `revpi-connect-se` | RevPi Connect SE without a HAT EEPROM |

For example, set `MACHINE = "revpi-core-s-v1"` for a RevPi Core S V1.0.

Build your image e. g. `bitbake core-image-base`

## Patches 

You can send patches using the GitLab merge request process.

Maintainer: KUNBUS GmbH <support@kunbus.com>
