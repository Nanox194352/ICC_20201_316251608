package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

public class Queen extends Piece {

  /**
  * Constructor de la clase Queen que representa a la reina en el juego de ajedrez.
  * @param p posición de la pieza.
  * @param color Color de la pieza.
  */

  public Queen(Position p, ColorEnum c) {
    super(p, c);
    this.type = PiecesTypeEnum.QUEEN;
  }

  public List<Position> getLegalMoves() {
      Board board = Board.getInstance();
      if (this.legalMoves == null) {
          this.legalMoves = new LinkedList<Position>();
          for(int i = this.position.getX()+1;i < 8; i++){
              Position nextLegalPosition = new Position(i, this.position.getY());
              Piece piece = board.getPiece(nextLegalPosition);
              if(piece.getColor() == this.getColor())break;
              if(piece.getColor() != ColorEnum.NONE){
                  this.legalMoves.add(nextLegalPosition);
                  break;
              }
              this.legalMoves.add(nextLegalPosition);

          }

          for(int i = this.position.getX()-1;i >= 0; i--){
              Position nextLegalPosition = new Position(i, this.position.getY());
              Piece piece = board.getPiece(nextLegalPosition);
              if(piece.getColor() == this.getColor())break;
              if(piece.getColor() != ColorEnum.NONE){
                  this.legalMoves.add(nextLegalPosition);
                  break;
              }
              this.legalMoves.add(nextLegalPosition);

          }

          for(int i = this.position.getY()+1;i < 8; i++){
              Position nextLegalPosition = new Position(this.position.getX(),i);
              Piece piece = board.getPiece(nextLegalPosition);
              if(piece.getColor() == this.getColor())break;
              if(piece.getColor() != ColorEnum.NONE){
                  this.legalMoves.add(nextLegalPosition);
                  break;
              }
              this.legalMoves.add(nextLegalPosition);

          }

          for(int i = this.position.getY()-1;i >= 0; i--){
              Position nextLegalPosition = new Position(this.position.getX(),i);
              Piece piece = board.getPiece(nextLegalPosition);
              if(piece.getColor() == this.getColor())break;
              if(piece.getColor() != ColorEnum.NONE){
                  this.legalMoves.add(nextLegalPosition);
                  break;
              }
              this.legalMoves.add(nextLegalPosition);

          }

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
          if (!(obj instanceof Queen))
              return false;

          Queen t = (Queen) obj;
          return (t.getColor() == this.getColor()
                  && this.getPosition().equals(t.getPosition())) ? true : false;

      }
}
