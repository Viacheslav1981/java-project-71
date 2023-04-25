package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Plain {
    public static StringBuilder getPlain(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        StringBuilder resultStr = new StringBuilder();

        TreeMap<String, Object> commonMap = new TreeMap<>();
        commonMap.putAll(mapFile1);
        commonMap.putAll(mapFile2);

        for (Map.Entry<String, Object> entryCheck : commonMap.entrySet()) {

            String keyCommonMap = entryCheck.getKey();
           // Object valueMap1 = mapFile1.get(keyCommonMap);
         //   Object valueMap2 = mapFile2.get(keyCommonMap);
            Object valueMap1 = getValueFormat(mapFile1.get(keyCommonMap));
            Object valueMap2 = getValueFormat(mapFile2.get(keyCommonMap));
          //  valueMap1 = getValueFormat(valueMap1);
         //   valueMap2 = getValueFormat(valueMap2);

            if (mapFile1.containsKey(keyCommonMap) && (mapFile2.containsKey(keyCommonMap))) {
                if (!Objects.equals(mapFile1.get(keyCommonMap), mapFile2.get(keyCommonMap))) {
                    resultStr.append("Property ").append("'").append(keyCommonMap).append("' ").
                            append("was updated. ").append("From ").append(valueMap1).
                            append(" to ").append(valueMap2).append('\n');
                }
            }

            if (!(mapFile1.containsKey(keyCommonMap))) {
                resultStr.append("Property ").append("'").append(keyCommonMap).
                        append("'").append(" was added with value: ").append(valueMap2).append('\n');
            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                resultStr.append("Property ").append("'").
                        append(keyCommonMap).append("'").append(" was removed").append('\n');
            }
        }

        return resultStr;
    }

    public static Object getValueFormat(Object valueMap) {
        Object retValueFormat = valueMap;
        if (valueMap instanceof String) {
            retValueFormat = "'" + valueMap + "'";
        }

        if (valueMap instanceof Map || valueMap instanceof List) {
            retValueFormat = "[complex value]";
        }
        return retValueFormat;
    }
}
