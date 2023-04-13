package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.TreeMap;

public class Parser {

    public static TreeMap<String, Object> parseFile(String fileContent) throws JsonProcessingException {

        ObjectMapper objectMapper = new YAMLMapper();
        TreeMap<String, Object> map = objectMapper.readValue(fileContent, new TypeReference<>() {
        });

        return map;

    }

}
