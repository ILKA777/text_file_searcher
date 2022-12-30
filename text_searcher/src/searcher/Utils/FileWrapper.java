package searcher.Utils;

import java.io.File;

public class FileWrapper implements Comparable {

    private File file;

    /**
     *
     * @param inputFile
     */
    public FileWrapper(File inputFile) {
        this.file = inputFile;
    }

    /**
     * Метод для лексикографического сравнения имен файлов.
     * @param obj the object to be compared.
     * @return
     */
    public int compareTo(Object obj) {
        assert obj instanceof FileWrapper;
        FileWrapper castObj = (FileWrapper) obj;

        // Обычное переопределение compareTo для строковых представлений.
        if (this.file.getName().compareTo(castObj.getFile().getName()) > 0) {
            return 1;
        } else if (this.file.getName().compareTo(castObj.getFile().getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public File getFile() {
        return this.file;
    }
}
