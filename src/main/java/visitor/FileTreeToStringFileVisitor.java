package visitor;

import constant.Constant;
import makrdown.MarkdownBuilder;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Logger;

public class FileTreeToStringFileVisitor<T extends Path> implements FileVisitor<T> {

    private static final Logger logger = Logger.getLogger(FileTreeToStringFileVisitor.class.getName());

    private final MarkdownBuilder markdownBuilder;
    private int currentDepth;

    public FileTreeToStringFileVisitor(MarkdownBuilder markdownBuilder) {
        this.markdownBuilder = markdownBuilder;
        this.currentDepth = 0;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (dir.getFileName().startsWith("workspace")) {
            return FileVisitResult.CONTINUE;
        }

        if (isPrivateDir(dir)) {
            return FileVisitResult.SKIP_SUBTREE;
        }

        final String fileName = dir.getFileName().toString();
        markdownBuilder.appendDir(currentDepth, fileName);

        currentDepth++;

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (isPrivateDir(file)) {
            return FileVisitResult.CONTINUE;
        }

        final String fileName = file.getFileName().toString();
        markdownBuilder.appendFile(currentDepth, fileName);

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        logger.info("visit failed on " + file.getFileName().toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        currentDepth--;
        return FileVisitResult.CONTINUE;
    }

    private boolean isPrivateDir(Path dir) {
        return dir.getFileName().toString().startsWith(".");
    }

    public String getMarkdown() {
        return markdownBuilder.toString();
    }
}
