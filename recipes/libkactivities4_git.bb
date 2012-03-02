LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/lib/info.h;md5=4547c0d20883d91da92544ee5fc15a0d;beginline=1;endline=16"

inherit kde-exports

KDE_EXPORT_FILES = "${S}/build/lib/CMakeFiles/Export/_usr/share/apps/cmake/modules/KActivitiesLibraryTargets-relwithdebinfo.cmake"

require kde4.inc

DEPENDS = "kdelibs4 soprano shared-desktop-ontologies"
#+soprano

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

SRC_URI = "git://anongit.kde.org/kactivities;protocol=git;branch=master \
	   file://Fix-cmake-destination-directory.patch"

SRCREV = "52cfa820d71a129d003b596892edcccc09459738"


PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git" 

FILES_${PN}-dev += "${datadir}/apps/cmake/modules/KActivitiesConfig.cmake \
		    ${datadir}/apps/cmake/modules/KActivitiesLibraryTargets.cmake"


EXTRA_OECMAKE += "\
		  -DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl \
		 "
