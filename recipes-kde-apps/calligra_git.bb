LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=1e7512b07f133ba3841965a175302b84"

DEPENDS = "kdelibs4 okular libeigen2 lcms2 exiv2 soprano shared-mime-info attica recordsxml2cpp-native"

####Full depends list
#LibAttica - Attica is used for Get Hot New Stuff.
#OpenGL - OpenGL support
#Eigen - C++ template library for linear algebra
#Exiv2 - Image metadata library and tools
#Soprano - KDE4 RDF handling library
#LittleCMS - Color management engine
#Nepomuk - Handles metadata of resources
#LittleCMS - Color management engine
#Fontconfig - Library for configuring and customizing font access
#Freetype - A Free, High-Quality, and Portable Font Engine
#Qt Webkit - Qt binding for Webkit, the HTML engine.
#SQLite - Embedded SQL database engine with enabled extensions loading
#ICU - International Components for Unicode (ICU) Library
#libmysqlclient - MySQL Client Library
#libpq - C application programmer's interface to PostgreSQL
#png - Official PNG reference library
#tiff - TIFF Library and Utilities
#jpeg - Free library for JPEG image compression
#SharedMimeInfo - Shared Mime Info
#Okular - Okular ODP Plugin
#XML2 - A library for handling XML documents
#OpenSSL - A toolkit implementing the Secure Sockets Layer (SSL v2/v3) and Transport Layer Security (TLS v1) protocols
#LibXML2 - LibXml2 library
#LibXslt - LibXslt Library
#SharedMimeInfo - Shared Mime Info
#Iconv - Iconv
#pstoedit with svg plugin - Translates PostScript and PDF graphics to SVG
#Create Resources  <http://create.freedesktop.org>
#    Create Resources (brushes, palettes etc.)
#    Recommended at runtime for Calligra for optional extra resources.
#KDE PIMLibs  <http://www.kde.org/>
#    KDE Personal Information Management Libraries
#    Required by Plan and the KDE address book integration (available as a module in KDE)
#QCA (2.0 or higher)  <http://delta.affinix.com/qca>
#    Qt Cryptographic Architecture
#    Required for encrypted OpenDocument files and encrypted xls files support (available as a module in kdesupport)
#Marble  <http://techbase.kde.org/Projects/Marble/>
#    KDE4 World Globe Widget library
#    Required by RDF, Kexi Forms and Reports to show locations on a map
#libpqxx  <http://pqxx.org/development/libpqxx/>
#    Official C++ client API for PostgreSQL
#    Required by Kexi PostgreSQL Migration driver
#FreeTDS  <http://www.freetds.org>
#    Open source implementation of the TDS (Tabular Data Stream) protocol
#    Required by Kexi Sybase Migration driver
#XBase  <http://linux.techass.com/projects/xdb/>
#    XBase compatible C++ class library
#    Required by Kexi XBase Migration driver
#GSL (1.7 or higher)  <http://www.gnu.org/software/gsl>
#    GNU Scientific Library
#    Required by Tables' solver plugin
#GLEW  <http://glew.sourceforge.net>
#    The OpenGL Extension Wrangler Library
#    Required by the Krita shader filter plugin
#FFTW3  <http://www.fftw.org/>
#    A fast, free C FFT library
#    Required by the Krita for fast convolution operators
#OpenCTL (0.9.10 or higher)  <http://www.opengtl.org>
#    Free Color Transformation Language implementation (part of OpenGTL)
#    Required for High Dynamic Range Color Spaces, YCbCr and LMS support
#OpenShiva  <http://www.opengtl.org>
#    OpenShiva interpreter for the Shiva Kernel Language (part of OpenGTL)
#    Required for Shiva based Generators and Filters
#QtShiva  <http://www.opengtl.org>
#    Qt bindings for the OpenShiva interpreter (part of libQtGTL)
#    Required for Shiva based Generators and Filters
#OpenEXR  <http://www.openexr.com>
#    High dynamic-range (HDR) image file format
#    Required by the Krita OpenEXR filter
#poppler-qt4  ERROR: Function failed: do_configure (see /work/oe-core/tmp-eglibc/work/armv7a-angstrom-linux-gnueabi/calligra-2.3.87+git3+92ff51b5c0f388729f466041b34ab165a7d80987-r0/temp/log.do_configure.15590 for further information)
#    <http://poppler.freedesktop.org>
#    The Poppler Qt4 interface library
#    Required by the Krita PDF filter
#kdcraw  <http://www.digikam.org/>
#    The KDCraw library
#    Required by the Krita RAW filter
#openjpeg  <http://www.openjpeg.org>
#    Free library for JPEG 2000 image compression
#    Required by the Krita JPEG 2000 filter
#Spnav  <http://spacenav.sourceforge.net/>
#    3Dconnexion device driver and SDK
#    Required by SpaceNavigator 3D mouse plugin
#DCMTK  <http://dicom.offis.de/dcmtk.php.en>
#    DICOM document processing toolkit
#    Required for processing DICOM structured reports
#WPD  <http://libwpd.sourceforge.net/>
#    WordPerfect Document Library
#    Required by the Words WPD import filter
#WPG  <http://libwpg.sourceforge.net/>
#    WordPerfect Graphics Library
#    Required by the Karbon WPG import filter
#poppler-qt4  <http://poppler.freedesktop.org>
#    The Poppler Qt4 interface library, with XPDF headers
#    Required by the Karbon PDF import filter
####--

inherit kde_cmake kde_without_docs kde_rdepends perlnative

SRC_URI = "git://anongit.kde.org/calligra.git;protocol=git;branch=master \
    file://Disable-OpenGL-if-OpenGl-ES-is-available.patch"

## Tag 2.4.0
SRCREV = "3182dfa2ebe5b15f27cd86a8858a94ee4babc9a3"

PV = "2.4.0+git${SRCPV}"

S = "${WORKDIR}/git"

# calligra *must* be built out of tree
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

EXTRA_OECMAKE_omap3 += "-DNO_OPENGL=TRUE"

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
    ${bindir}calligraplan \
    ${bindir}calligraplanwork \
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