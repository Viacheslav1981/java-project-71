package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DifferTests {
    private final String fixtures = "src/test/resources/";
    private final String filePath1 = fixtures + "fileJsonNested1.json";
    private final String filePath2 = fixtures + "fileJsonNested2.json";

    @Test
    public void testExtension() {
        String expected1 = filePath1.substring(filePath1.indexOf(".") + 1);
        String expected2 = filePath2.substring(filePath2.indexOf(".") + 1);

        boolean isCorrectExtension = false;

        if ((expected1.equals("json") && expected2.equals("json"))
                || (expected1.equals("yml") && expected2.equals("yml"))) {
            isCorrectExtension = true;
        }

        assertTrue(isCorrectExtension);

    }

    @Test
    public void testFilesExist() {
        boolean isFile1 = Files.exists(Path.of(filePath1));
        boolean isFile2 = Files.exists(Path.of(filePath2));
        assertTrue(isFile1);
        assertTrue(isFile2);
    }

    @Test
    public void generateTest() throws Exception {
        String actual = Differ.generate(filePath1, filePath2);
        String fileResult = fixtures + "fileResultStylish.txt";
        String result = Files.lines(Paths.get(fileResult)).reduce("", (a, b) -> a + b + "\n").trim();
        assertEquals(result, actual);

    }

    @Test
    public void testStylish() throws Exception {
        String actualStylish = Differ.generate(filePath1, filePath2, "stylish");
        String fileResultStylish = fixtures + "fileResultStylish.txt";
        String resultStylish = Files.lines(Paths.get(fileResultStylish)).reduce("", (a, b) -> a + b + "\n").trim();
        assertEquals(resultStylish, actualStylish);

    }

    @Test
    public void testPlain() throws Exception {
        String fileResultPlain = fixtures + "fileResultPlain.txt";
        String resultPlain = Files.lines(Paths.get(fileResultPlain)).reduce("", (a, b) -> a + b + "\n").trim();
        String actualPlain = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(resultPlain, actualPlain);
    }

    @Test
    public void testJson() throws Exception {
        String fileResultJson = fixtures + "fileResultJson.json";
        String resultJson = Files.lines(Paths.get(fileResultJson)).reduce("", (a, b) -> a + b).replaceAll("\n", "");
        String actualJson = Differ.generate(filePath1, filePath2, "json").replaceAll("\n", "");
        assertEquals(resultJson, actualJson);
    }

}

