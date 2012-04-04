# This will set up the general RDEPENDS of the KDE packages

RDEPENDS_${PN} += "\
		   libqtcore4 \
		   libqtgui4 \
		   libqtdbus4 \
		   libqtdeclarative4 \
		   libqtsvg4 \
		   \
		   qt4-dbus \
		   qt4-qml-plugins \
		   \
		   qt4-plugin-script-dbus \
		   qt4-plugin-imageformat-svg \
		   qt4-plugin-iconengine-svgicon \
		  "
