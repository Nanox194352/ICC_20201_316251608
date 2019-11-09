import processing.core.PApplet;
public class Sketch extends PApplet{

  public static void main(String[] args) {
    PApplet.main("Sketch");
  }

  public void settings(){
    size(400, 400);
  }

  public void setup(){
  }

  public void draw(){
    int[][] tablero = new int[8][8];
    for (int i=0; i<8; i++) {
      for (int ii=0; ii<8; ii++) {
        if ((ii%2)!=(i%2)) {
          fill(000000);
        } else {
          fill(255, 255, 255);
        }
        rect(ii*50, i*50, 50, 50);
      }
    }
  }
}
