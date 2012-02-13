
inherit qt4x11 cmake
# CMake can't find our Qt stuff, this should fix it
#EXTRA_OECMAKE = "\
#		 
#		"

# This won't work compiling native
#		 -DQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \

do_rewrite_toolchain_file() {
# This is a override, so if there is no file to delete an error occured.
	rm ${WORKDIR}/toolchain.cmake
	cat > ${WORKDIR}/toolchain.cmake <<EOF
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

# only search in the paths provided so cmake doesnt pick
# up libraries and tools from the native build machine
set( CMAKE_FIND_ROOT_PATH ${STAGING_DIR_NATIVE} ${STAGING_DIR_HOST} ${CROSS_DIR} ${OECMAKE_PERLNATIVE_DIR} ${OECMAKE_EXTRA_ROOT_PATH} )
set( CMAKE_FIND_ROOT_PATH_MODE_PROGRAM ONLY )
set( CMAKE_FIND_ROOT_PATH_MODE_LIBRARY ONLY )
set( CMAKE_FIND_ROOT_PATH_MODE_INCLUDE ONLY )

# set the archiever to ${AR}
set( CMAKE_AR ${OECMAKE_AR} )


# Lets give this a try, but I doubt that it will make any difference
set( CMAKE_CROSSCOMPILING TRUE )

# Use qt.conf settings
set( ENV{QT_CONF_PATH} ${WORKDIR}/qt.conf )

# We need to set the rpath to the correct directory as cmake does not provide any
# directory as rpath by default
set( CMAKE_INSTALL_RPATH ${OECMAKE_RPATH} )

# Don't use native cmake modules
set( CMAKE_MODULE_PATH ${STAGING_DATADIR}/cmake/Modules/ ${STAGING_DATADIR_NATIVE}/apps/cmake/modules/ )

# add for non /usr/lib libdir, e.g. /usr/lib64
set( CMAKE_LIBRARY_PATH ${libdir} )

set( CMAKE_INCLUDE_PATH ${STAGING_INCDIR_HOST} )

#set( DBUSMENUQT_INCLUDE_DIR ${STAGING_INCDIR}/QtDBus )
set( DBUSMENUQT_LIBRARIES ${OE_QMAKE_LIBDIR_QT} )

set( CMAKE_PREFIX_PATH ${STAGING_DIR_HOST}${prefix} )

# native compiled tools
set( KDE4_KCFGC_EXECUTABLE ${STAGING_BINDIR_NATIVE}/kconfig_compiler )
set( AUTOMOC4_EXECUTABLE ${STAGING_BINDIR_NATIVE}/automoc4 )
set( KDE4_KDECONFIG_EXECUTABLE ${STAGING_BINDIR_NATIVE}/kde4-config )

set( QT_LIBRARY_DIR ${OE_QMAKE_LIBDIR_QT} )
set( QT_INSTALL_LIBS ${OE_QMAKE_LIBDIR_QT} )
set( QT_MOC_EXECUTABLE ${OE_QMAKE_MOC} )
set( QT_UIC_EXECUTABLE ${OE_QMAKE_UIC} )
set( QT_UIC3_EXECUTABLE ${OE_QMAKE_UIC3} )
set( QT_RCC_EXECUTABLE ${OE_QMAKE_RCC} )
set( QT_QMAKE_EXECUTABLE ${OE_QMAKE_QMAKE} )
set( QT_MAKESPEC_DIR ${QMAKESPEC} )
set( QT_QT_INCLUDE_DIR ${STAGING_INCDIR_NATIVE}/Qt )
set( QT_QTGUI_INCLUDE_DIR ${STAGING_INCDIR_NATIVE}/QtGui )
set( QT_QTCORE_INCLUDE_DIR ${STAGING_INCDIR_NATIVE}/QtCore )

# Using ${STAGING_INCDIR_NATIVE} instead of ${OE_QMAKE_INCDIR_QT} is necessary because qt don't set the right path when compiling native
set( QT_INCLUDE_DIR ${STAGING_INCDIR_NATIVE} ${STAGING_INCDIR_NATIVE}/Qt ${STAGING_INCDIR_NATIVE}/Qt3Support ${STAGING_INCDIR_NATIVE}/QtCore ${STAGING_INCDIR_NATIVE}/QtDBus ${STAGING_INCDIR_NATIVE}/QtGui ${STAGING_INCDIR_NATIVE}/QtNetwork ${STAGING_INCDIR_NATIVE}/QtSql ${STAGING_INCDIR_NATIVE}/QtTest ${STAGING_INCDIR_NATIVE}/QtXml ${STAGING_INCDIR_NATIVE}/QtXmlPatterns )
EOF
}
addtask rewrite_toolchain_file after do_generate_toolchain_file before do_configure