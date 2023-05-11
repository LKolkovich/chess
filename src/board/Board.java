package board;

public class Board {
    public static final int MAX_CELLS = 8;

    public Cell[][] getCells() {
        return cells;
    }

    private Cell[][] cells; // [num][letter]

    public Board() throws Exception{
        cells = new Cell[MAX_CELLS][MAX_CELLS];
        for(int num = 1; num <= MAX_CELLS; num++){
            for(int letter = 1; letter <= MAX_CELLS; letter++){
                cells[num - 1][letter - 1] = new Cell(num, letter);
            }
        }
    }

    public String toString(){
        String str = "";
        for(int num = 0; num < MAX_CELLS; num++){
            for(int letter = 0; letter < MAX_CELLS; letter++){
                str += cells[num][letter].toString();
                str += " ";
            }
            str += "\n";
        }
        return str;
    }

    public boolean hasFigure(int num, int letter){
        return cells[num][letter].hasFigure();
    }


}


