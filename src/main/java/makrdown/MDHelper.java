package makrdown;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MDHelper {

    public static String H1(String s) {
        return "# " + s;
    }

    public static String encode(String url) {
        String[] splitScheme = url.split("://");

        StringBuilder encodedUrl = new StringBuilder();
        encodedUrl.append(splitScheme[0]).append(":/");

        for (String plaintext : splitScheme[1].split("/")) {
            encodedUrl.append("/").append(URLEncoder.encode(plaintext, StandardCharsets.UTF_8).replace("+", "%20"));
        }
        return encodedUrl.toString();
    }

    public static String link(String s, String url) {
        return "[" + s + "]" + "(" + encode(url) + ")";
    }

    public static String list(String s) {
        return "* " + s;
    }

}
