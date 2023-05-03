package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTests {

    @Test
    public void generateTest() throws Exception {
        // filePath1 = "src/test/resources/fileJsonNested1.json";
        // filePath2 = "src/test/resources/fileJsonNested2.json";

        //  filePath1 = "src/test/resources/file1.json";
        //   filePath2 = "src/test/resources/file2.json";

        // String file1 = "src/test/resources/fileJsonNested1.json";
        //  String file2 = "src/test/resources/fileJsonNested2.json";

        //  Path filePath1 = Paths.get("src/test/resources/fileJsonNested1.json").toAbsolutePath().normalize();
        //  Path filePath2 = Paths.get("src/test/resources/fileJsonNested2.json").toAbsolutePath().normalize();

        //  String filePath1 = "src/test/resources/file1.json";
        String filePath1 = "src/test/resources/fileJsonNested1.json";
        //  String filePath2 = "src/test/resources/file2.json";
        String filePath2 = "src/test/resources/fileJsonNested2.json";



        System.out.println(Differ.getExtension(filePath1));

        //  String actual = String.valueOf(Differ.generate(filePath1, filePath2).replaceAll("\n", ""));
        String actual = Differ.generate(filePath1, filePath2);
        String fileResult = "src/test/resources/fileResultStylish.txt";
        String result = Files.lines(Paths.get(fileResult)).reduce("", (a, b) -> a + b + "\n").trim();
        assertEquals(result, actual);

        // String actualStylish = String.valueOf(Differ.generate(filePath1, filePath2, "stylish").replaceAll("\n", ""));
        String actualStylish = Differ.generate(filePath1, filePath2, "stylish");
        String fileResultStylish = "src/test/resources/fileResultStylish.txt";
        String resultStylish = Files.lines(Paths.get(fileResultStylish)).reduce("", (a, b) -> a + b + "\n").trim();
        assertEquals(resultStylish, actualStylish);

        // String actualDefault = String.valueOf(Differ.generate(filePath1, filePath2, "default").replaceAll("\n", ""));
        // String actualDefault = Differ.generate(filePath1, filePath2, "default");
        //  String fileResultDefault = "src/test/resources/fileResultStylish.txt";
        //  String resultDefault = Files.lines(Paths.get(fileResultDefault)).reduce("", (a, b) -> a + b + "\n").trim();
        //  assertEquals(resultDefault, actualDefault);

        String fileResultPlain = "src/test/resources/fileResultPlain.txt";
        String resultPlain = Files.lines(Paths.get(fileResultPlain)).reduce("", (a, b) -> a + b + "\n").trim();
        //  String actualPlain = String.valueOf(Differ.generate(filePath1, filePath2, "plain").replaceAll("\n", ""));
        String actualPlain = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(resultPlain, actualPlain);

        String fileResultJson = "src/test/resources/fileResultJson.json";
        String resultJson = Files.lines(Paths.get(fileResultJson)).reduce("", (a, b) -> a + b).replaceAll("\n", "");
        //  StringBuilder resultJson = new StringBuilder(Files.lines(Paths.get(fileResultJson)).
        //  reduce("", (a, b) -> a + b));
        String actualJson = Differ.generate(filePath1, filePath2, "json").replaceAll("\n", "");
        //  StringBuilder actualJson = Differ.generate(filePath1, filePath2, "json");

        assertEquals(resultJson, actualJson);
    }

}

