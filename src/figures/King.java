package figures;

public class King extends Figure{
    public int getNumPosition() {
        return numPosition;
    }

    public int getLetterPosition() {
        return letterPosition;
    }

    public King(Side side){
        this.letterPosition = 5;
        if(side == Side.Black)
            this.numPosition = 8;
        else
            this.numPosition = 1;
    }

    public King(int numPosition, int letterPosition, Side side){
        this.numPosition = numPosition;
        this.letterPosition = letterPosition;
        this.side = side;
    }
    public void move(int num, int letter){ // сначала строка, потом столбец
        if(Math.abs(num - numPosition) <= 1 && Math.abs(letter - letterPosition) <= 1)
            if(0 <= num && num <= SIZE && 0 <= letter && letter <= SIZE){
                numPosition = num;
                letterPosition = letter;
            }
    }
}
