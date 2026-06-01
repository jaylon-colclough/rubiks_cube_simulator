import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;

public class GenCube {

    public static void main(String[] args){
        Cube c1 = new Cube();
        Mover m1 = new Mover(c1);
        window(c1, m1);
        System.out.println(c1);
    }

    public static void window(Cube c, Mover m){

        
        JFrame frame = new JFrame("Rubik's Cube Simulator");
        frame.setSize(1050, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        try {
            frame.setIconImage(ImageIO.read(new File("icon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        CustomDrawingPanel canvas = new CustomDrawingPanel();
        canvas.setOpaque(false);
        frame.add(canvas, BorderLayout.CENTER);
        CubeHolder holder = new CubeHolder(c);
        canvas.drawCube(holder.c);

        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);

        JButton resetButton = new JButton("Reset");
        //cw
        JButton moveUButton = new JButton("U");
        JButton moveDButton = new JButton("D");
        JButton moveRButton = new JButton("R");
        JButton moveLButton = new JButton("L");
        JButton moveFButton = new JButton("F");
        JButton moveBButton = new JButton("B");
        //ccw
        JButton moveUPButton = new JButton("U'");
        JButton moveDPButton = new JButton("D'");
        JButton moveRPButton = new JButton("R'");
        JButton moveLPButton = new JButton("L'");
        JButton moveFPButton = new JButton("F'");
        JButton moveBPButton = new JButton("B'");



        resetButton.addActionListener(e -> {
            holder.c = new Cube();
            m.setCube(holder.c);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveUButton.addActionListener(e -> {
            m.moveU(1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveDButton.addActionListener(e -> {
            m.moveD(1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveRButton.addActionListener(e -> {
            m.moveR(1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveLButton.addActionListener(e -> {
            m.moveL(1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveFButton.addActionListener(e -> {
            m.moveF(1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveBButton.addActionListener(e -> {
            m.moveB(1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        //prime
        moveUPButton.addActionListener(e -> {
            m.moveU(-1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveDPButton.addActionListener(e -> {
            m.moveD(-1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveRPButton.addActionListener(e -> {
            m.moveR(-1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveLPButton.addActionListener(e -> {
            m.moveL(-1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveFPButton.addActionListener(e -> {
            m.moveF(-1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        moveBPButton.addActionListener(e -> {
            m.moveB(-1);
            canvas.drawCube(holder.c);
            canvas.repaint();
        });

        buttonPanel.add(resetButton);
        buttonPanel.add(moveUButton);
        buttonPanel.add(moveDButton);
        buttonPanel.add(moveRButton);
        buttonPanel.add(moveLButton);
        buttonPanel.add(moveFButton);
        buttonPanel.add(moveBButton);
        buttonPanel.add(moveUPButton);
        buttonPanel.add(moveDPButton);
        buttonPanel.add(moveRPButton);
        buttonPanel.add(moveLPButton);
        buttonPanel.add(moveFPButton);
        buttonPanel.add(moveBPButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
