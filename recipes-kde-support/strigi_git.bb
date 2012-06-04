LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=ccf994d4070fbdcd43bf7de4bf9b4a22"

inherit kde_cmake

DEPENDS = "boost curl libxml2 expat binutils"
#DEPENDS_virtclass-native = "libiconv-native"

SRC_URI = "git://anongit.kde.org/strigi.git;branch=master \
    file://gcc-4.7.patch"
SRCREV = "28a7df0d99f8fde1c8c9f5868cbd7f9a278c4655"
PV = "0.7.7+git${SRCPV}"

do_sync_submodules() {
	git submodule update --init
}

# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

#for further information please see http://old.nabble.com/Cannot-build-strigi-to31394092.html#a31394092
EXTRA_OECMAKE = "-DENABLE_DBUS=OFF \
		 -DBoost_INCLUDE_DIR=${STAGING_INCDIR} \
		"

S = "${WORKDIR}/git" 

#some includes missing?
OECMAKE_CXX_FLAGS += " -I. -I${S}/strigidaemon/bin/daemon/dbus/dbuscpp"

addtask sync_submodules before do_patch after do_unpack

BBCLASSEXTEND = "native"
