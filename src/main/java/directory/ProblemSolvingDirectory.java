package directory;

import judge.OnlineJudge;
import makrdown.MDHelper;

import java.io.File;

public class ProblemSolvingDirectory {

    private final OnlineJudge oj;
    private final File root;
    private final File[] child;
    private final String repoDirUrl;
    private final String repoFileUrl;
    private final StringBuilder markdown;

    public ProblemSolvingDirectory(File directory, OnlineJudge oj, String hostRepositoryUrl) {
        this.oj = oj;
        root = directory;
        child = root.listFiles();
        repoDirUrl = hostRepositoryUrl;
        repoFileUrl = hostRepositoryUrl.replace("tree", "blob");
        markdown = new StringBuilder();
    }

    public String fileTreeToMarkdown() {
        markdown.append(ojTitle(root.getName(), oj.getBaseUrl()));

        for (File c : child) {

            if (c.isDirectory()) {
                dfs(c,  root.getName() + "/" + c.getName(), 0);
            } else {
                final String name = c.getName().split("\\.")[0];
                markdown.append(listElement(name, oj.getProblemUrl(name), repoFileUrl + "/" + root.getName() + "/" + c.getName()));
            }

        }

        return markdown.toString();
    }

    private void dfs(File parent, String path, Integer depth) {
        if (parent.isDirectory()) {
            markdown.append(depthSpace(depth));
            markdown.append(listDirectoryElement(parent.getName(), repoDirUrl + "/" + path));

            for (File c : parent.listFiles()) {
                dfs(c, path + "/" + c.getName(), depth + 1);
            }
        } else {
            final String name = parent.getName().split("\\.")[0];
            markdown.append(depthSpace(depth));
            markdown.append(listElement(name, oj.getProblemUrl(name), repoFileUrl + "/" + path));
        }
    }

    private String ojTitle(String name, String url) {
        return MDHelper.H1(MDHelper.link(name, url)) + "\n";
    }

    private String listElement(String id, String ojUrl, String myUrl) {
        return MDHelper.list(MDHelper.link(id, ojUrl) + " - " + MDHelper.link("풀이보기", myUrl)) + "\n";
    }

    private String listDirectoryElement(String name, String url) {
        return MDHelper.list(MDHelper.link(name, url)) + "\n";
    }

    private String depthSpace(Integer depth) {
        return " ".repeat(depth * 2);
    }

}
