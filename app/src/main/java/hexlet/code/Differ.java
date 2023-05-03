package hexlet.code;

import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String getExtension(String filePath) {

        return filePath.substring(filePath.indexOf(".") + 1);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Map<String, String> mapForParsing1 = getMapFileContent(filepath1);
        Map<String, String> mapForParsing2 = getMapFileContent(filepath2);

        Map<String, Object> mapFile1 = new TreeMap<>();
        Map<String, Object> mapFile2 = new TreeMap<>();

        for (Map.Entry<String, String> oneFile : mapForParsing1.entrySet()) {
            mapFile1 = Parser.parseFile(oneFile.getKey(),
                    oneFile.getValue());
        }
        for (Map.Entry<String, String> oneFile : mapForParsing2.entrySet()) {
            mapFile2 = Parser.parseFile(oneFile.getKey(),
                    oneFile.getValue());
        }

       // Format.getDifferList(mapFile1, mapFile2);
        System.out.println(Stylish.getStylishTest(Format.getDifferList(mapFile1, mapFile2)));

        return Formatter.formatter(mapFile1, mapFile2, format);

    }

    private static Map<String, String> getMapFileContent(String filepath) throws IOException {
        Map<String, String> fileMap = new TreeMap<>();

        String extension = getExtension(filepath);
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        String content = Files.readString(path);

        fileMap.put(content, extension);

        return fileMap;
    }

}
