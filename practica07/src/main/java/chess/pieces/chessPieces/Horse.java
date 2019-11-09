package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

public class Horse extends Piece {

  public Horse(Position p, ColorEnum c) {
    super(p, c);
    this.type=PiecesTypeEnum.HORSE;
  }

  public List<Position> getLegalMoves() {
    if (this.legalMoves==null) {
      
    }
  }
  @Override
  public boolean equals(Object obj) {
      if (!(obj instanceof Queen))
          return false;

      Queen t = (Queen) obj;
      return (t.getColor() == this.getColor()
              && this.getPosition().equals(t.getPosition())) ? true : false;

  }
}
