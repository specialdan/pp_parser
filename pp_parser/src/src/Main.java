package src.pp_parser;

import src.pp_parser.*;

import java.io.IOException;

public class Main {

    public static void main(String... aArgs) throws IOException {
        Pp_parser parser = new Pp_parser("C:\\temp.txt");
        parser.processLineByLine();
        log("Done.");
    }

}