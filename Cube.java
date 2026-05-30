public class Cube{
 
    private final Piece[] pieces = new Piece[26];
    private int cubeCount;
    
    public Cube(){

        this.cubeCount++;

        //bottom layer
        pieces[0] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.RED, PieceColor.YELLOW, PieceColor.GREEN},  new Faces[]{Faces.FRONT, Faces.DOWN, Faces.LEFT}, -1, -1, -1);
        pieces[1] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.RED, PieceColor.YELLOW},  new Faces[]{Faces.FRONT, Faces.DOWN}, 0, -1, -1);
        pieces[2] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.RED, PieceColor.YELLOW, PieceColor.BLUE},  new Faces[]{Faces.FRONT, Faces.DOWN, Faces.RIGHT}, 1, -1, -1);
        pieces[3] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.BLUE, PieceColor.YELLOW},  new Faces[]{Faces.RIGHT, Faces.DOWN}, 1, 0, -1);
        pieces[4] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.ORANGE, PieceColor.YELLOW, PieceColor.BLUE},  new Faces[]{Faces.BACK, Faces.DOWN, Faces.RIGHT}, 1, 1, -1);
        pieces[5] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.ORANGE, PieceColor.YELLOW},  new Faces[]{Faces.BACK, Faces.DOWN}, 0, 1, -1);
        pieces[6] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.ORANGE, PieceColor.YELLOW, PieceColor.GREEN},  new Faces[]{Faces.BACK, Faces.DOWN, Faces.LEFT}, -1, 1, -1);
        pieces[7] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.GREEN, PieceColor.YELLOW},  new Faces[]{Faces.LEFT, Faces.DOWN}, -1, 0, -1);
        pieces[8] = new Piece(PieceType.CENTER, new PieceColor[]{PieceColor.YELLOW},  new Faces[]{Faces.DOWN}, 0, 0, -1);

        //middle layer
        pieces[9] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.RED, PieceColor.GREEN},  new Faces[]{Faces.FRONT, Faces.LEFT}, -1, -1, 0);
        pieces[10] = new Piece(PieceType.CENTER, new PieceColor[]{PieceColor.RED},  new Faces[]{Faces.FRONT}, 0, -1, 0);
        pieces[11] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.RED, PieceColor.BLUE},  new Faces[]{Faces.FRONT, Faces.RIGHT}, 1, -1, 0);
        pieces[12] = new Piece(PieceType.CENTER, new PieceColor[]{PieceColor.BLUE},  new Faces[]{Faces.RIGHT}, 1, 0, 0);
        pieces[13] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.BLUE, PieceColor.ORANGE},  new Faces[]{Faces.RIGHT, Faces.BACK}, 1, 1, 0);
        pieces[14] = new Piece(PieceType.CENTER, new PieceColor[]{PieceColor.ORANGE},  new Faces[]{Faces.BACK}, 0, 1, 0);
        pieces[15] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.ORANGE, PieceColor.GREEN},  new Faces[]{Faces.BACK, Faces.LEFT}, -1, 1, 0);
        pieces[16] = new Piece(PieceType.CENTER, new PieceColor[]{PieceColor.GREEN},  new Faces[]{Faces.LEFT}, -1, 0, 0);

        //top layer
        pieces[17] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.WHITE, PieceColor.RED, PieceColor.GREEN},  new Faces[]{Faces.UP, Faces.FRONT, Faces.LEFT}, -1, -1, 1);
        pieces[18] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.WHITE, PieceColor.RED},  new Faces[]{Faces.UP, Faces.FRONT}, 0, -1, 1);
        pieces[19] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.WHITE, PieceColor.RED, PieceColor.BLUE},  new Faces[]{Faces.UP, Faces.FRONT, Faces.RIGHT}, 1, -1, 1);
        pieces[20] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.WHITE, PieceColor.BLUE},  new Faces[]{Faces.UP, Faces.RIGHT}, 1, 0, 1);
        pieces[21] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.WHITE, PieceColor.BLUE, PieceColor.ORANGE},  new Faces[]{Faces.UP, Faces.RIGHT, Faces.BACK}, 1, 1, 1);
        pieces[22] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.WHITE, PieceColor.ORANGE},  new Faces[]{Faces.UP, Faces.BACK}, 0, 1, 1);
        pieces[23] = new Piece(PieceType.CORNER, new PieceColor[]{PieceColor.WHITE, PieceColor.ORANGE, PieceColor.GREEN},  new Faces[]{Faces.UP, Faces.BACK, Faces.LEFT}, -1, 1, 1);
        pieces[24] = new Piece(PieceType.EDGE, new PieceColor[]{PieceColor.WHITE, PieceColor.GREEN},  new Faces[]{Faces.UP,Faces.LEFT}, -1, 0, 1);
        pieces[25] = new Piece(PieceType.CENTER, new PieceColor[]{PieceColor.WHITE},  new Faces[]{Faces.UP}, 0, 0, 1);
    }

    public int getCubeCount(){
        return this.cubeCount;
    }

    public Piece[] getPiecesList(){
        return pieces;
    }

    public Piece getPieceAt(int x, int y, int z){
        Piece res = null;
        for(Piece p : pieces){
            if((p.getX() == x) &&(p.getY() == y) && (p.getZ() == z)){
                res = p;
            }
        }
        return res;
    }

    @Override
    public String toString(){
        String res = "";
        
        //top face
        res += "\n";
        for(int y = 1; y >= -1; y--){
            res += "\t   ";
            
            for(int x = -1; x <= 1; x++){
                Piece p = getPieceAt(x, y, 1);
                Faces[] dirs = p.getFace();
                PieceColor[] colors = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.UP){
                        res += "[" + colors[i] + "]";
                    }
                }
            }
            res += "\n";
        }
        res += "\n";
        
        //middle layer
        for(int z = 1; z >= -1; z--){

            //left face
            for(int y = -1; y <= 1; y++){

                Piece p = getPieceAt(-1, y, z);
                Faces[] dirs = p.getFace();
                PieceColor[] colors = p.getColor();

                

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.LEFT){
                        res += "[" + colors[i] + "]";
                    }
                }
            }
            res += "  ";

            //front face
            for(int x = -1; x <= 1; x++){

                Piece p = getPieceAt(x, -1, z);
                Faces[] dirs = p.getFace();
                PieceColor[] colors = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.FRONT){
                        res += "[" + colors[i] + "]";
                    }
                }
            }
            res += "  ";

            //right face
            for(int y = -1; y <= 1; y++){

                Piece p = getPieceAt(1, y, z);
                Faces[] dirs = p.getFace();
                PieceColor[] colors = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.RIGHT){
                        res += "[" + colors[i] + "]";
                        if(p == null){
                            res += "[?]";
                            continue;
                        }
                    }
                }
            }
            res += "  ";

            //back
            for(int x = -1; x <= 1; x++){

                Piece p = getPieceAt(x, 1, z);
                Faces[] dirs = p.getFace();
                PieceColor[] colors = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.BACK){
                        res += "[" + colors[i] + "]";
                    }
                }
            }
            res += "\n";
        }
        res += "\n";

        //bottom face
        for(int y = 1; y >= -1; y--){
            res += "\t   ";
            for(int x = -1; x <= 1; x++){
                Piece p = getPieceAt(x, y, -1);
                Faces[] dirs = p.getFace();
                PieceColor[] colors = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.DOWN){
                        res += "[" + colors[i] + "]";
                    }
                }
            }
            res += "\n";
        }
        
        return res;
    }

}