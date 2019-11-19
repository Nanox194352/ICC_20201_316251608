import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Paths;

public class Writter {
  public static void main(String[] args) {
    try{
      List<String> lines = Files.readAllLines(Paths.get("hola.txt"));
      for (String string : lines) {
        String row[] = string.split(",");
        System.out.println("x: "+row[0]+"y: "+row[1]);
      }
    } catch(IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
