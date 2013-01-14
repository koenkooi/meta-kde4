LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"
SRCREV = "bc6c171dad0d2f83cd0bd327875e37588a0dcc3e"
PV = "0.3.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/attica;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit qt4x11 cmake

BBCLASSEXTEND = "native"
