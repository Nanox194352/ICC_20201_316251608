package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

public class Bishop extends Piece{

  /**
  * Constructor de la clase Bishop que representa una torre en el juego de ajedrez.
  * @param p posición de la pieza.
  * @param color Color de la pieza.
  */

  public Bishop(Position p, ColorEnum color){
    super(p, color);
    this.type=PiecesTypeEnum.BISHOP;
  }

  public List<Position> getLegalMoves(){
    Board board = Board.getInstance();
    if (this.legalMoves==null){
      this.legalMoves = new LinkedList<Position>();
      for (int i=1; ((this.position.getX()+i)<8)&&((this.position.getY()+i)<8); i++) {
        Position nextLegalPosition = new Position(this.position.getX()+i, this.position.getY()+i);
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor() == this.getColor())break;
        if (piece.getColor() != ColorEnum.NONE){
          this.legalMoves.add(nextLegalPosition);
          break;
        }
        this.legalMoves.add(nextLegalPosition);
      }

      for (int i=1; ((this.position.getX()-i)>=0)&&((this.position.getY()+i)<8); i++) {
        Position nextLegalPosition = new Position(this.position.getX()-i, this.position.getY()+i);
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor() == this.getColor())break;
        if (piece.getColor() != ColorEnum.NONE){
          this.legalMoves.add(nextLegalPosition);
          break;
        }
        this.legalMoves.add(nextLegalPosition);
      }

      for (int i=1; ((this.position.getX()-i)>=0)&&((this.position.getY()-i)>=0); i++) {
        Position nextLegalPosition = new Position(this.position.getX()-i, this.position.getY()-i);
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor() == this.getColor())break;
        if (piece.getColor() != ColorEnum.NONE){
          this.legalMoves.add(nextLegalPosition);
          break;
        }
        this.legalMoves.add(nextLegalPosition);
      }

      for (int i=1; ((this.position.getX()+i)<8)&&((this.position.getY()-i)>=0); i++) {
        Position nextLegalPosition = new Position(this.position.getX()+i, this.position.getY()-i);
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor() == this.getColor())break;
        if (piece.getColor() != ColorEnum.NONE){
          this.legalMoves.add(nextLegalPosition);
          break;
        }
        this.legalMoves.add(nextLegalPosition);
      }
    }
      return this.legalMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bishop))
            return false;

        Bishop t = (Bishop) obj;
        return (t.getColor() == this.getColor()
                && this.getPosition().equals(t.getPosition())) ? true : false;

    }
}
