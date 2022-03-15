import directory.ProblemSolvingDirectory;
import judge.OnlineJudgeResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        final File directory = new File(System.getProperty("user.dir"));
        System.out.println(directory.getPath());
        System.out.println(directory.getAbsolutePath());

        final String hostRepositoryUrl = args[0];

        List<ProblemSolvingDirectory> directories = Arrays.stream(directory.listFiles())
                .filter(OnlineJudgeResolver::isImplemented)
                .map(f -> OnlineJudgeResolver.resolve(f, hostRepositoryUrl))
                .toList();

        String markdown = directories.stream()
                .map(ProblemSolvingDirectory::fileTreeToMarkdown)
                .collect(Collectors.joining());

        File readme = new File("README.md");
        try {
            Files.writeString(readme.toPath(), markdown, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
