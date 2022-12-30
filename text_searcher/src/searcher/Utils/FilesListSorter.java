package searcher.Utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

final public class FilesListSorter {
    /**
     * Сортировка файлов в списке по имени.
     * @param inputFiles
     * @return
     */
    public static File[] sorter(List<File> inputFiles) {
        File[] files = new File[inputFiles.size()];
        int i = 0;
        for (File file : inputFiles) {
            files[i] = file;
            i++;
        }

        FileWrapper[] fileWrappers = new FileWrapper[files.length];
        for (int j = 0; j < files.length; j++) {
            fileWrappers[j] = new FileWrapper(files[j]);
        }

        Arrays.sort(fileWrappers);

        File[] sortedFiles = new File[files.length];
        for (int k = 0; k < files.length; k++) {
            sortedFiles[k] = fileWrappers[k].getFile();
        }
        return sortedFiles;
    }
}
