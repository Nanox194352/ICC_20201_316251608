package shapesSVG;
public class Rectangulo extends Shape{
  private Vector2 P;
  private double alto;
  private double ancho;
  public Rectangulo(Vector2 p, double h, double l) {
    this.P=p;
    this.alto=h;
    this.ancho=l;
    this.area=h*l;
    this.perimetro=2*h*l;
  }
  public Rectangulo(double x, double y, double h, double l) {
    this.P=new Vector2(x, y);
    this.alto=h;
    this.ancho=l;
    this.area=h*l;
    this.perimetro=2*h*l;
  }
  public Rectangulo() {
    this.P=new Vector2(0.0, 0.0);
    this.alto=0.0;
    this.ancho=0.0;
    this.area=0.0;
    this.perimetro=0.0;
  }
  public double getAncho(){
    return this.ancho;
  }
  public double getAlto(){
    return this.alto;
  }
  /**
  *@param toString regresa un String que describe el rectángulo en terminos de su altura, anchura y vertice inicial.
  */
  public String toString() {
    return "Este Rectangulo tiene un ancho de "+this.ancho+" y "+this.alto+" de alto. con un vértice inicial: "+this.P.toString();
  }
  /**
  *@param equals compara los atributos de dos objetos de la clase rectángulo. Regresa true si todos son iguales, false en caso contrario.
  */
  public boolean equals(Rectangulo otro) {
    if (this.P.equals(otro.P)) {
      if (this.ancho==otro.ancho) {
        if (this.alto==otro.alto) {
          return true;
        }
      }
    }
    return false;
  }
  /**
  *@param toSVG convierte los datos de un rectángulo cualquiera al formato SVG.
  */
  public String toSVG(){
    return "<rect x=\""+this.P.getX()+"\" y=\""+this.P.getY()+"\" width=\""+this.getAncho()+"\" height=\""+this.getAlto()+"\"/> \n"+
    "<stroke=\"black\" fill=\"transparent\" stroke-width=\"1\"/>";
  }
}
