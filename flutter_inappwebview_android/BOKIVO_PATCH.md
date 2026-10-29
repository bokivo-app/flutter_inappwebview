# Bokivo keep-alive teardown backport (https://github.com/bokivo-app/flutter-app/issues/2594)

Base: upstream tag v6.1.5, commit f67ae1f34868c7660c16a2473f53a7a7bfb6f784.
The Android package remains 1.1.3 and keeps platform_interface ^1.3.0.
Only the Java null guard from upstream commit
4ba6e22848aae9c2ca16bc784023b7fa98cf61e3 is backported; the stable Dart API,
AndroidX versions and other platform packages are unchanged.

Sources:
- Base: https://github.com/pichillilorenzo/flutter_inappwebview/tree/f67ae1f34868c7660c16a2473f53a7a7bfb6f784
- Fix: https://github.com/pichillilorenzo/flutter_inappwebview/commit/4ba6e22848aae9c2ca16bc784023b7fa98cf61e3
- License retained unchanged: flutter_inappwebview_android/LICENSE (Apache-2.0,
  Copyright 2023 Lorenzo Pichilli). The modified Java file carries a change notice.
  Added test material is distributed under the same license.

The official Android 1.2.0-beta.3 package resolved but failed Dart compilation
with flutter_inappwebview 6.1.5: its required platform_interface 1.4.0-beta.3 adds
InAppBrowser event members and incompatible method signatures. This stable
backport is the fallback explicitly authorized by https://github.com/bokivo-app/flutter-app/issues/2594, decision L1.

Run from the repository root with a JDK installed:

    bash flutter_inappwebview_android/tool/keepalive-dispose/check.sh

The test compiles the real production InAppWebViewManager and ChannelDelegateImpl.
Provider fixtures only satisfy Android/Flutter APIs without a running engine.
It exercises disposeKeepAlive followed by dispose with released and live entries.
The unmodified stable manager fails with NullPointerException at keepAliveId;
the guard makes it pass. Fixtures fail on unrelated Android API calls.

This JVM test proves the manager's Java null-handling logic. It does not prove
Android WebView behavior, FlutterEngine or MainActivity destruction. Physical
candidate acceptance remains S2-03 and S2-02, with SHA/APK, PID, logcat and explicit
MainActivity destruction evidence. Follow-up https://github.com/bokivo-app/flutter-app/issues/2778 tracks removing this exception.
