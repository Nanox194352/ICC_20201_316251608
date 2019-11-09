package shapesSVG;

public abstract class Shape implements Comparable <Shape>{
  protected double area;
  protected double perimetro;

  public double getArea() {
    return this.area;
  }

  public int compareTo(Shape s) {
    double k = this.getArea()-s.getArea();
    if (k>0) {
      return 1;
    } else if (k==0) {
      return 0;
    }
    return -1;
  }

  public abstract String toSVG();

}
