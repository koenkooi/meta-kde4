LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL-2;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit kde_cmake kde_rdepends perlnative

DESCRIPTION = "This recipe builds the development version of plasma active / mobile"

#finalized (and WORKING) depends list
DEPENDS = "kdelibs4 kde-workspace kde-runtime soprano libkactivities4 quilt curl lsof automoc4-native qt-mobility-x11"

RDEPENDS_${PN} = "kde-workspace kde-runtime kde-runtime-declarative-scriptengine libkactivities4 qt-mobility-x11"

RRECOMMENDS_${PN} = "virtual/plasma-active-startscript oxygen-icons"

SRC_URI = "git://anongit.kde.org/plasma-mobile;protocol=git;branch=master \
	   file://Fix-Qt-inputmethid-plugin-install-path.patch"
#2012-08-7
SRCREV = "72a55cca2a42d2b71bfef7b33e0c334deb481ed2"
PV = "2+git${SRCPV}"

S = "${WORKDIR}/git"

FILES_${PN} =+ "\
    ${libdir}/libkdeinit4_plasma-device.so \
    ${libdir}/libkdeinit4_plasma-keyboardcontainer.so \
    ${libdir}/libkdeinit4_plasma-widgetstrip.so\
    ${libdir}/kde4/*.so \
    ${libdir}/kde4/imports/org/kde/plasma/mobilecomponents/*.js \
    ${libdir}/kde4/imports/org/kde/plasma/mobilecomponents/*.qml \
    ${libdir}/kde4/imports/org/kde/plasma/mobilecomponents/*.so \
    ${libdir}/kde4/imports/org/kde/metadatamodels/libdatamodelsplugin.so \
    ${libdir}/kde4/imports/org/kde/runnermodel/librunnermodelplugin.so \
    ${libdir}/kde4/imports/org/kde/active \
    ${libdir}/kde4/imports/org/kde/*/qmldir \
    ${libdir}/kde4/imports/org/kde/dirmodel/libdirmodelplugin.so \
    ${libdir}/kde4/imports/org/kde/plasma/mobilecomponents/qmldir \
    ${libdir}/kde4/libexec/* \
    ${libdir}/qt4/plugins/inputmethods/*.so \
    \
    ${datadir}/apps/* \
    ${datadir}/kde4/* \
    ${datadir}/wallpapers/* \
    ${datadir}/icons/* \
    ${datadir}/autostart/plasma-keyboardshell.desktop \
    ${datadir}/dbus-1/system-services/org.kde.active.clockconfig.service \
    \
    ${sysconfdir}/* \
    "

FILES_${PN}-dbg =+ "\
    ${libdir}/kde4/.debug/* \
    ${libdir}/qt4/plugins/inputmethods/.debug/* \
    ${libdir}/kde4/imports/org/kde/*/.debug/*.so \
    ${libdir}/kde4/imports/org/kde/plasma/mobilecomponents/.debug/libmobilecomponentsplugin.so \
    ${libdir}/kde4/imports/org/kde/active/settings/.debug \
    ${libdir}/kde4/libexec/.debug/activedatetimehelper \
    "
# build out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

EXTRA_OECMAKE =+ "\
    -DKActivities_DIR=${STAGING_DATADIR}/apps/cmake/modules/ \
    -DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl \
    \
    -DRCGEN=/usr/bin/nepomuk-rcgen \
    \
    -DOE_QT_PLUGINS_DIR=${libdir}/qt4/plugins \
    \
    -DKACTIVITIES_ONTOLOGIES_DIR=${STAGING_DATADIR}/ontology \
    "
