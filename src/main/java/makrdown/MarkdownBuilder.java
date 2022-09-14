package makrdown;

public class MarkdownBuilder {
    private final StringBuilder markdown;
    private final String dirPrefix;
    private final String filePrefix;

    public MarkdownBuilder(StringBuilder sb, String dirPrefix, String filePrefix) {
        markdown = sb;
        this.dirPrefix = dirPrefix;
        this.filePrefix = filePrefix;
    }

    public void appendDir(int depth, String dirName) {
        markdown.append(" ".repeat(depth * 2))
                .append('*').append(" ")
                .append('[').append(dirName).append(']')
                .append('(').append(dirPrefix).append('/').append(dirName).append(')')
                .append('\n');
    }

    public void appendFile(int depth, String fileName) {
        markdown.append(" ".repeat(depth * 2))
                .append('*').append(" ")
                .append('[').append(fileName).append(']')
                .append('(').append(filePrefix).append('/').append(fileName).append(')')
                .append('\n');
    }

    @Override
    public String toString() {
        return markdown.toString();
    }
}
