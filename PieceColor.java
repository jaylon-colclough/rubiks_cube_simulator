import java.awt.Color;

enum PieceColor{

    WHITE("W", Color.WHITE),
    BLUE("B", Color.BLUE),
    ORANGE("O", Color.ORANGE),
    GREEN("G", Color.GREEN),
    RED("R", Color.RED),
    YELLOW("Y", Color.YELLOW);

    private String sym;
    private Color col;

    PieceColor(String sIn, Color colIn){
        this.sym = sIn;
        this.col = colIn;
    }

    public Color getCol(){
        return this.col;
    }

    @Override
    public String toString(){
        return this.sym;
    }
    
}