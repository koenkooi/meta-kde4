QT_GLFLAGS_omap3 = "-opengl es2 "
DEPENDS_append_omap3 = " libgles-omap3"
DEPENDS_append_ti33x = " libgles-omap3"

# Needed by kdelibs
QT_DISTRO_FLAGS = "-accessibility -sm"

PRINC := "${@int(PRINC) + 2}"
