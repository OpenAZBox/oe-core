#!/bin/bash
if [ $# -ne 1 ] ; then
	echo ""
	echo "done creator by Persian Prince v1"
	echo ""
	echo "http://e2pe.com"
	echo ""
        echo "Usage $0 [sources directory]" 
	echo ""
        exit 1
fi
find $1 -type f  -print0 | while IFS= read -r -d $'\0' file; do
    (
    cd "$(dirname "$file")"
    filename="$(basename "$file")"
    echo "creating .done files , please wait"
    touch "$filename".done > /dev/null 2>&1
    rm -rf *.md5.done > /dev/null 2>&1
    rm -rf *.done.done > /dev/null 2>&1
    )
done

