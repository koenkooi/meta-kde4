LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=be254b9345b1c2ff33e1a6a96768f2fb"

require kde4.inc

SRC_URI = "git://anongit.kde.org/kactivities;protocol=git;branch=master"
SRCREV = "ba5ca629ffe5b777d875cb83a1263f16b94a8d4e"

PV = "4.7.97+git${SRCPV}"

S = "${WORKDIR}/git" 

EXTRA_OECMAKE += " \
		  -DCMAKE_FIND_ROOT_PATH_MODE_PROGRAM=BOTH \
		  -DKDE4_KDECONFIG_EXECUTABLE=/usr/bin/kde4-config \
		  \
		  -DCMAKE_MODULE_PATH=${STAGING_DATADIR_NATIVE}/kde4/cmake/modules \
		  \
		  -DAUTOMOC4_EXECUTABLE=${STAGING_BINDIR_NATIVE}/automoc4 \
		  \
		  -DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl \
		 "

BBCLASSEXTEND = "native"