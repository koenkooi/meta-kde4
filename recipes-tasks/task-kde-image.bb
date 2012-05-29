DESCRIPTION = "Task for a basic image setup"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit task

RDEPENDS_${PN} += "\
    task-xserver \
    \
    strace \
    \
    dbus-x11 \
    shared-mime-info \
    xauth \
    xdg-utils \
    xhost \
    xinetd \
    xinit \
    xrandr \
    xrdb \
    xset \
    xvinfo \
    upower udisks \
    bash \
    tzdata \
"