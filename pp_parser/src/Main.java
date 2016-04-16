
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String... aArgs) throws IOException {
        Pp_parser parser = new Pp_parser("C:\\temp.txt");
        parser.processLineByLine();
        log("Done.");
    }

}