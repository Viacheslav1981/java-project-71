package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;

public class Differ {

    public static StringBuilder generate(Path filepath1, Path filepath2) throws IOException {

        String content1 = Files.readString(filepath1);
        String content2 = Files.readString(filepath2);

        TreeMap<String, Object> mapFile1 = Parser.parseFile(content1);
        TreeMap<String, Object> mapFile2 = Parser.parseFile(content2);

        return Stylish.getStylish(mapFile1, mapFile2);
    }

    public static StringBuilder generate(Path filepath1, Path filepath2, String format) throws Exception {

        // Читаем файл
        String content1 = Files.readString(filepath1);
        String content2 = Files.readString(filepath2);

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
