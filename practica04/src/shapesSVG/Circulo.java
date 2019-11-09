package shapesSVG;
public class Circulo extends Shape{
  private Vector2 C;
  private double radio;

  public Circulo(Vector2 c, double r) {
    this.C=c;
    this.radio=r;
    this.perimetro= 3.1415926535*r;
    this.area= 3.1415926535*Math.pow(r, 2);
  }
  public Circulo(double x, double y, double r) {
    this.C=new Vector2(x, y);
    this.radio=r;
    this.perimetro= 3.1415926535*r;
    this.area= 3.1415926535*Math.pow(r, 2);
  }
  public Circulo() {
    this.C=new Vector2(0.0, 0.0);
    this.radio=0.0;
    this.perimetro= 0.0;
    this.area= 0.0;
  }
  /**
  *@param getRadio regresa el valor del radio de un objeto de la clsa circulo.
  */
  public double getRadio(){
    return this.radio;
  }
  /**
  *@param toString regresa un String que contiene los valores del centro y radio de un círculo cualquiera.
  */
  public String toString() {
    return "Este es un círculo con centro "+this.C.toString()+" y radio "+radio;
  }
  /**
  *@param toSVG convierte los datos de un circulo cualquiera al formato SVG.
  */
  public String toSVG() {
    return "<circle cx=\""+this.C.getX()+"\" cy=\""+this.C.getY()+"\" r=\""+this.getRadio()+"\""+
    " stroke=\"black\" stroke-width=\"3\" fill=\"transparent\" />"+"\n"+
    "</svg>";
  }
  /**
  *@param equals compara los atributos de dos objetos de la clase Circulo. Regresa true si todos son iguales, false en caso contrario.
  */
  public boolean equals(Circulo otro) {
    if ((this.C.equals(otro.C))&&((this.radio)==(otro.getRadio()))) {
      return true;
    }
    return false;
  }
}
