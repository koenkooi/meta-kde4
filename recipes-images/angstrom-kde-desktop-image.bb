DESCRIPTION = "Test image for meta-kde with the Angstrom distribution"

## angstrom-kde-test-image is a test image of meta-kde for angstrom
#--Requirements
#  This image was designed to work with OMAP 3530 hardware like the Beagleboard or Gumstix Overo.
#  There is currently a WIP to allow poky users to skip parsing on this recipe


require recipes-images/angstrom/systemd-image.bb

export IMAGE_BASENAME = "ansgstrom-kde-desktop-image"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += "\
    task-kde-image \
    task-kde-base \
    \
    ntp-systemd \
    libgles-omap3-es3 \
    \
    kate konsole \
"

LICENSE = "MIT"