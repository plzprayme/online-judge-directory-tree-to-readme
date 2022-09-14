package constant;

public class Constant {

    public static final String workspacePathString = System.getenv().get("GITHUB_WORKSPACE");

    private static final String baseUrlFormat = System.getenv().get("GITHUB_SERVER_URL") + "/"
            + System.getenv().get("GITHUB_REPOSITORY") + "/%s" + "/"
            + System.getenv().get("GITHUB_REF_NAME");

    public String getWorkspacePathString() {
        return workspacePathString;
    }

    public String getDirectoryBaseUrl() {
        return String.format(baseUrlFormat, "tree");
    }

    public String getFileBaseUrl() {
        return String.format(baseUrlFormat, "blob");
    }
}
