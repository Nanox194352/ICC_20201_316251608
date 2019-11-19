package gui;

import java.util.LinkedList;
import java.util.List;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessGUI extends PApplet {
    Position selected = null;
    ColorEnum turn = ColorEnum.WHITE;

    int PIXEL_SIZE = 50;
    List<Position> legalMoves = new LinkedList<>();
    Board board = Board.getInstance();
    PImage black_rook;
    PImage white_rook;
    PImage black_queen;
    PImage white_queen;
    PImage black_knight;
    PImage white_knight;
    PImage black_bishop;
    PImage white_bishop;
    PImage black_pawn;
    PImage white_pawn;
    PImage black_king;
    PImage white_king;

    public static void main(String[] args) {
        PApplet.main("gui.ChessGUI");
    }

    @Override
    public void settings() {
        size(400, 440);
    }

    /**
    * Carga las imágenes de tipo png para representar a las piezas.
    */

    @Override
    public void setup() {
        // legalMoves = board.getPiece(new Position(4,4)).getLegalMoves();
        System.out.println(board.getPiece(new Position(4, 4)).getLegalMoves());
        black_rook = loadImage(getClass().getResource("/black-rook-50.png").getPath());
        white_rook = loadImage(getClass().getResource("/white-rook-50.png").getPath());
        black_queen = loadImage(getClass().getResource("/black-queen-50.png").getPath());
        white_queen = loadImage(getClass().getResource("/white-queen-50.png").getPath());
        black_knight = loadImage(getClass().getResource("/black-knight-50.png").getPath());
        white_knight = loadImage(getClass().getResource("/white-knight-50.png").getPath());
        black_bishop = loadImage(getClass().getResource("/black-bishop-50.png").getPath());
        white_bishop = loadImage(getClass().getResource("/white-bishop-50.png").getPath());
        black_pawn = loadImage(getClass().getResource("/black-pawn-50.png").getPath());
        white_pawn = loadImage(getClass().getResource("/white-pawn-50.png").getPath());
        black_king = loadImage(getClass().getResource("/black-king-50.png").getPath());
        white_king = loadImage(getClass().getResource("/white-king-50.png").getPath());
    }

    @Override
    public void draw() {
        drawBoard();
        drawPosibleMoves();
        writeTurn();
    }

    public void writeTurn() {
        fill(255, 255, 255);
        rect(0,400,400,40);
        textSize(20);
        fill(0, 0, 0);
        text(turn.toString().toLowerCase()+" moves", 30, 430);
    }

    /**
    * Dibuja los posibles movimientos que puede realizar una pieza seleccionada. Emplea el atributo legalMoves.
    */

    public void drawPosibleMoves() {
        stroke(255, 0, 0);
        fill(0, 0, 0, 100);
        for (Position g : legalMoves) {
            int x = g.getX();
            int y = g.getY();
            rect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
        stroke(0, 0, 0);
    }

    public void drawBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        fill(99,221, 99);
                    else
                        fill(255, 255, 255);
                } else {
                    if (j % 2 == 0)
                        fill(255, 255, 255);
                    else
                        fill(99,221, 99);
                }
                rect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
                Piece p = board.getPiece(new Position(i, j));
                drawPiece(p);
            }
        }
    }

    /**
    * Asigna una imagen de tipo png a cada pieza según su color y su tipo.
    */

    public void drawPiece(Piece p) {
        int x = p.getPosition().getX();
        int y = p.getPosition().getY();
        switch (p.getType()) {
        case ROOK:
            if (p.getColor().equals(ColorEnum.WHITE))
                image(white_rook, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.BLACK))
                image(black_rook, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
        case QUEEN:
          if (p.getColor().equals(ColorEnum.BLACK))
          image(black_queen, x * PIXEL_SIZE, y * PIXEL_SIZE);
          if (p.getColor().equals(ColorEnum.WHITE))
          image(white_queen, x * PIXEL_SIZE, y * PIXEL_SIZE);
          break;
          case KNIGHT:
            if (p.getColor().equals(ColorEnum.BLACK))
            image(black_knight, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.WHITE))
            image(white_knight, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
          case BISHOP:
            if (p.getColor().equals(ColorEnum.BLACK))
            image(black_bishop, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.WHITE))
            image(white_bishop, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
          case PAWN:
            if (p.getColor().equals(ColorEnum.BLACK))
            image(black_pawn, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.WHITE))
            image(white_pawn, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
          case KING:
            if (p.getColor().equals(ColorEnum.BLACK))
            image(black_king, x * PIXEL_SIZE, y * PIXEL_SIZE);
            if (p.getColor().equals(ColorEnum.WHITE))
            image(white_king, x * PIXEL_SIZE, y * PIXEL_SIZE);
            break;
          case EMPTY:
            break;
          default:
            break;
        }
    }

    @Override
    public void mouseClicked() {
        int x = mouseX / PIXEL_SIZE;
        int y = mouseY / PIXEL_SIZE;
        Position p = new Position(x, y);
        Piece piece = board.getPiece(p);
        if (!(this.legalMoves.contains(p))) {
          if (selected!=null) {
            Piece pieza = board.getPiece(selected);
            pieza.nullify();
          }
          this.legalMoves = new LinkedList<>();
        }

        if (piece.getColor()==turn) {
          this.legalMoves = piece.getLegalMoves();
          this.selected = new Position(x, y);
          return;
        }

        if (this.legalMoves.contains(p)) {
          Piece piece2 = board.getPiece(selected);
          this.board.move(selected, new Position(x, y));
          piece2.moveTo(p);
          if (turn==ColorEnum.WHITE) {
            turn=ColorEnum.BLACK;
            piece2.nullify();
          } else {
            turn=ColorEnum.WHITE;
            piece2.nullify();
          }
        }

        this.legalMoves = new LinkedList<>();
    }

}
