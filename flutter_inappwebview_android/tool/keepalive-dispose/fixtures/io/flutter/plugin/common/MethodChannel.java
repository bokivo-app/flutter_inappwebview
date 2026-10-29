package io.flutter.plugin.common;
public class MethodChannel {
  public interface MethodCallHandler { void onMethodCall(MethodCall call, Result result); }
  public interface Result { void success(Object value); void notImplemented(); }
  public MethodChannel(Object messenger, String name) {}
  public void setMethodCallHandler(MethodCallHandler handler) {}
}
