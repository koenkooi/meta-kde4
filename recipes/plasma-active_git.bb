LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL-2;md5=b234ee4d69f5fce4486a80fdaf4a4263"

require kde4.inc

DESCRIPTION = "This recipe builds the development version of plasma active / mobile"

#depends list from kubuntu "apt-get build-dep plasma-mobile"
#DEPENDS = "automoc cmake cmake-data emacsen-common kde-workspace-dev kdelibs5-dev libcurl3 libkactivities5 libkdeclarative5 libkimproxy4 libkutils4 liblsofui4 libphonon-dev libsoprano-dev libxmlrpc-core-c3-0 quilt" 

#finalized (and WORKING) depends list
DEPENDS = "kdelibs4 kde-workspace kde-runtime soprano libkactivities4 quilt curl lsof automoc4-native perl-native"

SRC_URI = "git://anongit.kde.org/plasma-mobile;protocol=git;branch=master"
SRCREV = "4fab06881388c658553afad27ff61a784aacfcc1"
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
		${libdir}/kde4/imports/org/kde/*/qmldir \
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
	       "

FILES_${PN}-dbg =+ "\
		    ${libdir}/kde4/.debug/* \
		    ${libdir}/qt4/plugins/inputmethods/.debug/* \
		    ${libdir}/kde4/imports/org/kde/metadatamodels/.debug/libdatamodelsplugin.so \
		    ${libdir}/kde4/imports/org/kde/plasma/mobilecomponents/.debug/libmobilecomponentsplugin.so \
		    ${libdir}/kde4/imports/org/kde/runnermodel/.debug/librunnermodelplugin.so \
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
		 "

## DIRTY HACK / WORKAROUND
do_install_append() {

# This will move dbus into the wrong directory to prevent mv error directory not empty
  mv ${D}/usr/share/* ${D}${STAGING_DIR_TARGET}/usr/share

# This moves the wrong directory to the normal prefix
  mv -nf ${D}${STAGING_DIR_TARGET}/usr/* ${D}/usr/

# The next 2 lines will remove empty leftover directories
  tmp_relative_staging_dir_target=`echo "${STAGING_DIR_TARGET}" | sed 's|^/||'`
  cd ${D} && rmdir -p ${tmp_relative_staging_dir_target}/usr
}
