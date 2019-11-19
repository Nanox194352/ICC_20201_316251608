package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

public class King extends Piece {

  /**
  * Constructor de la clase King, que representa al rey en el juego de ajedrez.
  * @param p posición de la pieza.
  * @param color Color de la pieza.
  */

  public King(Position p, ColorEnum c){
    super(p,c);
    this.type=PiecesTypeEnum.KING;
  }



  public List<Position> getLegalMoves(){
    if (this.legalMoves==null) {
      this.legalMoves= new LinkedList<Position>();
      Board board = Board.getInstance();
      if ((this.position.getX()<8)&&(this.position.getX()>0)) {
        Position nextLegalPosition = new Position(this.position.getX()-1, this.position.getY());
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor()!=this.getColor()) {
          this.legalMoves.add(nextLegalPosition);
        }
        if ((this.position.getY()>=0)&&(this.position.getY()<7)) {
          nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()+1);
          piece = board.getPiece(nextLegalPosition);
          if (piece.getColor()!=this.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
        if ((this.position.getY()<8)&&(this.position.getY()>0)) {
          nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()-1);
          piece = board.getPiece(nextLegalPosition);
          if (piece.getColor()!=this.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
      }
      if ((this.position.getX()>=0)&&(this.position.getX()<7)) {
        Position nextLegalPosition = new Position(this.position.getX()+1, this.position.getY());
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor()!=this.getColor()) {
          this.legalMoves.add(nextLegalPosition);
        }
        if ((this.position.getY()>=0)&&(this.position.getY()<7)) {
          nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()+1);
          piece = board.getPiece(nextLegalPosition);
          if (piece.getColor()!=this.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
        if ((this.position.getY()<8)&&(this.position.getY()>0)) {
          nextLegalPosition = new Position(this.position.getX()+1, this.position.getY()-1);
          piece = board.getPiece(nextLegalPosition);
          if (piece.getColor()!=this.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
        if ((this.position.getY()<8)&&(this.position.getY()>0)) {
          nextLegalPosition = new Position(this.position.getX()-1, this.position.getY()-1);
          piece = board.getPiece(nextLegalPosition);
          if (piece.getColor()!=this.getColor()) {
            this.legalMoves.add(nextLegalPosition);
          }
        }
      }
      if (this.position.getY()<7) {
        Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()+1);
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor()!=this.getColor()) {
          this.legalMoves.add(nextLegalPosition);
        }
      }
      if (this.position.getY()>0) {
        Position nextLegalPosition = new Position(this.position.getX(), this.position.getY()-1);
        Piece piece = board.getPiece(nextLegalPosition);
        if (piece.getColor()!=this.getColor()) {
          this.legalMoves.add(nextLegalPosition);
        }
      }
    }
    return this.legalMoves;
  }
  @Override
  public boolean equals(Object obj) {
      if (!(obj instanceof King))
          return false;

      King t = (King) obj;
      return (t.getColor() == this.getColor()
              && this.getPosition().equals(t.getPosition())) ? true : false;

  }
}
