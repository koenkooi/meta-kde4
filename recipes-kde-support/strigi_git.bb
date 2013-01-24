LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=ccf994d4070fbdcd43bf7de4bf9b4a22"
DEPENDS = "boost curl libxml2 expat binutils"
SRCREV = "28a7df0d99f8fde1c8c9f5868cbd7f9a278c4655"
PV = "0.7.7+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/strigi.git;branch=master \
    file://gcc-4.7.patch"

S = "${WORKDIR}/git"

inherit kde_cmake

FILES_${PN} += "\
    ${bindir}/strigicmd \
    ${bindir}/strigidaemon \
    ${libdir}/libsearchclient.so.* \
    ${datadir}/dbus-1/services/*.service \
    "
FILES_${PN}-dev += "\
    ${libdir}/libsearchclient.so \
    ${libdir}/libsearchclient/*.cmake \
    ${libdir}/libstreams/*.cmake \
    ${includedir}/strigi/*.h \
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

