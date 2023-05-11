package figures;

import board.Board;
import board.Cell;

public interface Moveable {
    public boolean move(Board board, Cell cell);
}
