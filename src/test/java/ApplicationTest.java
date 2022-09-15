import directory.ProblemSolvingDirectory;
import file.NameSortFile;
import judge.OnlineJudge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ApplicationTest {

    private static String repositoryUrl;
    private static String onlineJudgeUrl;
    private static File depth1RootDirectory;
    private static File depth2RootDirectory;
    private static File leetcodeDirectory;
    private static File otherDirectory;

    @BeforeAll
    public static void setup() {
        repositoryUrl = "https://github.com/plzprayme/oj-github-action-repo";
        depth1RootDirectory = new File("src/test/resources/test-data/depth1/boj");
        depth2RootDirectory = new File("src/test/resources/test-data/depth2/boj");
        leetcodeDirectory = new File("src/test/resources/test-data/depth2withleetcode/leetcode");
        otherDirectory = new File("src/test/resources/test-data/other");
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

    @Test
    public void 뎁스2_리트코드_포함_리드미_생성() {
        ProblemSolvingDirectory given = new ProblemSolvingDirectory(leetcodeDirectory, OnlineJudge.LEETCODE, repositoryUrl);

        // when
        String actual = given.fileTreeToMarkdown();

        // then
        System.out.println(actual);
    }

    @Test
    public void 일반_폴더도_지원() {
        ProblemSolvingDirectory given = new ProblemSolvingDirectory(otherDirectory, OnlineJudge.DIRECTORY, repositoryUrl);

        // when
        String actual = given.fileTreeToMarkdown();

        // then
        System.out.println(actual);
    }

    @Test
    public void 정렬테스트() {
        // given
        File f1 = new NameSortFile("src/test/resources/test-data/sort");
        File[] files = f1.listFiles();

        // when
        List<File> actual = Arrays.stream(files)
                .sorted()
                .collect(Collectors.toList());

        assertThat(actual.get(0).getName(), is("week_1"));
        assertThat(actual.get(1).getName(), is("week_2"));
        assertThat(actual.get(2).getName(), is("week_3"));
        assertThat(actual.get(3).getName(), is("week_10"));
        assertThat(actual.get(4).getName(), is("week_11"));
        assertThat(actual.get(5).getName(), is("week_12"));
    }

}
