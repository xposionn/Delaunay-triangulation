package Printers;

import DataSheet.Edge;
import DataSheet.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;


public class DrawingBoard extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
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
//            if(!outerEdge(edge))
                g.drawLine(edge.getPoint1().getX()/10,edge.getPoint1().getY()/10,edge.getPoint2().getX()/10,edge.getPoint2().getY()/10);
        }
    }

    public static boolean outerEdge(Edge edge) {
        ArrayList<Point> excludedArr = new ArrayList<Point>(Arrays.asList(new Point(0,0),new Point(10000, 0),new Point(5000, 8660)));
        return excludedArr.contains(edge.getPoint1()) || excludedArr.contains(edge.getPoint2());
    }
    public static boolean outerPoint(Point point) {
        ArrayList<Point> excludedArr = new ArrayList<Point>(Arrays.asList(new Point(0,0),new Point(10000, 0),new Point(5000, 8660)));
        return excludedArr.contains(point);
    }
}