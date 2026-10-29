package androidx.webkit;
public class WebViewFeature {
  public static final String SAFE_BROWSING_PRIVACY_POLICY_URL = "privacy",
      SAFE_BROWSING_ALLOWLIST = "allowlist", SAFE_BROWSING_WHITELIST = "whitelist",
      GET_VARIATIONS_HEADER = "variations", MULTI_PROCESS = "multi";
  public static boolean isFeatureSupported(String feature) { throw new UnsupportedOperationException(); }
}
