package file;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NameSortFile extends File {
    public NameSortFile(String pathname) {
        super(pathname);
    }

    @Override
    public File[] listFiles() {
        File[] files = super.listFiles();

        File[] nameSortFiles = new NameSortFile[files.length];

        for (int i = 0; i < files.length; i++) {
            nameSortFiles[i] = new NameSortFile(files[i].getPath());
        }
        return nameSortFiles;
    }

    @Override
    public int compareTo(File pathname) {
        final String thisName = getName();
        final String otherName = pathname.getName();

        if (thisName.length() == otherName.length()) {
            return thisName.compareTo(otherName);
        }

        return Integer.compare(thisName.length(), otherName.length());
    }
}
