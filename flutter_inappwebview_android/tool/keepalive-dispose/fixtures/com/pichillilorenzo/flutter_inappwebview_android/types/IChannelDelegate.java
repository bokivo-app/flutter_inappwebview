package com.pichillilorenzo.flutter_inappwebview_android.types;
import io.flutter.plugin.common.MethodChannel;
public interface IChannelDelegate extends MethodChannel.MethodCallHandler {
  MethodChannel getChannel();
  void dispose();
}
