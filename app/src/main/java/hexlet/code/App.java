package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "auto help demo - picocli 3.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @CommandLine.Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
   private boolean versionInfoRequested;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
   private boolean usageHelpRequested;

    @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "stylish",  paramLabel = "format",
                      description = "output format [default: stylish]")
    private static String format;

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private static String file1;

    @CommandLine.Parameters(index = "1",  description = "path to second file")
    private static String file2;

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }

    public boolean isVersionInfoRequested() {
        return versionInfoRequested;
    }

    public void setVersionInfoRequested(boolean versionInfoRequested) {
        this.versionInfoRequested = versionInfoRequested;
    }

    public boolean isUsageHelpRequested() {
        return usageHelpRequested;
    }

    public void setUsageHelpRequested(boolean usageHelpRequested) {
        this.usageHelpRequested = usageHelpRequested;
    }

    public static String getFormat() {
        return format;
    }

    public static void setFormat(String format) {
        App.format = format;
    }

    public static String getFile1() {
        return file1;
    }

    public static void setFile1(String file1) {
        App.file1 = file1;
    }

    public static String getFile2() {
        return file2;
    }

    public static void setFile2(String file2) {
        App.file2 = file2;
    }

   // @Override
    public final Integer call() throws Exception {


        // Path filepath1 = Paths.get(file1).toAbsolutePath().normalize();
        //  Path filepath2 = Paths.get(file2).toAbsolutePath().normalize();

      //  file1 = "src/test/resources/file1.yml";
      //  file2 = "src/test/resources/file2.yml";

       // file1 = "src/test/resources/file1.json";
       // file2 = "src/test/resources/file2.json";

       // file1 = "src/test/resources/fileDiff1.yml";
       // file2 = "src/test/resources/fileDiff2.yml";

    //    file1 = "src/test/resources/fileJsonNested1.json";
     //   file2 = "src/test/resources/fileJsonNested2.json";

     //   file1 = "src/test/resources/fileJsonTest1.json";
     //   file2 = "src/test/resources/fileJsonTest2.json";

       // Path filepath1 = Paths.get(file1).toAbsolutePath().normalize();
       // Path filepath2 = Paths.get(file2).toAbsolutePath().normalize();

        System.out.println(Differ.generate(file1, file2, format));
        return 0;
    }
}
