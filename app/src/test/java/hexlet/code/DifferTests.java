package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTests {


    @Test
    public void generateTest() throws Exception {

        // String file1 = "src/test/resources/fileJsonNested1.json";
        //  String file2 = "src/test/resources/fileJsonNested2.json";

        //  Path filePath1 = Paths.get("src/test/resources/fileJsonNested1.json").toAbsolutePath().normalize();
        //  Path filePath2 = Paths.get("src/test/resources/fileJsonNested2.json").toAbsolutePath().normalize();

        String filePath1 = "src/test/resources/fileJsonNested1.json";
        String filePath2 = "src/test/resources/fileJsonNested2.json";

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
        String actualDefault = Differ.generate(filePath1, filePath2, "default");
        String fileResultDefault = "src/test/resources/fileResultStylish.txt";
        String resultDefault = Files.lines(Paths.get(fileResultDefault)).reduce("", (a, b) -> a + b + "\n").trim();
        assertEquals(resultDefault, actualDefault);

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


    /*
    @Test
    public void generateTest() throws Exception {

        String file1 = "src/test/resources/fileDiff1.yml";
        String file2 = "src/test/resources/fileDiff2.yml";
        Path filePath1 = Paths.get(file1);
        Path filePath2 = Paths.get(file2);

        DifferTests.testFormat(filePath1, filePath2);

        file1 = "src/test/resources/fileJsonNested1.json";
        file2 = "src/test/resources/fileJsonNested2.json";

        filePath1 = Paths.get(file1);
        filePath2 = Paths.get(file2);

        testFormat(filePath1, filePath2);

    }

    private static void testFormat(Path filePath1, Path filePath2) throws Exception {
        String actual = String.valueOf(Differ.generate(filePath1, filePath2, "stylish"));

        String fileResultStylish = "src/test/resources/fileResultStylish.txt";
        String resultStylish = Files.lines(Paths.get(fileResultStylish)).reduce("", (a, b) -> a + b + "\n");
        assertEquals(resultStylish, actual);

        actual = String.valueOf(Differ.generate(filePath1, filePath2, "default"));
        var path = Paths.get(fileResultStylish);
        String resultDefault = Files.lines(path).reduce("", (a, b) -> a + b + "\n");
        assertEquals(resultDefault, actual);

        String fileResultPlain = "src/test/resources/fileResultPlain.txt";
        String resultPlain = Files.lines(Paths.get(fileResultPlain)).reduce("", (a, b) -> a + b + "\n");
        actual = String.valueOf(Differ.generate(filePath1, filePath2, "plain"));

        assertEquals(resultPlain, actual);

        String fileResultJson = "src/test/resources/fileResultJson.json";
        String resultJson = Files.lines(Paths.get(fileResultJson)).reduce("", (a, b) -> a + b);
        actual = String.valueOf(Differ.generate(filePath1, filePath2, "json"));

        assertEquals(resultJson, actual);
    }

     */
}

