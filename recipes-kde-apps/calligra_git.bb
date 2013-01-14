## For a full depends list see log.do_configure
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=1e7512b07f133ba3841965a175302b84"
DEPENDS = "kdelibs4 okular libeigen2 lcms2 exiv2 soprano shared-mime-info attica recordsxml2cpp-native icu"
## Tag 2.4.0
SRCREV = "3182dfa2ebe5b15f27cd86a8858a94ee4babc9a3"
PV = "2.4.0+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/calligra.git;protocol=git;branch=master \
    file://Disable-OpenGL-if-OpenGl-ES-is-available.patch"

S = "${WORKDIR}/git"

inherit kde_cmake kde_without_docs kde_rdepends perlnative

EXTRA_OECMAKE_omap3 += "-DNO_OPENGL=TRUE"

PACKAGES =+ "\
    ${PN}-braindump \
    ${PN}-flow \
    ${PN}-karbon \
    ${PN}-kexi \
    ${PN}-krita \
    ${PN}-plan \
    ${PN}-sheets \
    ${PN}-stage \
    ${PN}-words \
    "

RDEPENDS_${PN}-braindump = "${PN}"
RDEPENDS_${PN}-flow = "${PN}"
RDEPENDS_${PN}-karbon = "${PN}"
RDEPENDS_${PN}-kexi = "${PN}"
RDEPENDS_${PN}-krita = "${PN}"
RDEPENDS_${PN}-plan = "${PN}"
RDEPENDS_${PN}-sheets = "${PN}"
RDEPENDS_${PN}-stage = "${PN}"
RDEPENDS_${PN}-words = "${PN}"

FILES_${PN} += "\
    \
    ${datadir}/apps/calligra/* \
    ${datadir}/apps/xsltfilter/* \
    ${datadir}/apps/musicshape/* \
    ${datadir}/apps/stateshape/* \
    ${datadir}/apps/formulashape/* \
    ${datadir}/apps/koproperty/* \
    ${datadir}/mime/* \
    ${datadir}/icons/* \
    ${datadir}/kde4/* \
    ${datadir}/config/* \
    ${datadir}/templates/* \
    ${datadir}/templates/.source \
    \
    ${libdir}/libkdeinit4*.so \
    ${libdir}/kde4/*.so \
    ${libdir}/libkdeinit4_kthesaurus.so \
    "
FILES_${PN}-dev += "${datadir}/apps/cmake/modules/FindCalligraLibs.cmake \
    ${datadir}/config.kcfg \
    "
FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
FILES_${PN}-braindump = "\
    ${bindir}/braindump \
    \
    ${datadir}/apps/braindump \
    \
    ${libdir}/libbraindump*.so.* \
    "
FILES_${PN}-flow = "\
    ${bindir}/calligraflow \
    \
    ${datadir}/apps/flow \
    ${datadir}/kde4/services/flow \
    ${datadir}/kde4/services/ServiceMenus/flow_konqi.desktop \
    ${datadir}/kde4/servicetypes/flow* \
    ${datadir}/config/flow* \
    \
    ${libdir}/libflow*.so.* \
    ${libdir}/kde4/flow* \
    ${libdir}/libkdeinit4_calligraflow.so \
    "
FILES_${PN}-karbon = "\
    ${bindir}/karbon \
    \
    ${datadir}/apps/karbon \
    ${datadir}/kde4/services/karbon* \
    ${datadir}/kde4/servicetypes/karbon* \
    ${datadir}/kde4/services/ServiceMenus/karbon*_konqi.desktop \
    ${datadir}/config/karbonrc \
    \
    ${libdir}/libkarbon*.so.* \
    ${libdir}/kde4/karbon* \
    ${libdir}/libkdeinit4_karbon.so \
    "
FILES_${PN}-kexi = "\
    ${bindir}/kexi \
    ${bindir}/kexi_sqlite3_dump \
    \
    ${datadir}/apps/kexi \
    ${datadir}/kde4/services/kexi* \
    ${datadir}/kde4/servicetypes/kexi* \
    ${datadir}/config/kexirc \
    \
    ${libdir}/libkexi*.so.* \
    ${libdir}/kde4/kexi* \
    "
FILES_${PN}-krita = "\
    ${bindir}/krita \
    \
    ${datadir}/apps/krita \
    ${datadir}/apps/kritaplugins\
    ${datadir}/color \
    ${datadir}/kde4/services/ServiceMenus/krita_konqi.desktop \
    \
    ${libdir}/kde4/krita*.so \
    ${libdir}/libkdeinit4_krita.so \
    ${libdir}/libkrita*.so.* \
    "
FILES_${PN}-plan = "\
    ${bindir}/calligraplan \
    ${bindir}/calligraplanwork \
    \
    ${datadir}/apps/plan \
    ${datadir}/apps/planwork \
    \
    ${libdir}/kde4/krossmoduleplan.so \
    ${libdir}/kde4/plan*.so \
    ${libdir}/libkdeinit4_calligraplan*.so \
    ${libdir}/libplan*.so.* \
    ${libdir}/librcps_plan.so.* \
    "
FILES_${PN}-sheets = "\
    ${bindir}/calligrasheets \
    \
    ${datadir}/apps/tables \
    ${datadir}/apps/sheets \
    \
    ${libdir}/kde4/calligrasheetspart.so \
    ${libdir}/kde4/spreadsheetshape-deferred.so \
    ${libdir}/kde4/spreadsheetshape.so \
    ${libdir}/libcalligrasheets*.so.* \
    ${libdir}/libkdeinit4_calligrasheets.so \
"
FILES_${PN}-stage = "\
    ${bindir}/calligrastage \
    \
    ${datadir}/apps/stage \
    ${datadir}/config/stagerc \
    ${datadir}/kde4/services/stagepart.desktop \
    \
    ${libdir}/libstage*.so.* \
    ${libdir}/kde4/calligrastage* \
    ${libdir}/libkdeinit4_calligrastage.so \
    "
FILES_${PN}-words = "\
    ${bindir}/calligrawords \
    \
    ${datadir}/apps/words \
    ${datadir}/kde4/services/words* \
    ${datadir}/kde4/services/ServiceMenus/words_konqi.desktop \
    ${datadir}/config/wordsrc \
    \
    ${libdir}/libwords*.so.* \
    ${libdir}/kde4/word* \
    ${libdir}/libkdeinit4_calligrawords.so \
    "

# calligra *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
