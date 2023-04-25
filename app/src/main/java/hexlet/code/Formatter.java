package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.Map;

public class Formatter {

    public static String formatter(Map<String, Object> mapFile1,
                                   Map<String, Object> mapFile2,
                                   String format) throws IOException {

        switch (format) {
            case ("plain") -> {
                return Plain.getPlain(mapFile1, mapFile2).toString().trim();
            }
            case ("json") -> {
                return Json.getJsonOut(mapFile1, mapFile2);
            }
            default -> {
                return Stylish.getStylish(mapFile1, mapFile2).toString().trim();
            }

        }
    }

}
