package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Differ {

    public static String getExtension(String filePath) {
        String extension = "";
        if (filePath.endsWith(".json")) {
            extension = "json";
        }
        if (filePath.endsWith(".yml")) {
            extension = "yml";
        }
        return extension;
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        String extension1 = getExtension(filepath1);
        String extension2 = getExtension(filepath2);


        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        TreeMap<String, Object> mapFile1 = Parser.parseFile(content1, extension1);
        TreeMap<String, Object> mapFile2 = Parser.parseFile(content2, extension2);

        return Formatter.formatter(mapFile1, mapFile2, format);

    }

}
