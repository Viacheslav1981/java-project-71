package hexlet.code;

import hexlet.code.NodeStatus;

import java.util.*;

public class Format {

    private static NodeStatus nodeStatus;

    private static List<Map<NodeStatus, Object>> differList;

    public static List<NodeName> getDifferList(Map<String, Object> mapFile1,
                                       Map<String, Object> mapFile2) {

        List<NodeName> differList = new LinkedList<>();


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
                    //   strings.add(String.format("    %s: %s\n", keyCommonMap, valueMap1));


                } else {

                    nodeName.setKey(keyCommonMap);
                    nodeName.setValue(valueMap1);
                    nodeName.setUpdatedValue(valueMap2);
                    nodeName.setType(NodeStatus.UPDATED);
                    differList.add(nodeName);

                    // differMap.put(NodeStatus.REMOVED, keyCommonMap);
                    // differMap.put(NodeStatus.ADDED, keyCommonMap);
                    //    strings.add(String.format("  - %s: %s\n", keyCommonMap, valueMap1));
                    //     strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
                }
            }

            if (!(mapFile1.containsKey(keyCommonMap))) {
                nodeName.setKey(keyCommonMap);
                nodeName.setValue(valueMap2);
                nodeName.setType(NodeStatus.ADDED);
                differList.add(nodeName);

                //    strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                nodeName.setKey(keyCommonMap);
                nodeName.setValue(valueMap1);
                nodeName.setType(NodeStatus.REMOVED);
                differList.add(nodeName);
                //     strings.add(String.format("  - %s: %s\n", keyCommonMap, valueMap1));
            }
        }

        for (NodeName elem : differList) {
            System.out.println(elem.getType() + " " + elem.getKey()
            + " " + elem.getValue() + " " + elem.getUpdatedValue() );
        }

        return differList;
    }

    public static Map<NodeStatus, Object> getDiffer(Map<String, Object> mapFile1,
                                                Map<String, Object> mapFile2) {

        Map<NodeStatus, Object> differMap = new HashMap<>();


        TreeMap<String, Object> commonMap = new TreeMap<>();
        commonMap.putAll(mapFile1);
        commonMap.putAll(mapFile2);

        for (Map.Entry<String, Object> entryCheck : commonMap.entrySet()) {
            String keyCommonMap = entryCheck.getKey();
            Object valueMap1 = mapFile1.get(keyCommonMap);
            Object valueMap2 = mapFile2.get(keyCommonMap);

            if (mapFile1.containsKey(keyCommonMap) && (mapFile2.containsKey(keyCommonMap))) {
                if (Objects.equals(valueMap1, valueMap2)) {
                    differMap.put(NodeStatus.UNCHANGED, keyCommonMap);
                 //   strings.add(String.format("    %s: %s\n", keyCommonMap, valueMap1));


                } else {
                    differMap.put(NodeStatus.UPDATED, keyCommonMap);
                    // differMap.put(NodeStatus.REMOVED, keyCommonMap);
                    // differMap.put(NodeStatus.ADDED, keyCommonMap);
                //    strings.add(String.format("  - %s: %s\n", keyCommonMap, valueMap1));
               //     strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
                }
            }

            if (!(mapFile1.containsKey(keyCommonMap))) {
                differMap.put(NodeStatus.ADDED, keyCommonMap);

            //    strings.add(String.format("  + %s: %s\n", keyCommonMap, valueMap2));
            }
            if (!(mapFile2.containsKey(keyCommonMap))) {
                differMap.put(NodeStatus.REMOVED, keyCommonMap);
           //     strings.add(String.format("  - %s: %s\n", keyCommonMap, valueMap1));
            }
        }

      //  String res = String.join("", strings);

        return differMap;

    }

}
