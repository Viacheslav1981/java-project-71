package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Json {
    public static String getJsonOut(Map<String, Object> mapFile1, Map<String, Object> mapFile2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String resultStr = objectMapper.writeValueAsString(Stylish.getStylish(mapFile1, mapFile2));
       // StringBuilder resultStr =
             //   new StringBuilder(objectMapper.writeValueAsString(Stylish.getStylish(mapFile1, mapFile2)));

        return resultStr;
    }
}
