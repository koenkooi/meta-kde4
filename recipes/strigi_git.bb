LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=ccf994d4070fbdcd43bf7de4bf9b4a22"

inherit qt4x11 cmake
DEPENDS = "boost-native curl-native libxml2-native expat-native binutils-native virtual/libiconv"
PREFERRED_PROVIDER_virtclass-native_virtual/libiconv ?= "libiconv"

SRC_URI = "git://anongit.kde.org/strigi.git;branch=master"
SRCREV = "28a7df0d99f8fde1c8c9f5868cbd7f9a278c4655"
PV = "0.7.7+git${SRCPV}"

do_sync_submodules() {
	git submodule update --init
}

#for further information please see http://old.nabble.com/Cannot-build-strigi-to31394092.html#a31394092
EXTRA_OECMAKE = "-DENABLE_DBUS=OFF \
		 -DBoost_INCLUDE_DIR=${STAGING_INCDIR} \
		"

S = "${WORKDIR}/git" 

#some includes missing?
OECMAKE_CXX_FLAGS += " -I. -I${S}/strigidaemon/bin/daemon/dbus/dbuscpp"

addtask sync_submodules before do_patch after do_unpack

BBCLASSEXTEND = "native"