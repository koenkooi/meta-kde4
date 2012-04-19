LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4 libkactivities4 soprano shared-desktop-ontologies"
RDEPENDS_${PN} = "soprano kdelibs4"
RDEPENDS_${PN}-declarative-scriptengine = "${PN}"
RRECOMMENDS_${PN} = "${PN}-declarative-scriptengine"

inherit kde_without_docs kde_rdepends kde_cmake

SRC_URI = "git://anongit.kde.org/kde-runtime;protocol=git;branch=master"

## Tag v4.8.0
SRCREV = "6068720132e0d9eb5c6febd17462a32b4ee3b02c"

PV = "4.8.0+git${SRCPV}"


S = "${WORKDIR}/git"

PACKAGES =+ "${PN}-declarative-scriptengine"

FILES_${PN} += "\
		${libdir}/attica_kde.so \
		${libdir}/libkdeinit4_*.so \
		${libdir}/libknotifyplugin.so \
		${libdir}/libnepomukcommon.so \
		${libdir}/libnepomukdatamanagement.so \
		${libdir}/kde4/* \
		\
		${datadir}/* \
		\
		${sysconfdir}/* \
	       "

FILES_${PN}-declarative-scriptengine += "\
					  ${libdir}/kde4/imports/org/kde/plasma/core/libcorebindingsplugin.so \
					  ${libdir}/kde4/imports/org/kde/plasma/core/qmldir \
					  ${libdir}/kde4/imports/org/kde/plasma/graphicslayouts/libgraphicslayoutsbindingsplugin.so \
					  ${libdir}/kde4/imports/org/kde/plasma/graphicslayouts/qmldir \
					  ${libdir}/kde4/imports/org/kde/plasma/graphicswidgets/libgraphicswidgetsbindingsplugin.so \
					  ${libdir}/kde4/imports/org/kde/plasma/graphicswidgets/qmldir \
					  ${libdir}/kde4/plasma_appletscript_declarative.so \
					  ${datadir}/kde4/services/plasma-scriptengine-applet-declarative.desktop \
					"
FILES_${PN}-dev += "\
		    ${datadir}/apps/cmake/* \
		   "

FILES_${PN}-dbg += "\
		    ${libdir}/kde4/.debug/* \
		    ${libdir}/kde4/libexec/.debug/* \
		    ${libdir}/kde4/imports/org/kde/*/.debug/* \
		    ${libdir}/kde4/imports/org/kde/plasma/*/.debug/* \
		    ${libdir}/kde4/platformimports/touch/org/kde/plasma/components/.debug/* \
		   "

EXTRA_OECMAKE =+ "\
		  -DKDEBASE_DISABLE_MULTIMEDIA=ON \
		  \
		  -DKActivities_DIR=${STAGING_DATADIR}/apps/cmake/modules \
		 "
