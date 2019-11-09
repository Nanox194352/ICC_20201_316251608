package chess.items;
public class Position {
  private int x;
  private int y;

  public Position(int h, int k) {
    this.x=h;
    this.y=k;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}
