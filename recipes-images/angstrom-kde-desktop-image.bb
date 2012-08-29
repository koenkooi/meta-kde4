DESCRIPTION = "Test image for meta-kde with the Angstrom distribution"

## angstrom-kde-test-image is a test image of meta-kde for angstrom
#--Requirements
#  This image was designed to work with OMAP 3530 hardware like the Beagleboard or Gumstix Overo.


include recipes-images/angstrom/systemd-image.bb

CONMANPKGS=""

export IMAGE_BASENAME = "ansgstrom-kde-desktop-image"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
    task-kde-image \
    task-kde-base \
    task-kde-apps \
    \
    plasma-startscript \
    \
    oxygen-icons \
    oxygen-fonts \
    kde-wallpapers \
    \
    udisks-systemd \
    \
    \
    ntp-systemd \
"

#    networkmanager \
#    kde-networkmanagement \
#To be done

# the _recipe_ license, the contents of the image is provided under different licenses
LICENSE = "MIT"