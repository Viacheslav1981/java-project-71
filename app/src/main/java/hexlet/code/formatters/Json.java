package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Json {
    public static StringBuilder getJsonOut(Map mapFile1, Map mapFile2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder resultStr =
                new StringBuilder(objectMapper.writeValueAsString(Stylish.getStylish(mapFile1, mapFile2)));

        return resultStr;
    }
}
