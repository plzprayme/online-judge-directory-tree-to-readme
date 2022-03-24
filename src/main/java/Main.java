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

        final String repositoryRootPath = args[0]; // /github/workspace
        final File directory = new File(repositoryRootPath);
        System.out.println("PATH : " + directory.getPath());
        System.out.println("ABSOLUTE PATH : " + directory.getAbsolutePath());

        final String hostRepositoryUrl = "https://github.com/" + args[1]; // owner/repositoryName
        System.out.println("HOST REPOSITORY URL : " + hostRepositoryUrl);

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
