package searcher.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static searcher.Utils.GetFileExtension.getFileExtension;
public class TextFileSearcher {
    static List<File> files = new ArrayList<File>();

    /**
     * Проход по корневой папке и поиск txt файлов.
     * @param path
     * @return
     */
    public static List<File> dirIterator(String path) {

        File f = new File(path);

        // Получаем список файлов в директории.
        String[] dirList = f.list();

        // Проходимся по списку файлов и ищем текстовые.
        for (int i = 0; i < dirList.length; i++) {

            // Создаем промежуточный файл (то что мы встретили пока перебирали папку).
            File intermediateFile = new File(path + File.separator + dirList[i]);

            // Если то что нашли все таки файл то проверяем его расширение.
            if (intermediateFile.isFile()) {

                // Если файл имеет расширение txt добавляем его в список.
                String fileType = getFileExtension(intermediateFile);
                if (fileType.equals("txt")) {
                    files.add(intermediateFile);
                }
            } else {
                dirIterator(path + File.separator + dirList[i]);
            }
        }
        return files;
    }
}
