#!/bin/bash

# Adapted from https://github.com/chrisbanes/tivi/blob/main/checksum.sh
set -e

RESULT_FILE=$1

if [ -f $RESULT_FILE ]; then
  rm $RESULT_FILE
fi

checksum_file() {
  echo $(openssl md5 $1 | awk '{print $2}')
}

export -f checksum_file

find . -type f \( -name "build.gradle*" -o -name "gradle-wrapper.properties" -o -path "*/buildSrc/*" -name "*.kt" \) | \
  xargs -I {} bash -c 'checksum_file "{}"' | \
  sort > $RESULT_FILE
