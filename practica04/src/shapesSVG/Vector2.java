/**
*@author Juan Carlos Zenteno Pompa
* Esta es la clase Vector 2, que modela un punto y lo represnta en formato SVG.
* Forma parte del paquete toSVG que hace lo mismo con algunas figuras geométricas básicas.
*/
package shapesSVG;
public class Vector2 {
  private double x;
  private double y;
  private double magnitud;

  public Vector2 (double x1, double y1) {
    this.x=x1;
    this.y=y1;
    this.magnitud=10;
  }
  public Vector2 () {
    this.x=0.0;
    this.y=0.0;
    this.magnitud=0.0;
  }
  /**
  *@param getX regresa el valor en X para el punto P al que se le aplique este método
  */
  public double getX() {
    return this.x;
  }
  /**
  *@param getY regresa el valor en Y para el punto P al que se le aplique este método
  */
  public double getY() {
    return this.y;
  }
  /**
  *@param getMagnitud regresa el valor de la magnitud para el punto P al que se le aplique este método. Ésta magnitud representa el tamaño con el que se va a representar el punto.
  */
  public double getMagnitud(){
    return this.magnitud;
  }
  /**
  *@param setMagnitud permite cambiar el valor de la variable magnitud. Así se puede alterar el tamaño con el que se representará el punto.
  */
  public void setMagnitud(double F){
    this.magnitud= F;
  }
  /**
  *@param distancia regresa la distancia entre dos puntos cualquiera P y Q.
  */
  public double distancia(Vector2 otro) {
    double dist = Math.sqrt((Math.pow((this.getX()-otro.getX()), 2))+(Math.pow((this.getY()-otro.getY()), 2)));
    return dist;
  }
  /**
  *@param toSVG convierte los datos de un punto P al formato SVG.
  */
  public String toSVG() {
    return "<svg width=\"5000\" height=\"5000\">"+"\n"+
    "<circle cx=\""+this.getX()+"\" cy=\""+this.getY()+"\" r=\""+this.getMagnitud()+"\""+
    " stroke=\"black\" stroke-width=\"1\" fill=\"black\" />";
  }
  /**
  *@param toString convierte un punto p al formato (a,b) donde a y b representan a la ordenada y a la abcisa.
  */
  public String toString() {
    String aux = "("+this.getX()+", "+this.getY()+")";
    return aux;
  }
  /**
  *@param equals compara los atributos de dos objetos de la clase punto. Regresa true si son iguales, false en caso contrario.
  */
  public boolean equals(Vector2 otro) {
    boolean equal = ((this.getX()==otro.getX())&&(this.getY()==otro.getY()));
    return equal;
  }
}
