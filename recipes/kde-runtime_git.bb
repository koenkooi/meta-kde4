LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4 soprano"

require kde4.inc

SRC_URI = "git://anongit.kde.org/kde-runtime;protocol=git;branch=master \
	  file://Disable-docs.patch"
SRCREV = "37a52f48ebd4850d07cd8fe7277e6fa7a653c2ae"

PV = "4.7.97+git${SRCPV}"
EXTRA_OECMAKE =+ "\
		  -DKDEBASE_DISABLE_MULTIMEDIA=ON \
		  \
		  -DKActivities_DIR=${STAGING_DATADIR}/apps/cmake/modules \
		 "

S = "${WORKDIR}/git"

# build out of tree
#OECMAKE_SOURCEPATH = ".."
#OECMAKE_BUILDPATH = "build"

#BBCLASSEXTEND = "native"
