package figures;

import board.Board;
import board.Cell;

import javax.swing.table.TableRowSorter;
import java.lang.management.BufferPoolMXBean;

public class Queen extends Figure{
    public int getNumPosition() {
        return numPosition;
    }

    public int getLetterPosition() {
        return letterPosition;
    }

    public Queen(Side side){
        this.letterPosition = 4;
        if(side == Side.Black)
            this.numPosition = 8;
        else
            this.numPosition = 1;
    }

    public Queen(int numPosition, int letterPosition, Side side){
        this.numPosition = numPosition;
        this.letterPosition = letterPosition;
        this.side = side;
    }

    // проверяет может ли фигура вообще так ходить по правилам шахмат (гипотетически чистое поле)
    private boolean canMove(Cell to){
        if(to.getLeterPosition() == this.letterPosition || to.getNumPosition() == this.numPosition ||
                (Math.abs(to.getNumPosition() - this.numPosition) == Math.abs(to.getLeterPosition() - this.letterPosition)))
            // последняя строка - проверка хода по диагонали
            return true;
        else
            return false;
    }

    //проверяет не стоят ли на пути фигуры
    private boolean isFigureOnTheWay(Board board, Cell to) {
        if (to.getNumPosition() == this.numPosition) {
            if (this.letterPosition < to.getLeterPosition()) { //ходим направо, проверяем путь от текущей направо
                for (int i = letterPosition + 1; i < to.getLeterPosition(); i++)
                    if (board.hasFigure(numPosition, i))
                        return false;
            } else { // иначе ходим налево, проверяем путь от текущей налево
                for (int i = to.getLeterPosition() + 1; i < letterPosition; i++)
                    if (board.hasFigure(numPosition, i))
                        return false;
            }
        } else if (to.getLeterPosition() == this.letterPosition) {
            if (this.numPosition < to.getNumPosition()) { // ходим вверх
                for (int i = numPosition + 1; i < to.getNumPosition(); i++)
                    if (board.hasFigure(i, letterPosition))
                        return false;
            } else {
                for (int i = to.getNumPosition() + 1; i < numPosition; i++)
                    if (board.hasFigure(i, letterPosition))
                        return false;
            }
        } else {
            if (this.numPosition > to.getNumPosition()) { // движемся вниз
                if (this.letterPosition > to.getLeterPosition()) // движемся по диагонали вверх и вправо
                    for (int i = 1; i < numPosition - to.getNumPosition(); i++) {
                        if (board.hasFigure(numPosition - i, letterPosition + i))
                            return false;
                    }

                else { // иначе движемся по диагонали вверх и влево
                    for (int i = 1; i < numPosition - to.getNumPosition(); i++)
                        if (board.hasFigure(numPosition - i, letterPosition - i))
                            return false;
                }
            } else { // движемся вверх
                if (this.letterPosition > to.getLeterPosition()) { // движемся влево вверх
                    for (int i = 1; i < to.getNumPosition() - numPosition; i++)
                        if (board.hasFigure(numPosition + i, letterPosition - i))
                            return false;
                } else // иначе движемся вправа вверх
                    for (int i = 1; i < to.getNumPosition() - numPosition; i++)
                        if (board.hasFigure(numPosition + i, letterPosition + i))
                            return false;
            }

        }
        return true;
    }

    //проверяет можно ли сделать такой ход, если хоть одна из проверок неверна - return false
    public boolean move(Board board, Cell to){
        if(!canMove(to))
            return false;
        if(isFigureOnTheWay(board, to)){
            return false;
        }

        return true;
    }

//    public void move(int num, int letter){ // сначала строка, потом столбец
//        if(0 <= num && num <= SIZE && 0 <= letter && letter <= SIZE);
//
//    }
}
