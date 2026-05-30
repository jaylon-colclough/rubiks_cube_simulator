import java.util.Arrays;

public class Piece {
    
    private PieceType type;
    private PieceColor[] colors;
    private Faces[] direction;

    //coordinates
    private int x, y, z;
    
    public Piece(PieceType typeIn, PieceColor[] colorIn, Faces[] dirIn, int xIn, int yIn, int zIn){
        this.type = typeIn;
        this.colors = colorIn;
        this.direction = dirIn;

        this.x = xIn;
        this.y = yIn;
        this.z = zIn;
    }

    //getters
    public PieceType getType(){
        return this.type;
    }

    public PieceColor[] getColor(){
        return this.colors;
    }

    public Faces[] getFace(){
        return this.direction;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getZ(){
        return this.z;
    }

    //setters
    public void changeX(int xIn){
        this.x = xIn;
    }

    public void changeY(int yIn){
        this.y = yIn;
    }

    public void changeZ(int zIn){
        this.z = zIn;
    }

    @Override
    public String toString(){
        return this.type + " - " + Arrays.toString(this.colors) + " - (" + 
                this.x + "," + this.y + "," + this.z + ") - " + Arrays.toString(this.direction);
    }
}
