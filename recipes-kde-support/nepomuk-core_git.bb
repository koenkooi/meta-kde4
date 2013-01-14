LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://server/main.cpp;beginline=1;endline=16;md5=445b0d89ea0a802153431b6d1f55bc6a"
DEPENDS = "soprano kdelibs4"
SRCREV = "31d3504334f52c9cd7d24d6fe500054ef9301f5d"
PV = "4.9.0+git${SRCPV}"
PR = "r1"

SRC_URI = "git://anongit.kde.org/nepomuk-core.git;branch=master"

S = "${WORKDIR}/git"

inherit kde_cmake kde_exports

EXTRA_OECMAKE =+ "\
    -DNEPOMUK_INCLUDE_DIR=${STAGING_INCDIR}/KDE/Nepomuk/ \
    "

FILES_${PN} += "${libdir}/libkdeinit4_nepomukserver.so \
    ${libdir}/libnepomukcommon.so \
    ${libdir}/kde4 \
    \
    ${datadir}"
FILES_${PN}-dbg += "${libdir}/kde4/.debug"
# ${PN}-dev is currently "messy" so re-add all libraries by hand
FILES_SOLIBSDEV = ""
FILES_${PN}-dev += "${libdir}/cmake \
    ${libdir}/libnepomukcore.so \
    ${libdir}/libnepomuksync.so \
    "

KDE_EXPORT_FILES = "${S}/build/CMakeFiles/Export/_usr/lib/cmake/NepomukCore/NepomukCoreTargetsWithPrefix-relwithdebinfo.cmake \
${S}/build/NepomukCoreConfig.cmake"
# nepomuk *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
