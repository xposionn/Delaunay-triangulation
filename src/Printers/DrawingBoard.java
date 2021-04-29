package Printers;

import DataSheet.Edge;

import javax.swing.*;
import java.awt.*;
import java.util.Set;


public class DrawingBoard extends JPanel {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static Set<Edge> edgeList;


    public DrawingBoard(Set<Edge> edgeList) {
        setOpaque(true);
        DrawingBoard.edgeList = edgeList;
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        for(Edge edge:edgeList){
            g.drawLine(edge.getPoint1().getX(),edge.getPoint1().getY(),edge.getPoint2().getX(),edge.getPoint2().getY());
        }
    }
}