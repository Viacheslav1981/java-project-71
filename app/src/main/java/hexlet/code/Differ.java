package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Objects;

public class Differ {

    public static List<NodeName> getDifferList(Map<String, Object> mapFile1,
                                               Map<String, Object> mapFile2) {

        List<NodeName> differList = new ArrayList<>();

        TreeMap<String, Object> commonMap = new TreeMap<>();
        commonMap.putAll(mapFile1);
        commonMap.putAll(mapFile2);

        for (Map.Entry<String, Object> entryCheck : commonMap.entrySet()) {
            String keyCommonMap = entryCheck.getKey();
            Object valueMap1 = mapFile1.get(keyCommonMap);
            Object valueMap2 = mapFile2.get(keyCommonMap);
            NodeName nodeName = new NodeName();

            if (mapFile1.containsKey(keyCommonMap) && (mapFile2.containsKey(keyCommonMap))) {
                if (Objects.equals(valueMap1, valueMap2)) {
                    nodeName.setKey(keyCommonMap);
                    nodeName.setValue(valueMap1);
                    nodeName.setType(NodeStatus.UNCHANGED);
                    differList.add(nodeName);

                } else {
                    nodeName.setKey(keyCommonMap);
                    nodeName.setValue(valueMap1);
                    nodeName.setUpdatedValue(valueMap2);
                    nodeName.setType(NodeStatus.UPDATED);
                    differList.add(nodeName);
                }
            }
            if (!(mapFile1.containsKey(keyCommonMap))) {
                nodeName.setKey(keyCommonMap);
                nodeName.setValue(valueMap2);
                nodeName.setType(NodeStatus.ADDED);
                differList.add(nodeName);

            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                nodeName.setKey(keyCommonMap);
                nodeName.setValue(valueMap1);
                nodeName.setType(NodeStatus.REMOVED);
                differList.add(nodeName);
            }
        }

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
