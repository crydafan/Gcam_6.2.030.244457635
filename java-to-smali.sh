#!/bin/bash

JAVA_FILE=$1

RELATIVE_PATH="${JAVA_FILE#*app/src/main/java/}"
CLASS_NAME="${RELATIVE_PATH%.java}"
CLASS_DIR=$(dirname "$RELATIVE_PATH")

mkdir -p target/{dex,smali}

/Users/leonardo/Library/Android/sdk/build-tools/37.0.0/d8 --min-api 28 --output target/dex/ target/classes/"$CLASS_NAME"*.class

baksmali d target/dex/classes.dex -o target/smali

sed -i '' 's|defpackage/||g' "target/smali/$CLASS_NAME"*.smali

cp "target/smali/$CLASS_NAME"*.smali "app/src/main/java/$CLASS_DIR/"