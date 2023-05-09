package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class Differ {

    public static List<NodeName> getDifferList(Map<String, Object> mapFile1,
                                               Map<String, Object> mapFile2) {

        List<NodeName> differList = new ArrayList<>();
        Set<String> allKeys = new TreeSet<>();

        allKeys.addAll(mapFile1.keySet());
        allKeys.addAll(mapFile2.keySet());

        for (String key : allKeys) {
            Object valueMap1 = mapFile1.get(key);
            Object valueMap2 = mapFile2.get(key);

            if (!(mapFile1.containsKey(key)) || !(mapFile2.containsKey(key))) {
                if (!(mapFile1.containsKey(key))) {
                    differList.add(new NodeName(NodeStatus.ADDED, key, valueMap2, null));
                } else {
                    differList.add(new NodeName(NodeStatus.REMOVED, key, valueMap1, null));
                }
            } else {
                if (Objects.equals(valueMap1, valueMap2)) {
                    differList.add(new NodeName(NodeStatus.UNCHANGED, key, valueMap1, valueMap2));
                } else {
                    differList.add(new NodeName(NodeStatus.UPDATED, key, valueMap1, valueMap2));
                }
            }
        }


        /*
        for (String key : allKeys) {
            Object valueMap1 = mapFile1.get(key);
            Object valueMap2 = mapFile2.get(key);

            if (mapFile1.containsKey(key) && (mapFile2.containsKey(key))) {
                if (Objects.equals(valueMap1, valueMap2)) {
                    differList.add(new NodeName(NodeStatus.UNCHANGED, key, valueMap1, valueMap2));

                } else {
                    differList.add(new NodeName(NodeStatus.UPDATED, key, valueMap1, valueMap2));
                }
            }
            if (!(mapFile1.containsKey(key))) {
                differList.add(new NodeName(NodeStatus.ADDED, key, valueMap2, null));
            }
            if (!(mapFile2.containsKey(key))) {
                differList.add(new NodeName(NodeStatus.REMOVED, key, valueMap1, null));
            }
        }

         */

        return differList;
    }

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

        List<NodeName> differList = getDifferList(mapFile1, mapFile2);

        return Formatter.formatter(differList, format);

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
