package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {

    public static String formatter(List<NodeName> differList,
                                   String format) throws Exception {

        return switch (format.toLowerCase()) {
            case ("plain") -> Plain.getPlain(differList);
            case ("json") -> Json.getJsonOut(differList);
            case ("stylish") -> Stylish.getStylish(differList);
            default -> throw new IllegalArgumentException(
                    String.format("Unsupported format. Supported: %s, %s, %s", "stylish", "plain", "json")
            );
        };
    }

}
