DESCRIPTION = "Test image for meta-kde with the Angstrom distribution"

## angstrom-kde-test-image is a test image of meta-kde for angstrom
#--Requirements
#  This image was designed to work with OMAP 3530 hardware like the Beagleboard or Gumstix Overo.
#  There is currently a WIP to allow poky users to skip parsing on this recipe


require recipes-images/angstrom/systemd-image.bb

export IMAGE_BASENAME = "ansgstrom-kde-active-image"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
    task-kde-image \
    task-kde-base \
    task-kde-active \
    \
    oxygen-icons \
    oxygen-fonts \
    kde-wallpapers \
    \
    ntp-systemd \
    \
    kate konsole \
"

LICENSE = "MIT"