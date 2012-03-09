LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24"

DEPENDS = "kdelibs4 soprano"

inherit kde-workaround-tmp
require kde4.inc

SRC_URI = "git://anongit.kde.org/kde-runtime;protocol=git;tag=v4.8.0 \
	  file://Disable-docs.patch"
SRCREV = "37a52f48ebd4850d07cd8fe7277e6fa7a653c2ae"

PV = "4.8.0+git${SRCPV}"
EXTRA_OECMAKE =+ "\
		  -DKDEBASE_DISABLE_MULTIMEDIA=ON \
		  \
		  -DKActivities_DIR=${STAGING_DATADIR}/apps/cmake/modules \
		 "

S = "${WORKDIR}/git"

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
		${prefix}${sysconfdir}/* \
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
