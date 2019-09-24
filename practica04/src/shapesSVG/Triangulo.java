package shapesSVG;
public class Triangulo {
  private Vector2 P;
  private Vector2 Q;
  private Vector2 R;
  //private double area;
  private double perimetro;

  public Triangulo(Vector2 p, Vector2 q, Vector2 r) {
    this.P=p;
    this.Q=q;
    this.R=r;
    this.perimetro=P.distancia(Q)+Q.distancia(R)+R.distancia(P);
  }
  public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3) {
    this.P= new Vector2(x1,y1);
    this.Q= new Vector2(x2,y2);
    this.R= new Vector2(x3,y3);
    this.perimetro= P.distancia(Q)+Q.distancia(R)+R.distancia(P);
  }
  /**
  *@param toString regresa los vértices de un triángulo cualquiera.
  */
  public Triangulo(){
    this.P= new Vector2(0.0, 0.0);
    this.Q= new Vector2(0.0, 0.0);
    this.R= new Vector2(0.0, 0.0);
    this.perimetro= 0.0;
  }
  public String toString() {
    return "Este es un triángulo con vértices "+this.P.toString()+", "+this.Q.toString()+", "+this.R.toString();
  }
  /**
  *@param toSVG convierte los datos de un Triangulo cualquiera al formato SVG.
  */
  public String toSVG() {
    return "<polygon points=\""+this.P.getX()+", "+this.P.getY()+", "+this.Q.getX()+", "+this.Q.getY()+", "+this.R.getX()+", "+this.R.getY()+"\""+
    "stroke=\"green\" fill=\"transparent\" stroke-width=\"5\"/>";
  }
  /**
  *@param equals compara los atributos de dos objetos de la clase Triangulo. Regresa true si todos son iguales, false en caso contrario.
  */
  public boolean equals(Triangulo otro) {
    if ((this.P.equals(otro.P))&&(this.Q.equals(otro.Q))&&this.R.equals(otro.R)) {
      return true;
    }
    return false;
  }
}
