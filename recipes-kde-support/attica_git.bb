LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"
SRCREV = "0ea3b8e88052a22bf52e54f9f972d917ae2c2102"
PV = "0.4.1+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/attica;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit qt4x11 cmake

BBCLASSEXTEND = "native"
