package figures;

import board.Cell;

public abstract class Figure implements Moveable {
    public static final int SIZE = 8;
    protected int numPosition;
    protected int letterPosition;
    protected Side side;

    public int[] getPosition(){
        return new int[]{numPosition, letterPosition};
    }
}
