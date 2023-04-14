package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Differ {

    public static StringBuilder generate(String filepath1, String filepath2) throws IOException {

        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();


        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        TreeMap<String, Object> mapFile1 = Parser.parseFile(content1);
        TreeMap<String, Object> mapFile2 = Parser.parseFile(content2);

        return Stylish.getStylish(mapFile1, mapFile2);
    }

    public static StringBuilder generate(String filepath1, String filepath2, String format) throws Exception {

        // Читаем файл

        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        TreeMap<String, Object> mapFile1 = Parser.parseFile(content1);
        TreeMap<String, Object> mapFile2 = Parser.parseFile(content2);

        if (format.equals("plain")) {
            return Plain.getPlain(mapFile1, mapFile2);
        }
        if (format.equals("json")) {

            return Json.getJsonOut(mapFile1, mapFile2);
        }

        return Stylish.getStylish(mapFile1, mapFile2);
    }

}
