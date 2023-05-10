package hexlet.code;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;

public class Represent {
    public static List<NodeName> getDifferList(Map<String, ?> mapFile1,
                                               Map<String, ?> mapFile2) {

        List<NodeName> differList = new ArrayList<>();
        Set<String> allKeys = new TreeSet<>();

        allKeys.addAll(mapFile1.keySet());
        allKeys.addAll(mapFile2.keySet());

        for (String key : allKeys) {
            Object valueMap1 = mapFile1.get(key);
            Object valueMap2 = mapFile2.get(key);

            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (Objects.equals(valueMap1, valueMap2)) {
                    differList.add(new NodeName(NodeStatus.UNCHANGED, key, valueMap1, valueMap2));
                } else {
                    differList.add(new NodeName(NodeStatus.UPDATED, key, valueMap1, valueMap2));
                }
            } else {
                if (!(mapFile1.containsKey(key))) {
                    differList.add(new NodeName(NodeStatus.ADDED, key, valueMap2, null));
                } else {
                    differList.add(new NodeName(NodeStatus.REMOVED, key, valueMap1, null));
                }
            }
          /*
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

           */
        }
        return differList;
    }
}
