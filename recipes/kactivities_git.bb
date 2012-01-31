LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

inherit qt4x11 cmake

SRC_URI = "git://anongit.kde.org/kactivities;protocol=git;branch=master"
SRCREV = "ba5ca629ffe5b777d875cb83a1263f16b94a8d4e"

PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git" 

BBCLASSEXTEND = "native"