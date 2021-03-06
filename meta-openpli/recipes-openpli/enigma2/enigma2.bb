DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "OpenPLi team <info@openpli.org>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = " \
	ethtool \
	freetype \
	gettext-native \
	gst-plugins-base gstreamer \
	hotplug-e2-helper \
	jpeg \
	libdreamdvd libdvbsi++ libfribidi libmad libpng libsigc++-1.2 libungif libxml2 libxmlccwrap \
	openssl \
	python python-imaging python-twisted python-wifi \
	swig-native \
	tuxtxt-enigma2 \
	"

RDEPENDS_${PN} = " \
	alsa-conf \
	enigma2-fonts \
	ethtool \
	glibc-gconv-iso8859-15 \
        hotplug-e2-helper \
	${PYTHON_RDEPS} \
	libdreamdvd \
	"

RRECOMMENDS_${PN} = " \
	glib-networking \
	gst-plugin-subsink \
	gst-plugin-libxt \
	${GST_BASE_RDEPS} \
	${GST_GOOD_RDEPS} \
	${GST_BAD_RDEPS} \
	${GST_UGLY_RDEPS} \
	libdvdcss \
	"

PYTHON_RDEPS = " \
	python-codecs \
	python-core \
	python-crypt \
	python-fcntl \
	python-lang \
	python-netclient \
	python-netserver \
	python-pickle \
	python-re \
	python-shell \
	python-threading \
	python-twisted-core \
	python-twisted-web \
	python-utf8-hack \
	python-xml \
	python-zlib \
	python-zopeinterface \
	"

GST_BASE_RDEPS = " \
	gst-plugins-base-alsa \
	gst-plugins-base-app \
	gst-plugins-base-audioconvert \
	gst-plugins-base-audioresample \
	gst-plugins-base-decodebin \
	gst-plugins-base-decodebin2 \
	gst-plugins-base-ogg \
	gst-plugins-base-playbin \
	gst-plugins-base-subparse \
	gst-plugins-base-typefindfunctions \
	gst-plugins-base-vorbis \
	"

GST_GOOD_RDEPS = " \
	gst-plugins-good-apetag \
	gst-plugins-good-audioparsers \
	gst-plugins-good-autodetect \
	gst-plugins-good-avi \
	gst-plugins-good-flac \
	gst-plugins-good-flv \
	gst-plugins-good-icydemux \
	gst-plugins-good-id3demux \
	gst-plugins-good-isomp4 \
	gst-plugins-good-matroska \
	gst-plugins-good-rtp \
	gst-plugins-good-rtpmanager \
	gst-plugins-good-rtsp \
	gst-plugins-good-souphttpsrc \
	gst-plugins-good-udp \
	gst-plugins-good-wavparse \
	"

GST_BAD_RDEPS = " \
	gst-plugins-bad-cdxaparse \
	gst-plugins-bad-mms \
	gst-plugins-bad-mpegdemux \
	gst-plugins-bad-rtmp \
	gst-plugins-bad-vcdsrc \
	gst-plugins-bad-fragmented \
	gst-plugins-bad-faad \
	"

GST_UGLY_RDEPS = " \
	gst-plugins-ugly-amrnb \
	gst-plugins-ugly-amrwbdec \
	gst-plugins-ugly-asf \
	gst-plugins-ugly-cdio \
	gst-plugins-ugly-dvdsub \
	gst-plugins-ugly-mad \
	gst-plugins-ugly-mpegaudioparse \
	gst-plugins-ugly-mpegstream \
	"

#make sure default skin is installed.
RDEPENDS_${PN} += "${E2DEFAULTSKIN} "

# We depend on the font which we use for TXT subtitles (defined in skin_subtitles.xml)
RDEPENDS_${PN} += "font-valis-enigma"

RDEPENDS_${PN} += "${@base_contains("MACHINE_FEATURES", "blindscan-dvbc", "virtual/blindscan-dvbc" , "", d)}"

