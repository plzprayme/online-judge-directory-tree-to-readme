package judge;

public enum OnlineJudge {
    BOJ("boj", "https://www.acmicpc.net", "https://www.acmicpc.net/problem"),
    LEETCODE("leetcode", "https://leetcode.com/", "https://leetcode.com/problems");

    private final String directoryName;
    private final String baseUrl;
    private final String problemUrl;

    OnlineJudge(String directoryName, String baseUrl, String problemUrl) {
        this.directoryName = directoryName;
        this.baseUrl = baseUrl;
        this.problemUrl = problemUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getProblemUrl(String problemId) {
        return problemUrl + "/" + problemId;
    }
}
