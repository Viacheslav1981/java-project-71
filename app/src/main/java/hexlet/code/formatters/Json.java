package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.NodeName;

import java.io.IOException;
import java.util.List;

public class Json {
    public static String getJsonOut(List<NodeName> differList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(differList);

    }
}
