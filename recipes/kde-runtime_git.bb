LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

inherit qt4x11 cmake

SRC_URI = "git://anongit.kde.org/kde-runtime;protocol=git;branch=master"
SRCREV = "d831f935b12ac2f7d4c44f2384976303c3e1b0d9"

PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git" 

BBCLASSEXTEND = "native"