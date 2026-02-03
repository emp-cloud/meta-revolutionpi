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

In your *conf/local.conf* set `MACHINE = "revpi"`

Build your image e. g. `bitbake core-image-base`

## Patches 

You can send patches using the GitLab merge request process.

Maintainer: Erik Sallmann <e.sallmann@kunbus.com>