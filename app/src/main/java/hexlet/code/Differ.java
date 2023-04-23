package hexlet.code;

import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws IOException {

        String extension1 = "";
        // String extension2 = "";
        if (filepath1.endsWith(".json")) {
            extension1 = "json";
        }

        if (filepath1.endsWith(".yml")) {
            extension1 = "yml";
        }

        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();


        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        TreeMap<String, Object> mapFile1 = Parser.parseFile(content1, extension1);
        TreeMap<String, Object> mapFile2 = Parser.parseFile(content2, extension1);

        return Stylish.getStylish(mapFile1, mapFile2).toString().trim();
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        // Читаем файл
        String extension1 = "";
        // String extension2 = "";
        if (filepath1.endsWith(".json")) {
            extension1 = "json";
        }

        if (filepath1.endsWith(".yml")) {
            extension1 = "yml";
        }

        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        //  Path path1 = Paths.get(filepath1);
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
        //   Path path2 = Paths.get(filepath2);

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        TreeMap<String, Object> mapFile1 = Parser.parseFile(content1, extension1);
        TreeMap<String, Object> mapFile2 = Parser.parseFile(content2, extension1);

        return Formatter.formatter(mapFile1, mapFile2, format);
        /*
        if (format.equals("plain")) {
            return Plain.getPlain(mapFile1, mapFile2).toString().trim();
        }
        if (format.equals("json")) {

            return Json.getJsonOut(mapFile1, mapFile2);
        }
        return Stylish.getStylish(mapFile1, mapFile2).toString().trim();

         */
    }

}
