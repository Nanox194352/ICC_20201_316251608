import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Paths;

public class Writter {
  public static void main(String[] args) {
    try {
            Path path = Paths.get("csv.txt"); //La ruta de donde está mi archivo
            List<String> lines = Files.readAllLines(path); //Leo todas las lineas en una lista
            Path polarpath = Paths.get("polar.txt"); //Este va a escribir los resultados en otro tx
            String polar = "";
            for (String string : lines) { //Itero sobre cada linea
                String row[] = string.split(",");
                double x = Double.parseDouble(row[0]);
                double y = Double.parseDouble(row[1]);

                double r = Math.sqrt((Math.pow(x, 2))+(Math.pow(y, 2))); //calcula el radio
                double ang = Math.atan(y/x);  //calcula el ángulo

                polar += "r= "+ r + " angulo= "+ang+"\n"; //arma el String que se va a escribir en polar.txt
            }
            Files.write(polarpath, polar.getBytes()); //Escribe los resultados en polar.txt
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
