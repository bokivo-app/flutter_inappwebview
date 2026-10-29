#!/usr/bin/env bash
set -euo pipefail
script_dir="$(cd -- "$(dirname -- "$0")" && pwd)"
classes="$(mktemp -d /tmp/inappwebview-keepalive-test.XXXXXX)"
trap 'rm -rf "$classes"' EXIT
shopt -s globstar nullglob
fixtures=("$script_dir"/fixtures/**/*.java)
javac -d "$classes" "${fixtures[@]}" \
  "$script_dir/KeepAliveDisposeTest.java" \
  "$script_dir/../../android/src/main/java/com/pichillilorenzo/flutter_inappwebview_android/webview/InAppWebViewManager.java" \
  "$script_dir/../../android/src/main/java/com/pichillilorenzo/flutter_inappwebview_android/types/ChannelDelegateImpl.java"
java -cp "$classes" \
  com.pichillilorenzo.flutter_inappwebview_android.webview.KeepAliveDisposeTest
