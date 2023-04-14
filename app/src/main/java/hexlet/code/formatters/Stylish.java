package hexlet.code.formatters;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Stylish {
    public static StringBuilder getStylish(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {

        StringBuilder resultStr = new StringBuilder("{").append('\n');

        TreeMap<String, Object> commonMap = new TreeMap<>();
        commonMap.putAll(mapFile1);
        commonMap.putAll(mapFile2);

        for (Map.Entry<String, Object> entryCheck : commonMap.entrySet()) {
            String keyCommonMap = entryCheck.getKey();
            Object valueMap1 = mapFile1.get(keyCommonMap);
            Object valueMap2 = mapFile2.get(keyCommonMap);

            if (mapFile1.containsKey(keyCommonMap) && (mapFile2.containsKey(keyCommonMap))) {
                if (Objects.equals(mapFile1.get(keyCommonMap), mapFile2.get(keyCommonMap))) {
                    resultStr.append("    ").append(keyCommonMap).append(": ").append(valueMap1).append('\n');
                } else {
                    resultStr.append("  - ").append(keyCommonMap).append(": ").append(valueMap1).append('\n');
                    resultStr.append("  + ").append(keyCommonMap).append(": ").append(valueMap2).append('\n');
                }
            }

            if (!(mapFile1.containsKey(keyCommonMap))) {
                resultStr.append("  + ").append(keyCommonMap).append(": ").append(valueMap2).append('\n');
            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                resultStr.append("  - ").append(keyCommonMap).append(": ").append(valueMap1).append('\n');

            }
        }

      //  return resultStr.append("}").append('\n');
        return resultStr.append("}").append("\\");
    }
}
