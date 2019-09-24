package shapesSVG;
public class Linea {
  private Vector2 P;
  private Vector2 Q;
  private double longitud;

  public Linea(Vector2 P1, Vector2 Q1) {
    this.P=P1;
    this.Q=Q1;
    this.longitud=P.distancia(Q);
  }
  public Linea(double x1, double y1, double x2, double y2) {
    this.P = new Vector2(x1, y1);
    this.Q = new Vector2(x2, y2);
    this.longitud= P.distancia(Q);
  }
  public Linea() {
    this.P= new Vector2(0.0, 0.0);
    this.Q= new Vector2(0.0, 0.0);
    this.longitud=0.0;
  }
  /**
  *@param toString convierte una linea cualquiera a una descripción a través desus extremos (a,b) y (c, d).
  */
  public String toString() {
  return "Esta línea tiene sus extremos en"+this.P.toString()+" y "+this.Q.toString();
  }
  /**
  *@param equals compara los atributos de dos objetos de la clase línea. Regresa true si todos son iguales, false en caso contrario.
  */
  public boolean equals(Linea otra) {
    if ((this.P.equals(otra.P)&&(this.Q.equals(otra.Q)))) {
      return true;
    } else if ((this.P.equals(otra.Q)&&(this.Q.equals(otra.P)))) {
      return true;
    } else {
      return false;
    }
  }
  /**
  *@param toSVG convierte los datos de una línea al formato SVG.
  */
  public String toSVG() {
    return "<line x1=\""+this.P.getX()+"\" y1=\""+this.P.getY()+"\" x2=\""+this.Q.getX()+"\" y2=\""+this.Q.getY()+"\" "+
    " stroke=\"black\" stroke-width=\"20\" />";
  }
}
