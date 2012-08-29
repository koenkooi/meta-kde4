LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL-2.1;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "kdelibs4 kde-runtime soprano libkactivities4"

inherit kde_cmake


SRC_URI = "git://anongit.kde.org/share-like-connect.git;branch=master"

## Tag Active/2.0
SRCREV = "dac3ad67f7b07c277152508a1a4144043075b50e"

PV = "Active-2.0+git${SRCPV}"

PR = "r1"

S = "${WORKDIR}/git"

FILES_${PN} += "\
    ${libdir}/libsharelikeconnect.so \
    ${libdir}/kde4/*.so \
    ${libdir}/kde4/imports/* \
    \
    ${datadir}/* \
    "

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"

# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
