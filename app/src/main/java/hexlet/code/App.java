package hexlet.code;

import picocli.CommandLine;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "auto help demo - picocli 3.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @CommandLine.Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    boolean versionInfoRequested;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "stylish",  paramLabel = "format",
                      description = "output format [default: stylish]")
    public static String format;

    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    public static String file1;

    @CommandLine.Parameters(index = "1", paramLabel = "filepath2",  description = "path to second file")
    public static String file2;

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    @Override
    public Integer call() throws Exception {


        // Path filepath1 = Paths.get(file1).toAbsolutePath().normalize();
        //  Path filepath2 = Paths.get(file2).toAbsolutePath().normalize();

        file1 = "src/test/resources/file1.yml";
        file2 = "src/test/resources/file2.yml";

       // file1 = "src/test/resources/file1.json";
       // file2 = "src/test/resources/file2.json";

       // file1 = "src/test/resources/fileDiff1.yml";
       // file2 = "src/test/resources/fileDiff2.yml";

       // file1 = "src/test/resources/fileJsonNested1.json";
       // file2 = "src/test/resources/fileJsonNested2.json";

       // Path filepath1 = Paths.get(file1).toAbsolutePath().normalize();
       // Path filepath2 = Paths.get(file2).toAbsolutePath().normalize();

        System.out.println(Differ.generate(file1, file2, format));

        return 0;
    }
}
