#!/bin/bash
# Run Knight Runner with Java 24 (required for JavaFX 25)
JAVA_HOME_24="/usr/lib/jvm/jdk-24.0.1-oracle-x64"
JAVAFX_LIB="/home/pius/Documents/openjfx-25.0.2_linux-x64_bin-sdk/javafx-sdk-25.0.2/lib"

"$JAVA_HOME_24/bin/java" \
  --module-path "$JAVAFX_LIB" \
  --add-modules javafx.controls,javafx.graphics \
  -cp out Main