DEMUXTOOL ?= "replex"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "python-twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "python-twisted-web"
DESCRIPTION_append_enigma2-plugin-systemplugins-crashlogautosubmit = "automatically send crashlogs to Dream Multimedia"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = "python-twisted-mail python-twisted-names python-compression python-mime python-email"
DESCRIPTION_append_enigma2-plugin-systemplugins-cleanupwizard = "informs you on low internal memory on system startup."
DESCRIPTION_append_enigma2-plugin-extensions-modem = "opens a menu to connect to internet via builtin modem."
RDEPENDS_enigma2-plugin-extensions-modem = "dreambox-modem-ppp-scripts"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"
# Note that these tools lack recipes
RDEPENDS_enigma2-plugin-extensions-dvdburn = "dvd+rw-tools dvdauthor mjpegtools cdrkit python-imaging ${DEMUXTOOL}"
RDEPENDS_enigma2-plugin-systemplugins-hotplug = "hotplug-e2-helper"
RDEPENDS_enigma2-plugin-systemplugins-3gmodemmanager = "ppp usbmodeswitch usbmodeswitch-data wvdial wvstreams libwvutils4.6 libwvstreams-extras libuniconf4.6"
RDEPENDS_enigma2-plugin-systemplugins-wirelessaccesspoint = "hostap-daemon bridge-utils"
RDEPENDS_enigma2-plugin-extensions-streamtv = "librtmp0 gst-plugin-rtmp"
RDEPENDS_enigma2-plugin-extensions-dlnabrowser = "djmount fuse-utils libfuse2 libupnp3 kernel-module-fuse"
RDEPENDS_enigma2-plugin-extensions-dlnaserver = "minidlna libexif12 libavformat52 libavutil50 libavcodec52 libgsm1 libmp3lame0 libschroedinger-1.0-0 libtheora0 liboil"
RDEPENDS_enigma2-plugin-extensions-webbrowser = "python-gdata libqtwebkite4 opera-hbbtv-browser qt4-embedded-fonts qt4-embedded-plugin-imageformat-gif qt4-embedded-plugin-imageformat-ico qt4-embedded-plugin-imageformat-jpeg qt4-embedded-plugin-imageformat-mng qt4-embedded-plugin-imageformat-svg qt4-embedded-plugin-imageformat-tiff qt4-embedded-plugin-iconengine-svgicon"
RDEPENDS_enigma2-plugin-extensions-hbbtv = "tslib-conf libts-1.0-0 libsysfs2 directfb libgmp3 libmpfr1 opera-hbbtv-browser python-native tslib mpfr gmp libgmp10 libmpfr4"
RDEPENDS_enigma2-plugin-systemplugins-devicemanager = "util-linux-ng-blkid ntfs-3g dosfstools"
RDEPENDS_enigma2-plugin-systemplugins-transcodingsetup = "enigma2-transtreamproxy"

inherit gitpkgv

PV = "2.7+git${SRCPV}"
PKGV = "2.7+git${GITPKGV}"
PR = "${AZVERSION}.${AZREVISION}"

ENIGMA2_BRANCH ?= "master"
SRC_URI = "git://git.code.sf.net/p/openpli/enigma2;protocol=git;branch=${ENIGMA2_BRANCH}"
SRC_URI += "\
	file://azboxe2.patch \
	file://e2_pcr.patch \
	file://add_more_timeout.patch \
	file://pic_show.patch \
"

SRC_URI_append_azboxhd = " \
 file://azboxhd.patch \
 file://lcdchar.patch \
 file://rc.png \
 file://rcold.png \
 file://rcpositions.xml \
 file://input_rcnew.png  \
 file://input_rcnew-configured.png \
 file://input_rcold.png  \
 file://input_rcold-configured.png  \
"

SRC_URI_append_azboxme = " \
 file://rc.png \
 file://rcold.png \
 file://rcpositions.xml \
 file://input_rcnew.png  \
 file://input_rcnew-configured.png \
 file://input_rcold.png  \
 file://input_rcold-configured.png  \
"

SRC_URI_append_azboxminime = " \
 file://rc.png \
 file://rcold.png \
 file://rcpositions.xml \
 file://input_rcnew.png  \
 file://input_rcnew-configured.png \
 file://input_rcold.png  \
 file://input_rcold-configured.png  \
"

S = "${WORKDIR}/git"

do_compile() {
	python -O -m compileall ${S}
}

FILES_${PN} += "${datadir}/keymaps"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES =+ "${PN}-src"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

PACKAGES =+ "enigma2-fonts"
PV_enigma2-fonts = "2010.11.14"
PR_enigma2-fonts = "r0"
PKGV_enigma2-fonts = "${PV_enigma2-fonts}"
FILES_enigma2-fonts = "${datadir}/fonts"

EXTRA_OECONF = "\
	--with-libsdl=no --with-boxtype=${MACHINE} \
	--enable-dependency-tracking \
	--with-imageversion=${AZVERSION}.${AZREVISION} \
	${@base_contains("MACHINE_FEATURES", "textlcd", "--with-textlcd" , "", d)} \
	${@base_contains("MACHINE_FEATURES", "colorlcd", "--with-colorlcd" , "", d)} \
        ${@base_contains("MACHINE_FEATURES", "colorlcd128", "--with-colorlcd128" , "", d)} \
        ${@base_contains("MACHINE_FEATURES", "colorlcd220", "--with-colorlcd220" , "", d)} \
        ${@base_contains("MACHINE_FEATURES", "colorlcd400", "--with-colorlcd400" , "", d)} \
        ${@base_contains("MACHINE_FEATURES", "bwlcd140", "--with-bwlcd140" , "", d)} \
        ${@base_contains("MACHINE_FEATURES", "bwlcd255", "--with-bwlcd255" , "", d)} \
        ${@base_contains("MACHINE_FEATURES", "fullgraphiclcd", "--with-fullgraphiclcd" , "", d)} \
        ${@base_contains("MACHINE_FEATURES", "gigabluelcd", "--with-gigabluelcd" , "", d)} \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

