package com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview;
import android.view.View;
/** Resource-provider fixture: never constructs or claims to test Android WebView. */
public class FlutterWebView {
  public String keepAliveId;
  public boolean closed;
  public FlutterWebView(String id) { keepAliveId = id; }
  public View getView() { return null; }
  public void dispose() {
    if (closed) throw new AssertionError("WebView disposed twice");
    closed = true;
  }
}
