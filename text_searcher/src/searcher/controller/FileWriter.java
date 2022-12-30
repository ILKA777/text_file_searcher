package searcher.controller;

import java.io.*;

final public class FileWriter {
    /**
     * Метод для записи (конкатенации) найденных
     * текстовых файлов в новый файл "result.txt"
     * @param inputFiles
     */
    public static void fileWriter(File[] inputFiles) {
        try {

            // Используем потоки.
            OutputStream out = new FileOutputStream("result.txt");
            byte[] buf = new byte[10000];

            for (File file : inputFiles) {
                InputStream inp = new FileInputStream(file);
                int b = 0;

                // Считываем текст из найденных файлов.
                while ((b = inp.read(buf)) >= 0) {

                    // Записываем его.
                    out.write(buf, 0, b);
                }

                /*
                 Добавляем разделитель, чтобы при записи текста
                 из нескольких файлов, он не слипался.
                 */
                out.write(System.lineSeparator().getBytes());
                inp.close();
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         Файл создаться даже если в корневой папке не было txt файлов.
         В таком случае файл будет пустой.
         */
        System.out.println("Результат объединения текстовых файлов записан в файл");
        System.out.println("result.txt");
    }

}
