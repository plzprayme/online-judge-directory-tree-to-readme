package makrdown;

public class MDHelper {

    public static String H1(String s) {
        return "# " + s;
    }

    public static String link(String s, String url) {
        return "[" + s + "]" + "(" + url + ")";
    }

    public static String list(String s) {
        return "* " + s;
    }

}
