package directory;

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
        System.out.println("ROOT : " + root.getName());
        sb.append(ojTitle(root.getName(), oj.getBaseUrl()));

        for (File c : child) {
            sb.append(dfs(c, root.getName(), sb, 0));
//            var f = new BOJSolvingFile(c);
//            String problemId = f.getProblemId();
//            String problemUrl = oj.getProblemUrl(problemId);
//            String solvingUrl = repoUrl + "/" + problemId;
//
//            sb.append(listElement(problemId, problemUrl, solvingUrl));
        }

        return sb.toString();
    }

    private StringBuilder dfs(File parent, String path, StringBuilder sb, Integer depth) {
        if (parent.isDirectory()) {
            // [폴더이름](저장소 + "/" + path)
            sb.append(depthSpace(depth));
            sb.append(listDirectoryElement(parent.getName(), repoUrl + "/" + path));

            for (File c : parent.listFiles()) {
                sb.append(dfs(c, path + "/" + c.getName(), sb, depth + 1));
            }
        } else {
            // 문제이름 - [풀이보기](저장소 + "/" + path)
            System.out.println("IS NOT DIRECTORY : " + parent.getName());
            final String name = parent.getName().split("\\.")[0];
            sb.append(depthSpace(depth));
            sb.append(listElement(name, oj.getBaseUrl(), repoUrl + "/" + parent.getName()));
        }

        return sb;
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
