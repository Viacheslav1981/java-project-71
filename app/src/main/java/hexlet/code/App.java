package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "auto help demo - picocli 3.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer> {
    @CommandLine.Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    private boolean versionInfoRequested;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequested;

    @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: stylish]")
    private static String format;

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private static String filePath1;

    @CommandLine.Parameters(index = "1", description = "path to second file")
    private static String filePath2;

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    public Integer call() throws Exception {
       // filePath1 = "src/test/resources/fileJsonNested1.json";
       // filePath2 = "src/test/resources/fileJsonNested2.json";

        filePath1 = "src/test/resources/file1.json";
        filePath2 = "src/test/resources/file2.json";

        System.out.println(Differ.generate(filePath1, filePath2, format));
        return 0;
    }
}
