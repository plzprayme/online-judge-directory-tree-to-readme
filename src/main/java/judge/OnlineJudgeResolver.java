package judge;

import directory.ProblemSolvingDirectory;
import exception.NotImplementedException;

import java.io.File;

public class OnlineJudgeResolver {

    public static boolean isImplemented(File directory) {
        return switch (directory.getName().toLowerCase()) {
            case "boj" -> true;
            case "leetcode" -> true;
            default -> false;
        };
    }

    public static ProblemSolvingDirectory resolve(File directory, String hostRepositoryUrl) {
        return switch (directory.getName().toLowerCase()) {
            case "boj" -> new ProblemSolvingDirectory(directory, OnlineJudge.BOJ, hostRepositoryUrl);
            case "leetcode" -> new ProblemSolvingDirectory(directory, OnlineJudge.LEETCODE, hostRepositoryUrl);
            default -> throw new NotImplementedException("NOT IMPLEMENTED ONLINE JUDGE");
        };
    }

}
