package file;

import java.io.File;

public class BOJSolvingFile extends ProblemSolvingFile {

    private final String fileName;
    private final String problemId;
    private final String fileExtension;

    public BOJSolvingFile(File file) {
        fileName = file.getName();
        String[] splited = fileName.split("\\.");
        problemId = splited[0];
        fileExtension = splited[1];
    }

    public String getProblemId() {
        return problemId;
    }
}
