//most likely will be numbers

enum PieceColor{

    WHITE("W"),
    BLUE("B"),
    ORANGE("O"),
    GREEN("G"),
    RED("R"),
    YELLOW("Y");

    private String sym;

    PieceColor(String sIn){
        this.sym = sIn;
    }

    @Override
    public String toString(){
        return this.sym;
    }
    
}