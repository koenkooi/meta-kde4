LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://server/main.cpp;beginline=1;endline=16;md5=445b0d89ea0a802153431b6d1f55bc6a"

DEPENDS = "soprano kdelibs4"

inherit kde_cmake kde_exports

KDE_EXPORT_FILES = "${S}/build/CMakeFiles/Export/_usr/lib/cmake/NepomukCore/NepomukCoreTargetsWithPrefix-relwithdebinfo.cmake \
${S}/build/NepomukCoreConfig.cmake"


SRC_URI = "git://anongit.kde.org/nepomuk-core.git;branch=master"
SRCREV = "0651e8c8a7213e4dcc239ecdda1be0159d9ff306"

# nepomuk *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

EXTRA_OECMAKE =+ "\
    -DNEPOMUK_INCLUDE_DIR=${STAGING_INCDIR}/KDE/Nepomuk/ \
    "


PV = "4.8.90+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/libkdeinit4_nepomukserver.so \
    ${libdir}/libnepomukcommon.so \
    ${libdir}/kde4 \
    \
    ${datadir}"

FILES_${PN}-dbg += "${libdir}/kde4/.debug"

FILES_${PN}-dev += "${libdir}/cmake"

