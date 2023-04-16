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

          //  commonMap.entrySet().size();

            String keyCommonMap = entryCheck.getKey();
            Object valueMap1 = mapFile1.get(keyCommonMap);
            Object valueMap2 = mapFile2.get(keyCommonMap);

            if (valueMap1 instanceof Map || valueMap1 instanceof List) {
                valueMap1 = "[complex value]";
            }

            if (valueMap2 instanceof Map || valueMap2 instanceof List) {
                valueMap2 = "[complex value]";
            }

            if (mapFile1.containsKey(keyCommonMap) && (mapFile2.containsKey(keyCommonMap))) {
                if (!Objects.equals(mapFile1.get(keyCommonMap), mapFile2.get(keyCommonMap))) {
                    // resultStr.append("Property " + "'" + keyCommonMap + "' "
                    //         + "was updated. " + "From " + valueMap1 + " to " + valueMap2 + '\n');

                    resultStr.append("Property ").append("'").append(keyCommonMap).append("' ").
                            append("was updated. ").append("From ").append(valueMap1).
                            append(" to ").append(valueMap2).append('\n');
                }
            }

            if (!(mapFile1.containsKey(keyCommonMap))) {
                //  resultStr.append("Property " + "'" + keyCommonMap + "'"
                //        + " was added with value: " + valueMap2 + '\n');
                resultStr.append("Property ").append("'").append(keyCommonMap).
                        append("'").append(" was added with value: ").append(valueMap2).append('\n');
            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                // resultStr.append("Property " + "'" + keyCommonMap + "'" + " was removed." + '\n');
                resultStr.append("Property ").append("'").
                          append(keyCommonMap).append("'").append(" was removed.").append('\n');
            }
        }
      //  resultStr.replaceAll("\n+", "\n")
      //  return resultStr.append("\n");
        return resultStr;
    }
}
