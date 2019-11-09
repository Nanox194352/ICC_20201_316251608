package chess.pieces;
import chess.items.*;
public class Piece {
  private Position position;
  private ColorEnum color;
  private LinkedList<Position> legalMoves;

  public LinkedList<Position> getLegalMoves() {
    if(legalMoves==null) {
      this.legalMoves= new LinkedList<>();
      Position n = new Position(this.position.getX(), this.position.getY());
    }
  }
  public boolean isLegalMove(Position p) {
    return true;
  }

  public void moveTo(Position P) {
    if (this.isLegalMove(p)) {
      this.position = p;
      this.legalMoves = null;
      return;
    }
  }
}
