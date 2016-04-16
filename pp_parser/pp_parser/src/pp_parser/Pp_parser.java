package pp_parser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import pp_parser.PPDocument;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Pp_parser {

  public static void main(String... aArgs) throws IOException {
    Pp_parser parser = new Pp_parser("C:\\temp.txt");
    parser.processLineByLine();
    log("Done.");
  }
  
  /**
   Constructor.
   @param aFileName full name of an existing, readable file.
  */
  public Pp_parser(String aFileName){
    fFilePath = Paths.get(aFileName);
  }
  
  
  /** Template method that calls {@link #processLine(String)}.  */
  public final void processLineByLine() throws IOException {
      String nextline="";
      String[] documentParams= new String[100];
      PPDocument ppdoc = new PPDocument();
      int param = 0;
      try (Scanner scanner =  new Scanner(fFilePath, "Cp1251")){
      while (scanner.hasNextLine()){
          nextline = scanner.nextLine();
          processLine(nextline);
          if (docStart(nextline)) {
                  while (scanner.hasNextLine() && docnotEnd(nextline)){
                      documentParams[param] = nextline;
                      nextline = scanner.nextLine();
                      processLine(nextline);
                      param++;
                      documentParams[param] = nextline;
          }
                  param=0;
                  ppdoc.fillppdoc(documentParams);
                  
          }
          
}
        
      }      

    }
  
  /*
   Overridable method for processing lines in different ways.
  
   <P>This simple default implementation expects simple name-value pairs, separated by an 
   '=' sign. Examples of valid input: 
   <tt>height = 167cm</tt>
   <tt>mass =  65kg</tt>
   <tt>disposition =  "grumpy"</tt>
   <tt>this is the name = this is the value</tt>
  */
  
  protected boolean docStart(String aLine){
  if(aLine.contains("СекцияДокумент")){
      return true;
    }
  return false;
  }

 protected boolean docnotEnd(String aLine){
  if(aLine.contains("КонецДокумента")){
      return false;
    }
  return true;
  }

protected void processLine(String aLine){
    //use a second Scanner to parse the content of each line 
    
    log(aLine);
    log("");
//    Scanner scanner = new Scanner(aLine);
//    scanner.useDelimiter("=");
//    if (scanner.hasNext()){
//      //assumes the line has a certain structure
//      String name = scanner.next();
//      String value = scanner.next();
//      log("Name is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
//    }
//    else {
//      log("Empty or invalid line. Unable to process.");
//    }
  }
  
  // PRIVATE 
  private final Path fFilePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }
  
  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
} 