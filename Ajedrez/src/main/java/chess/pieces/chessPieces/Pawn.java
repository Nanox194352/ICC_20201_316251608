package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

public class Pawn extends Piece{

  /**
  * Constructor de la clase Pawn que representa un peón en el juego de ajedrez.
  * @param p posición de la pieza.
  * @param color Color de la pieza.
  */

  public Pawn(Position p, ColorEnum color) {
    super(p, color);
    this.type=PiecesTypeEnum.PAWN;
  }

  public List<Position> getLegalMoves() {
    Board board = Board.getInstance();
    if (this.legalMoves==null) {
      this.legalMoves= new LinkedList<Position>();
      switch (this.color) {
        case BLACK:
          if (this.position.getY()<7) {
            Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()+1);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor()==ColorEnum.NONE) {
              this.legalMoves.add(nextLegalPosition);
            }
            if ((this.position.getY()==1)&&(piece.getColor()==ColorEnum.NONE)) {
              nextLegalPosition = new Position(this.position.getX(), this.position.getY()+2);
              piece = board.getPiece(nextLegalPosition);
              if (piece.getColor()==ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
              }
            }
            if (this.position.getX()>0) {
              Position leftPosition = new Position(this.position.getX()-1, this.position.getY()+1);
              piece = board.getPiece(leftPosition);
              if (piece.getColor()==ColorEnum.WHITE) {
                this.legalMoves.add(leftPosition);
              }
            }
            if (this.position.getX()<7){
              Position rigthPosition =new Position(this.position.getX()+1, this.position.getY()+1);
              piece = board.getPiece(rigthPosition);
              if (piece.getColor()==ColorEnum.WHITE) {
                this.legalMoves.add(rigthPosition);
              }
            }
          }
          break;
        case WHITE:
          if (this.position.getY()>0) {
            Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()-1);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor()==ColorEnum.NONE) {
              this.legalMoves.add(nextLegalPosition);
            }
            if ((this.position.getY()==6)&&(piece.getColor()==ColorEnum.NONE)) {
              nextLegalPosition = new Position(this.position.getX(), this.position.getY()-2);
              piece = board.getPiece(nextLegalPosition);
              if (piece.getColor()==ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
              }
            }
            if (this.position.getX()>0) {
              Position leftPosition = new Position(this.position.getX()-1, this.position.getY()-1);
              piece = board.getPiece(leftPosition);
              if (piece.getColor()==ColorEnum.BLACK) {
                this.legalMoves.add(leftPosition);
              }
            }
            if (this.position.getX()<7){
              Position rigthPosition =new Position(this.position.getX()+1, this.position.getY()-1);
              piece = board.getPiece(rigthPosition);
              if (piece.getColor()==ColorEnum.BLACK) {
                this.legalMoves.add(rigthPosition);
              }
            }
          }
          break;
        default:
          break;
      }
    }
    return this.legalMoves;
  }

  @Override
  public boolean equals(Object obj) {
      if (!(obj instanceof Pawn))
          return false;

      Pawn t = (Pawn) obj;
      return (t.getColor() == this.getColor()
              && this.getPosition().equals(t.getPosition())) ? true : false;

  }
}
