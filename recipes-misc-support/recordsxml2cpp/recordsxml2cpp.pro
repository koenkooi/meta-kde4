TEMPLATE = app
TARGET = recordsxml2cpp
DEPENDPATH += .
INCLUDEPATH += .

QT += xml

# Input
SOURCES += recordsxml2cpp.cpp

target.path = /usr/bin
INSTALLS += target
