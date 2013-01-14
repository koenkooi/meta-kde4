## angstrom-kde-test-image is a test image of meta-kde for angstrom
#--Requirements
#  This image was designed to work with OMAP 3530 hardware like the Beagleboard or Gumstix Overo.
#    networkmanager \
#    kde-networkmanagement \
#To be done
DESCRIPTION = "Test image for meta-kde with the Angstrom distribution"
# the _recipe_ license, the contents of the image is provided under different licenses
LICENSE = "MIT"

export IMAGE_BASENAME = "ansgstrom-kde-desktop-image"

include recipes-images/angstrom/systemd-image.bb

CONMANPKGS = ""
IMAGE_FEATURES += "package-management"
IMAGE_INSTALL += "\
    packagegroup-kde-image \
    packagegroup-kde-base \
    packagegroup-kde-apps \
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
