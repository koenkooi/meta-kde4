LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=db979804f025cf55aabec7129cb671ed"

inherit qt4x11 cmake

SRC_URI = "git://gitorious.org/dbusmenu/dbusmenu-qt.git \
	  "

SRCREV = "bd479bc249547b9f3dd896b97137c200531f5523"

#OECMAKE_CXX_FLAGS += " -I."

EXTRA_OECMAKE =+ "\
		  -DBUILD_TESTS=FALSE \
		 "

PV = "0.9.0+git${SRCPV}"

S = "${WORKDIR}/git"

