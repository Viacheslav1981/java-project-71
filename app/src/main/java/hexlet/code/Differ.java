package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

        Map<String, Object> mapFile1 = new TreeMap<>();
        Map<String, Object> mapFile2 = new TreeMap<>();

        mapFile1.putAll(Parser.parseFile(getFileContent(filepath1),
                getExtension(filepath1)));
        mapFile2.putAll(Parser.parseFile(getFileContent(filepath2),
                getExtension(filepath2)));

        List<NodeName> differList = Represent.getDifferList(mapFile1, mapFile2);

        return Formatter.formatter(differList, format);

    }

    private static String getFileContent(String filepath) throws IOException {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
