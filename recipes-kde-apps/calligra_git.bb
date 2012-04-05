LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=1e7512b07f133ba3841965a175302b84"

DEPENDS = "kdelibs4 okular"

inherit kde_cmake kde_rdepends perlnative

SRC_URI = "git://anongit.kde.org/calligra.git;protocol=git;branch=master"

## Tag 2.3.87
SRCREV = "92ff51b5c0f388729f466041b34ab165a7d80987"

PV = "2.3.87+git${SRCPV}"

S = "${WORKDIR}/git"

# calligra *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"


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

FILES_${PN}-dev += "${datadir}/apps/cmake/modules/FindCalligraLibs.cmake"

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"


PACKAGES =+ "\
	     ${PN}-braindump \
	     ${PN}-flow \
	     ${PN}-karbon \
	     ${PN}-kexi \
	     ${PN}-krita \
	     ${PN}-stage \
	     ${PN}-words \
	    "


RDEPENDS_${PN}-braindump = "${PN}"
RDEPENDS_${PN}-flow = "${PN}"
RDEPENDS_${PN}-karbon = "${PN}"
RDEPENDS_${PN}-kexi = "${PN}"
RDEPENDS_${PN}-krita = "${PN}"
RDEPENDS_${PN}-stage = "${PN}"
RDEPENDS_${PN}-words = "${PN}"


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

FILES_${PN}-krita = "\
${datadir}/apps/krita \
${datadir}/kde4/services/ServiceMenus/krita_konqi.desktop \
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

FILES_${PN}-braindump = "\
${bindir}/braindump \
\
${libdir}/libbraindump*.so.* \
${datadir}/apps/braindump \
"

FILES_${PN}-kexi = "\
${bindir}/kexi \
\
${datadir}/apps/kexi \
${datadir}/kde4/services/kexi* \
${datadir}/kde4/servicetypes/kexi* \
${datadir}/config/kexirc \
\
${libdir}/libkexi*.so.* \
${libdir}/kde4/kexi* \
"





