LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=2;endline=17;md5=ab7ff4858efc6ddd5151e115b0bf2d9f"


require kde4.inc

DEPENDS = "kdelibs4"

RDEPENDS_${PN} = "plasma-active kde-artwork-active contour"

SRC_URI = "git://anongit.kde.org/startactive.git;branch=master \
	   file://setup-contour-intro.sh"

SRCREV = "c3dd8c80a6d5caa76bab37a4453d48c384772141"

PV = "Active-Two+git${SRCPV}"

S = "${WORKDIR}/git"


FILES_${PN} += "\
		${bindir}/startactive.bin \
		${bindir}/setup-contour-intro.sh \
		${datadir}/apps/startactive/* \
		${datadir}/apps/startactive/modules/* \
		${datadir}/apps/ksplash/Themes/qmldefault/* \
		${datadir}/apps/ksplash/Themes/qmldefault/images/* \
	       "

FILES_${PN}-dbg += "${bindir}/.debug/*"

do_install_append() {
   install -d ${D}${bindir}
   install -m 0755 ${WORKDIR}/setup-contour-intro.sh ${D}${bindir}/
}

EXTRA_OECMAKE =+ "-DOE_CROSSCOMPILING=TRUE"
