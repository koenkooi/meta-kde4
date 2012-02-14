LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/lib/info.h;md5=4547c0d20883d91da92544ee5fc15a0d;beginline=1;endline=16"

require kde4.inc

DEPENDS = "kdelibs4"
#+soprano

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

SRC_URI = "git://anongit.kde.org/kactivities;protocol=git;branch=master \
	   file://0001-Fix-Nepomuk.patch"

SRCREV = "ba5ca629ffe5b777d875cb83a1263f16b94a8d4e"


PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git" 

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

FILES_${PN}-dev += "${datadir}/apps/cmake/modules/KActivitiesConfig.cmake \
		    ${datadir}/apps/cmake/modules/KActivitiesLibraryTargets.cmake"

##OECMAKE_CXX_FLAGS =+ "-I${STAGING_INCDIR}/KDE"

do_compile() {
#  cd ${S}/build/lib && oe_runmake CC="${CC}" CXX="${CXX}"
  echo "done"
}


do_install() {
#  cd ${S}/build/lib && oe_runmake install DESTDIR=${D}
  install -d ${D}${datadir}/apps/cmake/modules
  install -m 0644 ${S}/build/lib/KActivitiesConfig.cmake ${D}${datadir}/apps/cmake/modules
  install -m 0644 ${S}/build/lib/CMakeFiles/Export/*/lib/cmake/KActivities/KActivitiesLibraryTargets.cmake ${D}${datadir}/apps/cmake/modules
}

EXTRA_OECMAKE += "\
		  -DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl \
		  -DQT_DBUSXML2CPP_EXECUTABLE=${STAGING_BINDIR_NATIVE}/qdbusxml2cpp \
		  -DQT_DBUSCPP2XML_EXECUTABLE=${STAGING_BINDIR_NATIVE}/qdbuscpp2xml \
		 "
PARALLEL_MAKE=""
#BBCLASSEXTEND = "native"