import java.awt.*;
import javax.swing.*;

public class CustomDrawingPanel extends JPanel {

    private Color[][] topColors    = new Color[3][3];
    private Color[][] bottomColors = new Color[3][3];
    private Color[][] leftColors   = new Color[3][3];
    private Color[][] rightColors  = new Color[3][3];
    private Color[][] frontColors  = new Color[3][3];
    private Color[][] backColors   = new Color[3][3];
    
    private final int tile = 40;

    public CustomDrawingPanel() {
        this.setPreferredSize(new Dimension(480, 360));
    }

    public void drawCube(Cube c) {
        
        //top paint
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                Piece p = c.getPieceAt(x, y, 1);
                Faces[] dirs = p.getFace();
                PieceColor[] color = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.UP){
                        topColors[x+1][y+1] = color[i].getCol();
                    }
                }
            }
        }

        for(int z = 1; z >= -1; z--){
            //left paint
            for(int y = -1; y <= 1; y++){
                Piece p = c.getPieceAt(-1, y, z);
                Faces[] dirs = p.getFace();
                PieceColor[] color = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.LEFT){
                        leftColors[1-z][y+1] = color[i].getCol();
                    }
                }
            }
        
            //front paint
            for(int x = 1; x >= -1; x--){
                Piece p = c.getPieceAt(x, -1, z);
                Faces[] dirs = p.getFace();
                PieceColor[] color = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.FRONT){
                        frontColors[1-z][1-x] = color[i].getCol();
                    }
                }
            }

            //right paint
            for(int y = -1; y <= 1; y++){
                Piece p = c.getPieceAt(1, y, z);
                Faces[] dirs = p.getFace();
                PieceColor[] color = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.RIGHT){
                        rightColors[1-z][y+1] = color[i].getCol();
                    }
                }
            }

            //back paint
            for(int x = 1; x >= -1; x--){
                Piece p = c.getPieceAt(x, 1, z);
                Faces[] dirs = p.getFace();
                PieceColor[] color = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.BACK){
                        backColors[1-z][1-x] = color[i].getCol();
                    }
                }
            }
        }
        
        //bottom paint/down
        for(int y = -1; y <= 1; y++){
            for(int x = -1; x <= 1; x++){
                Piece p = c.getPieceAt(x, y, -1);
                Faces[] dirs = p.getFace();
                PieceColor[] color = p.getColor();

                for(int i = 0; i < dirs.length; i++){
                    if(dirs[i] == Faces.DOWN){
                        bottomColors[1+x][1+y] = color[i].getCol();
                    }
                }
            }
        }
    }


    private void drawFace(Graphics2D g2D, Color[][] faceColors, int offsetX, int offsetY){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                g2D.setColor(faceColors[row][col]);
                g2D.fillRect(offsetX + col * tile, offsetY + row * tile, tile, tile);
                g2D.setColor(Color.BLACK);
                g2D.drawRect(offsetX + col * tile, offsetY + row * tile, tile, tile);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        int faceSize = tile * 3;
        int netWidth  = faceSize * 4;
        int netHeight = faceSize * 3;

        int startX = (getWidth()  - netWidth)  / 2;
        int startY = (getHeight() - netHeight) / 2;

        drawFace(g2D, topColors,    startX + faceSize,     startY);              
        drawFace(g2D, leftColors,   startX,                startY + faceSize);   
        drawFace(g2D, frontColors,  startX + faceSize,     startY + faceSize);   
        drawFace(g2D, rightColors,  startX + faceSize * 2, startY + faceSize);   
        drawFace(g2D, backColors,   startX + faceSize * 3, startY + faceSize);   
        drawFace(g2D, bottomColors, startX + faceSize,     startY + faceSize * 2); 
    }
}
