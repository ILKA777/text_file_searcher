package searcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static searcher.controller.FileWriter.fileWriter;
import static searcher.Utils.FilesListSorter.sorter;
import static searcher.controller.TextFileSearcher.dirIterator;

public class Main {
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        /**
         * Программа работает, пока не будет введена команда "q".
         */
        while (true) {
            System.out.println("Введите путь к корневой папке: ");
            String path = in.nextLine();
            if (path.equals("q")) {
                break;
            }

            // Проверяем есть ли по данному пути файл.
            File f = new File(path);
            if (!f.exists()) {
                System.out.println("Файла/директории с таким путём не существует: " + path);
                System.out.println("Попробойте ввести путь еще раз или введите q, чтобы выйти");

                continue;
            }

            // Проверяем находиться ли по введенному пути директория.
            if (!f.isDirectory()) {
                System.out.println("Путь, который вы ввели не ведет к директории " + path);
                continue;
            }

            /*
            Создаем лист файлов и заполняем его
            всеми найденными в корневой папке
            текстовыми файлами.
             */
            List<File> files = new ArrayList<File>();
            files = dirIterator(path);

            /*
             Создаем и заполняем массив файлов для дальнейшей
             удобной работой с ним.
             */
            File[] files2 = new File[files.size()];

            int k = 0;
            for (var file : files) {
                files2[k] = file;
                k++;
            }

            // Сортируем файлы по именам.
            files2 = sorter(files);
            files.clear();
            /*
             Записываем в отдельный файл текст из
             найденных текстовых файлов.
             */
            fileWriter(files2);
        }
    }
}