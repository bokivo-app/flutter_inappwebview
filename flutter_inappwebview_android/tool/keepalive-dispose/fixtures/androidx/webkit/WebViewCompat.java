package androidx.webkit;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.webkit.ValueCallback;
import java.util.List;
import java.util.Set;
public class WebViewCompat {
  public static String getSafeBrowsingPrivacyPolicyUrl() { throw new UnsupportedOperationException(); }
  public static void setSafeBrowsingAllowlist(Set<String> hosts, ValueCallback<Boolean> callback) { throw new UnsupportedOperationException(); }
  public static void setSafeBrowsingWhitelist(List<String> hosts, ValueCallback<Boolean> callback) { throw new UnsupportedOperationException(); }
  public static PackageInfo getCurrentWebViewPackage(Context context) { throw new UnsupportedOperationException(); }
  public static String getVariationsHeader() { throw new UnsupportedOperationException(); }
  public static boolean isMultiProcessEnabled() { throw new UnsupportedOperationException(); }
}
