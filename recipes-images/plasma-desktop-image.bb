DESCRIPTION = "Test image for meta-kde plasma desktop tests"

export IMAGE_BASENAME = "plasma-desktop-test-image"

require recipes-core/images/core-image-core.bb

IMAGE_FEATURES += "package-management debug-tweaks"

IMAGE_INSTALL += "\
    task-kde-image \
    task-kde-base \
    \
    kate konsole \
"

LICENSE = "MIT"