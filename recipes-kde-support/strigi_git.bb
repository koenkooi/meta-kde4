#DEPENDS_virtclass-native = "libiconv-native"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=ccf994d4070fbdcd43bf7de4bf9b4a22"
DEPENDS = "boost curl libxml2 expat binutils"
SRCREV = "28a7df0d99f8fde1c8c9f5868cbd7f9a278c4655"
PV = "0.7.7+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/strigi.git;branch=master \
    file://gcc-4.7.patch"

S = "${WORKDIR}/git"

inherit kde_cmake

#for further information please see http://old.nabble.com/Cannot-build-strigi-to31394092.html#a31394092
EXTRA_OECMAKE = "-DENABLE_DBUS=OFF \
                 -DBoost_INCLUDE_DIR=${STAGING_INCDIR} \
                "

addtask sync_submodules before do_patch after do_unpack

BBCLASSEXTEND = "native"

do_sync_submodules() {
        git submodule update --init
}
# kdelibs *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
#some includes missing?
OECMAKE_CXX_FLAGS += " -I. -I${S}/strigidaemon/bin/daemon/dbus/dbuscpp"
