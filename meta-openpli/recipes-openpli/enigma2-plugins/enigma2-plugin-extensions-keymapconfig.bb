DESCRIPTION = "Keymap Config by Ping Flood"
RDEPENDS = "enigma2"
DEPENDS = "python-native"
require conf/license/openpli-gplv2.inc

SRCREV_pn-${PN} ?= "${AUTOREV}"

inherit gitpkgv pkgconfig

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "${AZVERSION}.${AZREVISION}"

SRC_URI = "git://github.com/pingflood/keymapconfig.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
	python -O -m compileall ${S}
}

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
	do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
}

do_install() {
	install -d  ${D}/usr/lib/enigma2/python/Plugins/Extensions/KeymapConfig
	
	install -m 0644 ${S}/*.pyo \
	${D}/usr/lib/enigma2/python/Plugins/Extensions/KeymapConfig

        install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/KeymapConfig/keymap/
        install -m 0644 ${S}/keymap/*.xml ${D}/usr/lib/enigma2/python/Plugins/Extensions/KeymapConfig/keymap/
}

FILES_enigma2-plugin-extensions-keymapconfig = "/usr/lib/enigma2/python/Plugins/Extensions/KeymapConfig"

PACKAGES = "enigma2-plugin-extensions-keymapconfig"

PROVIDES="${PACKAGES}"
