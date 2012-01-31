# Please note that this can break any eglibc build, for some unknown reason it can break native builds too.
#
# Uncomment this at own risk, it is recommended to uncomment the warning too, as it won't be possible to trace this back to this bbappend.
#

#BBCLASSEXTEND = "native"
#do_warn-glibc() {
#  bbwarn "WARNING: libiconv native bbappend is active, please check meta-kde README in case of glibc / libiconv errors."
#}
#addtask warn-glibc before do_fetch