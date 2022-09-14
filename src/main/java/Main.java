import constant.Constant;
import file.FileWriter;
import makrdown.MarkdownBuilder;
import visitor.FileTreeToStringFileVisitor;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        Constant constant = new Constant();
        Path rootDir = Paths.get(constant.getWorkspacePathString());
        MarkdownBuilder markdownBuilder = new MarkdownBuilder(new StringBuilder(), constant.getDirectoryBaseUrl(), constant.getFileBaseUrl());
        FileTreeToStringFileVisitor<Path> visitor = new FileTreeToStringFileVisitor<>(markdownBuilder);
        Files.walkFileTree(rootDir, visitor);
        String markdown = visitor.getMarkdown();
        FileWriter.write(markdown);
    }

}
