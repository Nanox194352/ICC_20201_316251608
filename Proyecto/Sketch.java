import processing.core.PApplet;
public class Sketch extends PApplet{

  public static void main(String[] args) {
    PApplet.main("Sketch");
  }

  public void settings(){
    size(400, 400);
  }

  public void setup(){
    fill(120,50,240);
  }

  public void draw(){
    int[][] tablero = new int[8][8];
    for (int i=0; i<8; i++) {
      int x=50;
      for (int ii=0; ii<4; ii++) {
        if ((i%2)==0) {
          x =100;
        }
        rect(ii*x, i*x, 50, 50);
      }
    }
  }
}
