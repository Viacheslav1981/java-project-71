package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Objects;
import java.util.stream.Collectors;

public class Stylish {
    public static String getStylish(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {

        List<String> strings = new ArrayList<>();

        TreeMap<String, Object> commonMap = new TreeMap<>();
        commonMap.putAll(mapFile1);
        commonMap.putAll(mapFile2);

        for (Map.Entry<String, Object> entryCheck : commonMap.entrySet()) {
            String keyCommonMap = entryCheck.getKey();
            Object valueMap1 = mapFile1.get(keyCommonMap);
            Object valueMap2 = mapFile2.get(keyCommonMap);

            if (mapFile1.containsKey(keyCommonMap) && (mapFile2.containsKey(keyCommonMap))) {
                if (Objects.equals(mapFile1.get(keyCommonMap), mapFile2.get(keyCommonMap))) {
                    strings.add(String.format("    %s: %s\n", keyCommonMap, valueMap1));

                } else {
                    strings.add(String.format("  - %s: %s\n", keyCommonMap, valueMap1));
                    strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
                }
            }

            if (!(mapFile1.containsKey(keyCommonMap))) {
                strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                strings.add(String.format("  - %s: %s\n", keyCommonMap, valueMap1));
            }
        }

        String res = String.join("", strings);
        return String.format("{\n%s}", res);
    }
}
