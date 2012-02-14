LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4"

require kde4.inc

SRC_URI = "git://anongit.kde.org/kde-runtime;protocol=git;branch=master"
SRCREV = "d831f935b12ac2f7d4c44f2384976303c3e1b0d9"

PV = "4.7.97+git${SRCPV}"
EXTRA_OECMAKE =+ "\
		  -DDBUSMENUQT_INCLUDE_DIR=${STAGING_INCDIR}/QtDBus \
		  -DDBUSMENUQT_LIBRARIES=${OE_QMAKE_LIBDIR_QT} \
		  \
		  -DKDEBASE_DISABLE_MULTIMEDIA=ON \
		 "

#		  -DPHONON_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \

S = "${WORKDIR}/git"

# build out of tree
#OECMAKE_SOURCEPATH = ".."
#OECMAKE_BUILDPATH = "build"

#BBCLASSEXTEND = "native"
