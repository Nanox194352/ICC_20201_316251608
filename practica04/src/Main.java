import shapesSVG.*;
public class Main {
  public static void main(String[] args) {
    Vector2 P = new Vector2(100.0, 300.0);
    Vector2 Q = new Vector2(400.0, 70.0);
    Vector2 S = new Vector2(1000.0, 1200.0);
    Vector2 T = new Vector2(400.0, 700.0);
    Linea lin = new Linea(1700.0, 1.0, 1700, 1800);
    System.out.println(S.toSVG());
    System.out.println(lin.toSVG());
    Rectangulo rect = new Rectangulo(450.0, 260.0, 400.0, 300.0);
    System.out.println(rect.toSVG());
    Vector2 R = new Vector2(40.0, 80.0);
    Triangulo tri = new Triangulo(P, Q, R);
    System.out.println(tri.toSVG());
    Circulo circ = new Circulo(T, 200.0);
    System.out.println(circ.toSVG());
  }
}