# Swig generated 200k enigma.py file has no purpose for end users
FILES_${PN}-dbg += "\
	/usr/lib/enigma2/python/enigma.py \
	"

# some plugins contain so's, their stripped symbols should not end up in the enigma2 package
FILES_${PN}-dbg += "\
	/usr/lib/enigma2/python/Plugins/*/*/.debug \
	/usr/lib/enigma2/python/Plugins/*/*/*/.debug \
	/usr/lib/enigma2/python/Plugins/*/*/*/*/.debug \
	/usr/lib/enigma2/python/Plugins/*/*/*/*/*/.debug \
	/usr/lib/enigma2/python/Plugins/*/*/*/*/*/*/.debug \
	"

# Save some space by not installing sources (mytest.py must remain)
FILES_${PN}-src = "\
	/usr/lib/enigma2/python/GlobalActions.py \
	/usr/lib/enigma2/python/Navigation.py \
	/usr/lib/enigma2/python/NavigationInstance.py \
	/usr/lib/enigma2/python/RecordTimer.py \
	/usr/lib/enigma2/python/ServiceReference.py \
	/usr/lib/enigma2/python/SleepTimer.py \
	/usr/lib/enigma2/python/e2reactor.py \
	/usr/lib/enigma2/python/keyids.py \
	/usr/lib/enigma2/python/keymapparser.py \
	/usr/lib/enigma2/python/skin.py \
	/usr/lib/enigma2/python/timer.py \
	/usr/lib/enigma2/python/*/*.py \
	/usr/lib/enigma2/python/*/*/*.py \
	/usr/lib/enigma2/python/*/*/*/*.py \
	/usr/lib/enigma2/python/*/*/*/*/*.py \
	/usr/lib/enigma2/python/*/*/*/*/*/*.py \
	"
	
do_preinstall() {
	install -d ${D}${sysconfdir}/enigma2
}

do_preinstall_azboxme() {
	install -d ${D}${sysconfdir}/enigma2	
 	install -m 0644 ${WORKDIR}/rc.png ${S}/data/skin_default/
	install -m 0644 ${WORKDIR}/rcold.png ${S}/data/skin_default/
	install -m 0644 ${WORKDIR}/input_rcnew.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcnew-configured.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcold.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcold-configured.png  ${S}/data/skin_default/icons
}

do_preinstall_azboxminime() {
	install -d ${D}${sysconfdir}/enigma2	
 	install -m 0644 ${WORKDIR}/rc.png ${S}/data/skin_default/
	install -m 0644 ${WORKDIR}/rcold.png ${S}/data/skin_default/
	install -m 0644 ${WORKDIR}/input_rcnew.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcnew-configured.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcold.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcold-configured.png  ${S}/data/skin_default/icons
}

do_preinstall_azboxhd() {
	install -d ${D}${sysconfdir}/enigma2	
 	install -m 0644 ${WORKDIR}/rc.png ${S}/data/skin_default/
	install -m 0644 ${WORKDIR}/rcold.png ${S}/data/skin_default/
	install -m 0644 ${WORKDIR}/input_rcnew.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcnew-configured.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcold.png  ${S}/data/skin_default/icons
	install -m 0644 ${WORKDIR}/input_rcold-configured.png  ${S}/data/skin_default/icons
}

addtask preinstall after do_compile before do_install

do_install_append_azboxme() {
	install -d ${D}/usr/share/enigma2/rc_models/azme
	install -m 0644 ${WORKDIR}/rc.png ${D}/usr/share/enigma2/rc_models/azme
	install -m 0644 ${WORKDIR}/rcpositions.xml ${D}/usr/share/enigma2/rc_models/azme

}

do_install_append_azboxminime() {
	install -d ${D}/usr/share/enigma2/rc_models/azme
	install -m 0644 ${WORKDIR}/rc.png ${D}/usr/share/enigma2/rc_models/azme
	install -m 0644 ${WORKDIR}/rcpositions.xml ${D}/usr/share/enigma2/rc_models/azme
}

do_install_append_azboxhd() {
	install -d ${D}/usr/share/enigma2/rc_models/azhd
	install -m 0644 ${WORKDIR}/rc.png ${D}/usr/share/enigma2/rc_models/azhd
	install -m 0644 ${WORKDIR}/rcpositions.xml ${D}/usr/share/enigma2/rc_models/azhd
}

do_install_append() {
	install -d ${D}/usr/share/keymaps
	find ${D}/usr/lib/enigma2/python/ -name '*.pyc' -exec rm {} \;
}

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
}
