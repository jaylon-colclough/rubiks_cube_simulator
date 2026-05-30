import java.util.ArrayList;

public class Mover {
    
    private Cube cube;

    public Mover(Cube cIn){
        this.cube = cIn;
    }
    
    /**
     * ######################################################
     * if dir is 1 clockwise rot; -1 counter-clockwise rot
     * methods to rotate layers on specific axis
     * ######################################################
     **/
    
    private Faces rotateZ(Faces f, int dir){
        return switch(f){
            case FRONT -> dir == 1 ? Faces.LEFT  : Faces.RIGHT; 
            case LEFT  -> dir == 1 ? Faces.BACK  : Faces.FRONT; 
            case BACK  -> dir == 1 ? Faces.RIGHT : Faces.LEFT;  
            case RIGHT -> dir == 1 ? Faces.FRONT : Faces.BACK;   
            case UP, DOWN -> f; // unaffected by Z rotation
        };
    }

    private Faces rotateX(Faces f, int dir){
        return switch(f){
            case FRONT -> dir == 1 ? Faces.UP  : Faces.DOWN; 
            case UP  -> dir == 1 ? Faces.BACK  : Faces.FRONT; 
            case BACK  -> dir == 1 ? Faces.DOWN : Faces.UP;   
            case DOWN -> dir == 1 ? Faces.FRONT : Faces.BACK;
            case LEFT, RIGHT -> f; // unaffected by Z rotation
        };
    }

    private Faces rotateY(Faces f, int dir){
        return switch(f){
            case RIGHT -> dir == 1 ? Faces.UP  : Faces.DOWN; 
            case UP  -> dir == 1 ? Faces.LEFT  : Faces.RIGHT; 
            case LEFT  -> dir == 1 ? Faces.DOWN : Faces.UP;   
            case DOWN -> dir == 1 ? Faces.RIGHT : Faces.LEFT;
            case FRONT, BACK -> f; // unaffected by Z rotation
        };
    }

    public void moveU(int dir){
        ArrayList<Piece> layer = new ArrayList<Piece>();

        //gets all pieces on specific layer and stores into list
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                layer.add(cube.getPieceAt(x, y, 1)); //gets specific layer
            }
        }
        //recalculating coordniates and shifting face directions
        for(Piece p : layer){
            int newX =  dir * p.getY();
            int newY = -dir * p.getX();
            p.changeX(newX);
            p.changeY(newY);
        
            Faces[] faceList = p.getFace();
            for(int i = 0; i < faceList.length; i++){
                faceList[i] = rotateZ(faceList[i], dir);
            }
        }
    }

    public void moveD(int dir){
        ArrayList<Piece> layer = new ArrayList<Piece>();

        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                layer.add(cube.getPieceAt(x, y, -1));
            }
        }
        for(Piece p : layer){
            int newX =  dir * p.getY();
            int newY = -dir * p.getX();
            p.changeX(newX);
            p.changeY(newY);
        
            Faces[] faceList = p.getFace();
            for(int i = 0; i < faceList.length; i++){
                faceList[i] = rotateZ(faceList[i], dir);
            }
        }
    }

    public void moveR(int dir){
        ArrayList<Piece> layer = new ArrayList<Piece>();

        for(int y = -1; y <= 1; y++){
            for(int z = -1; z <= 1; z++){
                layer.add(cube.getPieceAt(1, y, z));
            }
        }
        for(Piece p : layer){
            int newY =  dir * p.getZ();
            int newZ = -dir * p.getY();
            p.changeZ(newZ);
            p.changeY(newY);
        
            Faces[] faceList = p.getFace();
            for(int i = 0; i < faceList.length; i++){
                faceList[i] = rotateX(faceList[i], dir);
            }
        }
    }

    public void moveL(int dir){
        ArrayList<Piece> layer = new ArrayList<Piece>();

        for(int y = -1; y <= 1; y++){
            for(int z = -1; z <= 1; z++){
                layer.add(cube.getPieceAt(-1, y, z));
            }
        }
        for(Piece p : layer){
            int newY =  dir * p.getZ();
            int newZ = -dir * p.getY();
            p.changeZ(newZ);
            p.changeY(newY);
        
            Faces[] faceList = p.getFace();
            for(int i = 0; i < faceList.length; i++){
                faceList[i] = rotateX(faceList[i], dir);
            }
        }
    }

    public void moveF(int dir){
        ArrayList<Piece> layer = new ArrayList<Piece>();

        for(int x = -1; x <= 1; x++){
            for(int z = -1; z <= 1; z++){
                layer.add(cube.getPieceAt(x, -1, z));
            }
        }
        for(Piece p : layer){
            int newX =  -dir * p.getZ();
            int newZ = dir * p.getX();
            p.changeX(newX);
            p.changeZ(newZ);
        
            Faces[] faceList = p.getFace();
            for(int i = 0; i < faceList.length; i++){
                faceList[i] = rotateY(faceList[i], dir);
            }
        }
    }

    public void moveB(int dir){
        ArrayList<Piece> layer = new ArrayList<Piece>();

        for(int x = -1; x <= 1; x++){
            for(int z = -1; z <= 1; z++){
                layer.add(cube.getPieceAt(x, 1, z));
            }
        }
        for(Piece p : layer){
            int newX =  -dir * p.getZ();
            int newZ = dir * p.getX();
            p.changeX(newX);
            p.changeZ(newZ);
        
            Faces[] faceList = p.getFace();
            for(int i = 0; i < faceList.length; i++){
                faceList[i] = rotateY(faceList[i], dir);
            }
        }
    }
}
