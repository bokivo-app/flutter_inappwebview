package com.pichillilorenzo.flutter_inappwebview_android.webview;

import android.os.Message;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.FlutterWebView;

/** Executes the production Java manager; Android/Flutter providers are fixtures. */
public final class KeepAliveDisposeTest {
  public static void main(String[] args) {
    InAppWebViewManager manager =
        new InAppWebViewManager(new InAppWebViewFlutterPlugin());
    FlutterWebView released = new FlutterWebView("released");
    FlutterWebView live = new FlutterWebView("live");
    manager.keepAliveWebViews.put("released", released);
    manager.keepAliveWebViews.put("live", live);
    manager.windowWebViewMessages.put(1, new Message());

    // Same public sequence used when Turnstile unmounts before engine detach.
    manager.disposeKeepAlive("released");
    require(released.closed, "unmount must release its WebView");
    require(manager.keepAliveWebViews.containsKey("released")
        && manager.keepAliveWebViews.get("released") == null,
        "the stable plugin leaves a tombstone after unmount");

    manager.dispose();
    require(live.closed, "engine detach must release remaining live WebViews");
    require(manager.keepAliveWebViews.isEmpty(), "keep-alive registry must clear");
    require(manager.windowWebViewMessages.isEmpty(), "window messages must clear");
    require(manager.plugin == null && manager.getChannel() == null,
        "engine references and channel must detach");
    manager.dispose(); // Repeated detach must stay safe.
    System.out.println("PASS: released and live keep-alives detach safely");
  }

  private static void require(boolean condition, String message) {
    if (!condition) throw new AssertionError(message);
  }
}
