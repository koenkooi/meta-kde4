LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

DEPENDS = "kdelibs4"

require kde4.inc

SRC_URI = "git://anongit.kde.org/kde-runtime;protocol=git;branch=master"
SRCREV = "d831f935b12ac2f7d4c44f2384976303c3e1b0d9"

PV = "4.7.97+git${SRCPV}"
EXTRA_OECMAKE =+ "\
		  -DPHONON_INCLUDE_DIR=${STAGING_INCDIR} \
		  \
		  -DDBUSMENUQT_INCLUDE_DIR=${STAGING_INCDIR}/QtDBus \
		  -DDBUSMENUQT_LIBRARIES=${OE_QMAKE_LIBDIR_QT} \
		  \
		  -DSTRIGI_REQUIRED=FALSE \
		 "

S = "${WORKDIR}/git"

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

BBCLASSEXTEND = "native"