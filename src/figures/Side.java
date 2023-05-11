package figures;

public enum Side {
    White(1), Black(0);

    private final int num;

    Side(int num){
        this.num = num;
    }
}
