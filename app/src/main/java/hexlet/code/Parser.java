package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.NoSuchFileException;
import java.util.TreeMap;

public class Parser {

    public static TreeMap<String, ?> parseFile(String fileContent,
                                                    String extension)
            throws NoSuchFileException, JsonProcessingException {

        ObjectMapper objectMapper;
        TreeMap<String, Object> map;

        if (extension.equals("yml")) {
            objectMapper = new YAMLMapper();
            map = objectMapper.readValue(fileContent, new TypeReference<>() {
            });
        } else if (extension.equals("json")) {
            objectMapper = new ObjectMapper();
            map = objectMapper.readValue(fileContent, new TypeReference<>() {
            });
        } else {
            throw new NoSuchFileException("bad extension");
        }

        return map;
    }
}
