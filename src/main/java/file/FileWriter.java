package file;

import java.io.IOException;
import java.util.logging.Logger;

public class FileWriter {

    private static final Logger logger = Logger.getLogger(FileWriter.class.getName());

    public static void write(String article) {

        try (java.io.FileWriter w = new java.io.FileWriter("README.md", false)) {
            logger.info("write " + article);
            w.write(article);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }

    }

}
