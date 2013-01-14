## angstrom-kde-test-image is a test image of meta-kde for angstrom
#--Requirements
#  This image was designed to work with OMAP 3530 hardware like the Beagleboard or Gumstix Overo.
DESCRIPTION = "Test image for meta-kde with the Angstrom distribution"
LICENSE = "MIT"

export IMAGE_BASENAME = "ansgstrom-kde-active-image"

include recipes-images/angstrom/systemd-image.bb

IMAGE_FEATURES += "package-management"
IMAGE_INSTALL += "\
    packagegroup-kde-image \
    packagegroup-kde-base \
    packagegroup-kde-active \
    \
    oxygen-icons \
    oxygen-fonts \
    kde-wallpapers \
    \
    ntp-systemd \
    shared-mime-info \
    \
    udisks-systemd \
    \
    declarative-plasmoids \
    kate konsole ksnapshot \
"
