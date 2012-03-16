# This file is inherited by all KDE CMake related recipes in meta-kde
inherit qt4x11 cmake

RDEPENDS_${PN} += "\
		   libqtcore4 \
		   libqtgui4 \
		   libqtdbus4 \
		   libqtwebkit4 \
		   libqtdeclarative4 \
		   \
		   qt4-dbus \
		   qt4-plugin-script-dbus \
		   qt4-qml-plugins \
		  "

do_generate_toolchain_file() {
	cat > ${WORKDIR}/toolchain.cmake <<EOF
message(STATUS "Toolchain file found and load at: ${WORKDIR}/toolchain.cmake")
# CMake system name must be something like "Linux".
# This is important for cross-compiling.
set( CMAKE_SYSTEM_NAME `echo ${SDK_OS} | sed 's/^./\u&/'` )
set( CMAKE_HOST_SYSTEM_NAME "Linux" )
set( CMAKE_SYSTEM_PROCESSOR ${TARGET_ARCH} )
set( CMAKE_C_COMPILER ${OECMAKE_C_COMPILER} )
set( CMAKE_CXX_COMPILER ${OECMAKE_CXX_COMPILER} )
set( CMAKE_C_FLAGS "${OECMAKE_C_FLAGS}" CACHE STRING "CFLAGS" )
set( CMAKE_CXX_FLAGS "${OECMAKE_CXX_FLAGS}" CACHE STRING "CXXFLAGS" )
set( CMAKE_C_FLAGS_RELEASE "${OECMAKE_C_FLAGS_RELEASE}" CACHE STRING "CFLAGS for release" )
set( CMAKE_CXX_FLAGS_RELEASE "${OECMAKE_CXX_FLAGS_RELEASE}" CACHE STRING "CXXFLAGS for release" )

# We actually do cross compiling, but this should be already set automatically
set( CMAKE_CROSSCOMPILING TRUE )

# only search in the paths provided so cmake doesnt pick
# up libraries and tools from the native build machine
# Please note: variable order is important!
set( CMAKE_FIND_ROOT_PATH ${STAGING_DIR_TARGET} ${STAGING_DIR_NATIVE} )
set( CMAKE_FIND_ROOT_PATH_MODE_PROGRAM ONLY )
set( CMAKE_FIND_ROOT_PATH_MODE_LIBRARY ONLY )
set( CMAKE_FIND_ROOT_PATH_MODE_INCLUDE ONLY )

# Use qt.conf settings
set( ENV{QT_CONF_PATH} ${WORKDIR}/qt.conf )

# We need to set the rpath to the correct directory as cmake does not provide any
# directory as rpath by default
set( CMAKE_INSTALL_RPATH ${OECMAKE_RPATH} )

# Don't use native cmake modules
set( CMAKE_MODULE_PATH ${STAGING_DATADIR}/cmake/Modules/ ${STAGING_DATADIR}/apps/cmake/modules/ )

# add for non /usr/lib libdir, e.g. /usr/lib64
set( CMAKE_LIBRARY_PATH ${libdir} )

##---- see http://techbase.kde.org/Getting_Started/Build/Windows/Cross-Compiling
set( KDE_PREFIX ${D}${prefix} )

# this one is used by FindKDE4.cmake to load FindKDE4Internal.cmake:
set( KDE4_DATA_DIR    ${STAGING_DATADIR}/apps CACHE PATH "points to the apps directory of installed kdelibs" )
if(NOT DEFINED KDE_WORKSPACE_WORKAROUND)
  set( DATA_INSTALL_DIR ${datadir}/apps CACHE PATH "points to the apps directory of installed kdelibs" )
endif(NOT DEFINED KDE_WORKSPACE_WORKAROUND)

# disable some things:
set( WITH_AVAHI OFF   CACHE BOOL "Disabled" )
set( WITH_DNSSD OFF   CACHE BOOL "Disabled" )
set( WITH_ENCHANT OFF CACHE BOOL "Disabled" )
set( WITH_FAM OFF     CACHE BOOL "Disabled" )
set( WITH_GSSAPI OFF  CACHE BOOL "Disabled" )
set( WITH_HSPELL OFF  CACHE BOOL "Disabled" )
set( WITH_OpenEXR OFF CACHE BOOL "Disabled" )


##----

# This was needed because kdelibs native needs Qt QSSL which needs openssl which is not ported for native environment.
set( MAKEKDEWIDGETS_EXECUTABLE /usr/bin/makekdewidgets CACHE PATH "" )
set( KDE4_MAKEKDEWIDGETS_EXECUTABLE /usr/bin/makekdewidgets CACHE PATH "" )
set( KDE4_KCFGC_EXECUTABLE /usr/bin/kconfig_compiler CACHE PATH "" )
set( KDE4_AUTOMOC_EXECUTABLE /usr/bin/automoc4 CACHE PATH "" )


# This will prevent KDElibs from installing files to /usr/etc instead of /etc
set( SYSCONF_INSTALL_DIR ${sysconfdir} CACHE PATH "" )

# This one is a totally useless dependency
set( KDE4_KDECONFIG_EXECUTABLE TRUE CACHE PATH "" )

set( QT_LIBRARY_DIR ${OE_QMAKE_LIBDIR_QT} )
set( QT_INSTALL_LIBS ${OE_QMAKE_LIBDIR_QT} )
set( QT_MOC_EXECUTABLE ${OE_QMAKE_MOC} )
set( QT_UIC_EXECUTABLE ${OE_QMAKE_UIC} )
set( QT_UIC3_EXECUTABLE ${OE_QMAKE_UIC3} )
set( QT_RCC_EXECUTABLE ${OE_QMAKE_RCC} )
set( QT_QMAKE_EXECUTABLE ${OE_QMAKE_QMAKE} )
set( QT_MKSPECS_DIR ${STAGING_DATADIR}/qt4/mkspecs )
set( QT_QT_INCLUDE_DIR ${OE_QMAKE_INCDIR_QT}/Qt )
set( QT_QTGUI_INCLUDE_DIR ${OE_QMAKE_INCDIR_QT}/QtGui )
set( QT_QTCORE_INCLUDE_DIR ${OE_QMAKE_INCDIR_QT}/QtCore )

# Qt Stuff for testing
set( QT_INCLUDE_DIR ${OE_QMAKE_INCDIR_QT} )

# This will now allow us to instll to the right directory instead of some bogus dirs found by FindKDE4Internal.cmake
if( NOT DEFINED OE_CROSSCOMPILING)
  set( OE_CROSSCOMPILING TRUE )
endif( NOT DEFINED OE_CROSSCOMPILING )

# Don't build the documentation
set( BUILD_doc OFF )
EOF
}
addtask generate_toolchain_file after do_patch before do_configure 
