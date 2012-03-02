LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL-2.1;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "kdelibs4"

require kde4.inc

SRC_URI = "git://anongit.kde.org/share-like-connect.git;branch=master"
SRCREV = "2d19bb9d148a3293b18355bb8fd8d777d680a1b1"

PV = "Active/2.0+git${SRCPV}"

S = "${WORKDIR}/git"

