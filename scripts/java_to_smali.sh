#!/bin/bash

JAVA_FILE=$1

RELATIVE_PATH="${JAVA_FILE#*app/src/main/java/}"
RELATIVE_PATH="${RELATIVE_PATH%.java}"
CLASS_DIR=$(dirname "$RELATIVE_PATH")
CLASS_NAME=$(basename "$RELATIVE_PATH")

mkdir -p app/build/intermediates/{dex,smali}/debug

/Users/leonardo/Library/Android/sdk/build-tools/37.0.0/d8 --min-api 28 --output app/build/intermediates/dex/debug/ app/build/intermediates/javac/debug/classes/"$RELATIVE_PATH"*.class

java -jar tools/baksmali.jar d app/build/intermediates/dex/debug/classes.dex -o app/build/intermediates/smali/debug

sed -i '' 's|defpackage/||g' "app/build/intermediates/smali/debug/$RELATIVE_PATH"*.smali

cp "app/build/intermediates/smali/debug/$RELATIVE_PATH"*.smali "app/src/main/java/$CLASS_DIR/"