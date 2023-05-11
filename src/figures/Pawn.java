package figures;

import board.Board;
import board.Cell;

public class Pawn extends Figure{
    public Cell getCell() {
        return this.cell;
    }


    public Pawn(Cell cell, Side side){
        this.cell = cell;
        this.side = side;
    }

    private boolean canMove(Cell to){
//        if(this.side == Side.Black)
//            if(this.cell.getNumPosition() == to.getNumPosition() + 1 &&
//                    (this.cell.getLeterPosition() == to.getLeterPosition() ||
//                            this.)
    }

    public boolean move(Cell cell) {


    }
}
