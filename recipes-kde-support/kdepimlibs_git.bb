SUMMARY = "KDE standard fonts for Plasma Desktop"
SECTION = "fonts"

LICENSE = "GPL-2 BSD LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
file://COPYING.BSD;md5=5c262c13b60ebefe3060aed37d334ab6 \
file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

# openldap?
DEPENDS = "kdelibs4 automoc4-native akonadi gpgme cyrus-sasl libical boost shared-mime-info shared-desktop-ontologies soprano"

inherit kde_without_docs kde_cmake kde_exports

SRC_URI = "git://anongit.kde.org/${BPN}.git;branch=master"

# Tag 4.8.4
SRCREV = "c665461132863513360be5928093cc5d8cd35f5b"

PV = "4.8.4+git${SRCPV}"

S = "${WORKDIR}/git"

KDE_EXPORT_FILES = "${S}/build/CMakeFiles/Export/_usr/lib/cmake/KdepimLibs/KDEPimLibsLibraryTargetsWithPrefix-relwithdebinfo.cmake \
${S}/build/KdepimLibsConfig.cmake"


#build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"


FILES_${PN} += "${datadir} \
    ${libdir}/kde4"

FILES_${PN}-dbg += "${libdir}/kde4/.debug \
    ${libdir}/kde4/plugins/designer/.debug"

FILES_${PN}-dev += "${libdir}/cmake \
    ${libdir}/gpgmepp/*.cmake"