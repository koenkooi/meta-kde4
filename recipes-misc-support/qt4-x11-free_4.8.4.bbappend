DEPENDS_append_omap3 = " libgles-omap3"
DEPENDS_append_ti33x = " libgles-omap3"
PRINC := "${@int(PRINC) + 3}"

#This will add reduced visibility to some exports on Qt, otherwise KDE plugins will fail
QT_CONFIG_FLAGS_append = " --reduce-exports"

# Build OpenGL/ES support if available
QT_GLFLAGS_omap3 = "-opengl es2 "
# Needed by kdelibs
QT_DISTRO_FLAGS = "-accessibility -sm"
