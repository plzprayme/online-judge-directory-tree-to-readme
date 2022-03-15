package judge;

import directory.ProblemSolvingDirectory;
import exception.NotImplementedException;

import java.io.File;

public class OnlineJudgeResolver {

    public static boolean isImplemented(File directory) {
        return switch (directory.getName()) {
            case "boj" -> true;
            default -> false;
        };
    }

    public static ProblemSolvingDirectory resolve(File directory, String hostRepositoryUrl) {
        return switch (directory.getName()) {
            case "boj" -> new ProblemSolvingDirectory(directory, OnlineJudge.BOJ, hostRepositoryUrl);
            default -> throw new NotImplementedException("NOT IMPLEMENTED ONLINE JUDGE");
        };
    }

}
