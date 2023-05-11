package board;

import com.sun.source.tree.BreakTree;
import figures.Figure;
import figures.Side;

public class Cell {
    private int leterPosition;
    private int numPosition;

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    private Figure figure;

    public int getLeterPosition() {
        return leterPosition;
    }

    public void setLeterPosition(int leterPosition) {
        this.leterPosition = leterPosition;
    }

    public int getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(int numPosition) {
        this.numPosition = numPosition;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    private Side side;
    public Cell(int numPosition, int leterPosition) throws Exception{
        if(numPosition < 1 || numPosition > 8){
            throw new Exception("Invalid numPosition value in constructor");
        }
        if (leterPosition < 1 || leterPosition > 8){
            throw new Exception("Invalid letterPosition value in constructor");
        }
        this.numPosition = numPosition;
        this.leterPosition = leterPosition;
        if((numPosition + leterPosition) % 2 == 0)
            this.side = Side.White;
        else
            this.side = Side.Black;
    }

    public String toString(){
        return side.name();
    }

    public boolean hasFigure() {
        return this.figure != null;
    }
}
