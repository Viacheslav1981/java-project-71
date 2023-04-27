package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Objects;
import java.util.stream.Collectors;

public class Stylish {
    public static String getStylish(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {

      //  StringBuilder resultStr = new StringBuilder("{").append('\n');
        String res;
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
                  //  resultStr.append("    ").append(keyCommonMap).append(": ").append(valueMap1).append('\n');
                   // res = String.format("    %s: %s\n", keyCommonMap, valueMap1 );
                    strings.add(String.format("    %s: %s\n", keyCommonMap, valueMap1));

                } else {
                    strings.add(String.format("  - %s: %s\n", keyCommonMap, valueMap1));
                    strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
                //    resultStr.append("  - ").append(keyCommonMap).append(": ").append(valueMap1).append('\n')
                 //           .append("  + ").append(keyCommonMap).append(": ").append(valueMap2).append('\n');
                }
            }

            if (!(mapFile1.containsKey(keyCommonMap))) {
                strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
              //  resultStr.append("  + ").append(keyCommonMap).append(": ").append(valueMap2).append('\n');
            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap1));
             //   resultStr.append("  - ").append(keyCommonMap).append(": ").append(valueMap1).append('\n');
            }
        }

        res = strings.stream()
                .collect(Collectors.joining(""));

        String result = String.format("{\n%s}", res);


      //  return resultStr.append("}");
        return result;
    }
}
