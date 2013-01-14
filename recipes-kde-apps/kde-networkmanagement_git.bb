SUMMARY = "KDE graphical network management application"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "automoc4-native kde-workspace networkmanager libnm-qt"
## Tag 0.9.0.3 + fix for nm<=0.9.4
SRCREV = "8de4bfecb51f37cae2652c30a472b196f2b36df9"
PV = "0.9.0.3+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/networkmanagement.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

inherit kde_cmake kde_without_docs

RDEPENDS_${PN} = "kde-workspace networkmanager libnm-qt"

FILES_${PN} += "${libdir}/libknm_nm.so \
    ${libdir}/kde4/*.so \
    ${datadir}"
FILES_${PN}-dbg += "${libdir}/kde4/.debug"

# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
