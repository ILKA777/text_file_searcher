package searcher.Utils;

import java.io.File;

final public class GetFileExtension {
    /**
     * Метод для нахождения расширения файла.
     * По сути просто отрезаем из имени файла расширение (кусочек строки)
     * (которое находится после последней точки в названии).
     * @param inputFile
     * @return
     */
    public static String getFileExtension(File inputFile) {
        String fileName = inputFile.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
