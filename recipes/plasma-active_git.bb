LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL-2;md5=b234ee4d69f5fce4486a80fdaf4a4263"

require kde4.inc

DESCRIPTION = "This recipe builds the development version of plasma active / mobile"

#depends list from kubuntu "apt-get build-dep plasma-mobile"
#DEPENDS = "automoc cmake cmake-data emacsen-common kde-workspace-dev kdelibs5-dev libcurl3 libkactivities5 libkdeclarative5 libkimproxy4 libkutils4 liblsofui4 libphonon-dev libsoprano-dev libxmlrpc-core-c3-0 quilt" 

#finalized (and WORKING) depends list
DEPENDS = "kdelibs4 kdelibs4-native kdelibs4-helper-native quilt curl lsof automoc4-native perl-native"

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

#		  -DCMAKE_FIND_ROOT_PATH_MODE_PROGRAM=BOTH

EXTRA_OECMAKE =+ "\
		  -DKDE4_KDECONFIG_EXECUTABLE=/usr/bin/kde4-config \
		  \
		  -DCMAKE_MODULE_PATH=${STAGING_DATADIR_NATIVE}/kde4/cmake/modules \
		  \
		  -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  -DKDE4_KCFGC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/kconfig_compiler \
		  \
		  -DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl \
		 "

SRC_URI = "git://anongit.kde.org/plasma-mobile;protocol=git;branch=master"
SRCREV = "c99274e85a653115d90a4d2b8fd21705d0ea5984"
PV = "2+git${SRCPV}"

S=${WORKDIR}/git
PARALLEL_MAKE=""
