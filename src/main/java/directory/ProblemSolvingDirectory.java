package directory;

import exception.NotImplementedException;
import file.BOJSolvingFile;
import judge.OnlineJudge;
import makrdown.MDHelper;

import java.io.File;

public class ProblemSolvingDirectory {

    private final OnlineJudge oj;
    private final File root;
    private final File[] child;
    private final String repoUrl;

    public ProblemSolvingDirectory(File directory, OnlineJudge oj, String hostRepositoryUrl) {
        this.oj = oj;
        root = directory;
        child = root.listFiles();
        this.repoUrl = hostRepositoryUrl;
    }

    public String fileTreeToMarkdown() {
        var sb = new StringBuilder();
        sb.append(ojTitle(root.getName(), oj.getBaseUrl()));

        for (File c : child) {
            if (c.isDirectory()) throw new NotImplementedException("Support Only Depth 1");

            var f = new BOJSolvingFile(c);
            String problemId = f.getProblemId();
            String problemUrl = oj.getProblemUrl(problemId);
            String solvingUrl = repoUrl + "/" + problemId;

            sb.append(listElement(problemId, problemUrl, solvingUrl));
        }

        return sb.toString();
    }

    private String ojTitle(String name, String url) {
        return MDHelper.H1(MDHelper.link(name, url)) + "\n";
    }

    private String listElement(String id, String ojUrl, String myUrl) {
        return MDHelper.list(MDHelper.link(id, ojUrl) + " - " + MDHelper.link("풀이보기", myUrl)) + "\n";
    }

}
