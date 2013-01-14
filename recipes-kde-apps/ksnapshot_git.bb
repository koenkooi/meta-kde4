#FILES_${PN}-dev += "${datadir}/apps/cmake/*"
#FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"
SUMMARY = "Take screenshots from your KDE desktop or a single window"
LICENSE = "GPL-2.0 & LGPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe \
file://COPYING.LIB;md5=3214f080875748938ba060314b4f727d"
DEPENDS = "kdelibs4 automoc4-native"
## Tag 4.8.2
SRCREV = "a1fd419de234d6e5fb6d2804a95362777307f292"
PV = "4.8.2+git${SRCPV}"

SRC_URI = "git://anongit.kde.org/ksnapshot.git;protocol=git;branch=master \
file://0001-Opt-out-docs.patch"

S = "${WORKDIR}/git"

inherit kde_cmake kde_rdepends kde_without_docs perlnative

FILES_${PN} += "${datadir}"
