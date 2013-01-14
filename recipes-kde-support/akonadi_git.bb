SUMMARY = "Akonadi"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://lgpl-license;md5=7dbc59dc445b2261c4fb2f9466e3446a"
DEPENDS = "kdelibs4 automoc4-native shared-mime-info boost soprano mysql5"
# Tag 1.8.0
SRCREV = "4178063709cb5abeb30cd6354d2c29b711cb58fd"
PV = "1.8.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/${BPN}.git;branch=master \
    file://Fix-host-program-lookup.patch"

S = "${WORKDIR}/git"

inherit kde_without_docs kde_cmake kde_exports

# Don't search mysql and pssql on the host
EXTRA_OECMAKE += "-DMYSQLD_EXECUTABLE=${STAGING_DIR_TARGET}${libexecdir}/mysqld \
    -DAKONADI_BUILD_QSQLITE=FALSE \
    "

# Feel free to add postgres
PACKAGES += "${PN}-qt-sqllite-plugin ${PN}-qt-sqllite-plugin-dbg"

RDEPENDS_${PN} = "mysql5-server"

FILES_${PN} += "${datadir}"
FILES_${PN}-dev += "${libdir}/cmake"
FILES_${PN}-qt-sqllite-plugin = "${libdir}/qt4/plugins/sqldrivers/libqsqlite3.so"
FILES_${PN}-qt-sqllite-plugin-dbg = "${libdir}/qt4/plugins/sqldrivers/.debug/libqsqlite3.so"

KDE_EXPORT_FILES = "${S}/build/AkonadiConfig.cmake \
${S}/build/CMakeFiles/Export/_usr/lib/cmake/Akonadi/AkonadiTargetsWithPrefix-noconfig.cmake"
#build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
