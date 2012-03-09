LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "kdelibs4 taglib"

inherit kde-workaround-tmp
require kde4.inc

SRC_URI = "git://anongit.kde.org/bangarang.git;protocol=git"
SRCREV = "81ee7ad83c53adff1c6ebbf2cbcc088f61b58269"

PV = "2.1.0+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
		${datadir}/* \
	       "

