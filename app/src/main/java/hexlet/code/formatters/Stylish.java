package hexlet.code.formatters;

import hexlet.code.NodeName;

import java.util.ArrayList;
import java.util.List;

public class Stylish {

    public static String getStylish(List<NodeName> differList)
            throws IllegalArgumentException {
        List<String> strings = new ArrayList<>();

        for (NodeName node : differList) {
            switch (node.getType()) {
                case UNCHANGED -> strings.add(String.format("    %s: %s\n", node.getKey(), node.getValue()));
                case UPDATED -> {
                    strings.add(String.format("  - %s: %s\n", node.getKey(), node.getValue()));
                    strings.add(String.format("  + %s: %s\n", node.getKey(), node.getUpdatedValue()));
                }
                case ADDED -> strings.add(String.format("  + %s: %s\n", node.getKey(), node.getValue()));
                case REMOVED -> strings.add(String.format("  - %s: %s\n", node.getKey(), node.getValue()));
                default -> throw new IllegalArgumentException(
                        String.format("Unsupported status. Supported: %s, %s, %s, %s",
                                "UNCHANGED", "UPDATED", "ADDED", "REMOVED"));

            }

        }
        String res = String.join("", strings);
        return String.format("{\n%s}", res);
    }

}
