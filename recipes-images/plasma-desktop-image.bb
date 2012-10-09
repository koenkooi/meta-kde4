DESCRIPTION = "Test image for meta-kde plasma desktop tests"

export IMAGE_BASENAME = "plasma-desktop-test-image"

include recipes-core/images/core-image-core.bb

IMAGE_FEATURES += "package-management debug-tweaks"

IMAGE_INSTALL += "\
    packagegroup-kde-image \
    packagegroup-kde-base \
    \
    oxygen-icons \
    oxygen-fonts \
	kde-wallpapers \
    \
    shared-mime-info \
    \
    kate konsole \
"

LICENSE = "MIT"