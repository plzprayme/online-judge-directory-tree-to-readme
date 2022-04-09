import directory.ProblemSolvingDirectory;
import judge.OnlineJudge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ApplicationTest {

    private static String repositoryUrl;
    private static String onlineJudgeUrl;
    private static File depth1RootDirectory;
    private static File depth2RootDirectory;

    @BeforeAll
    public static void setup() {
        repositoryUrl = "https://github.com/plzprayme/oj-github-action-repo";
        depth1RootDirectory = new File("src/test/resources/test-data/depth1/boj");
        depth2RootDirectory = new File("src/test/resources/test-data/depth2/boj");
    }

    @Test
    public void 뎁스1_리드미_생성() {
        ProblemSolvingDirectory given = new ProblemSolvingDirectory(depth1RootDirectory, OnlineJudge.BOJ, repositoryUrl);

        // when
        String actual = given.fileTreeToMarkdown();

        // then
        System.out.println(actual);
    }

    @Test
    public void 뎁스2_리드미_생성() {
        ProblemSolvingDirectory given = new ProblemSolvingDirectory(depth2RootDirectory, OnlineJudge.BOJ, repositoryUrl);

        // when
        String actual = given.fileTreeToMarkdown();

        // then
        System.out.println(actual);
    }

}
