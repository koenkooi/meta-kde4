LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL-2.1;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "kdelibs4 libkactivities4"

inherit kde_cmake

# This tag is very odd, it will cause bitbake to create a directory in the workdir of this recipe with the name 2.0+${SRCREV}
# But other than that no misbehaviour has been spotted
SRC_URI = "git://anongit.kde.org/share-like-connect.git;branch=master"

## Tag Active/2.0
SRCREV = "9ed8128284ab9fcab806455bccf0344dd21afbd1"

PV = "Active-2.0+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "\
		${libdir}/libsharelikeconnect.so \
		${libdir}/kde4/*.so \
		${libdir}/kde4/imports/* \
		\
		${datadir}/* \
	       "

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"