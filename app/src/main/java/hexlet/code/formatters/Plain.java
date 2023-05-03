package hexlet.code.formatters;

import hexlet.code.NodeName;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String getPlain(List<NodeName> differList)
            throws Exception {
        StringBuilder resultStr = new StringBuilder();

        for (NodeName node : differList) {
            Object valueMap1 = getValueFormat(node.getValue());
            Object valueMap2 = getValueFormat(node.getUpdatedValue());

            switch (node.getType()) {
                case UPDATED -> resultStr.append("Property ").append("'").append(node.getKey()).append("' ").
                        append("was updated. ").append("From ").append(valueMap1).
                        append(" to ").append(valueMap2).append('\n');
                case ADDED -> resultStr.append("Property ").append("'").append(node.getKey()).
                        append("'").append(" was added with value: ").append(valueMap1).append('\n');
                case REMOVED -> resultStr.append("Property ").append("'").
                        append(node.getKey()).append("'").append(" was removed").append('\n');
                case UNCHANGED -> resultStr.append("");
                default -> throw new Exception(
                        String.format("Unsupported status. Supported: %s, %s, %s",
                                "UPDATED", "ADDED", "REMOVED"));
            }

        }

        return resultStr.toString().trim();
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
