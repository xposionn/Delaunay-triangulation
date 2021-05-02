package Printers;

import DataSheet.Edge;
import DataSheet.Point;
import DataSheet.Triangular;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;


public class DrawingBoard extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static Set<Triangular> triangularSet;


    public DrawingBoard(Set<Triangular> triangularSet) {
        setOpaque(true);
        DrawingBoard.triangularSet = triangularSet;
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        for (Triangular triangular : triangularSet) {
//            if(!outerEdge(edge))
            Edge e1 = triangular.getEdgeCa();
            Edge e2 = triangular.getEdgeAb();
            Edge e3 = triangular.getEdgeBc();
            g.drawLine(e1.getPoint1().getX() / 10, e1.getPoint1().getY() / 10, e1.getPoint2().getX() / 10, e1.getPoint2().getY() / 10);
            g.drawLine(e2.getPoint1().getX() / 10, e2.getPoint1().getY() / 10, e2.getPoint2().getX() / 10, e2.getPoint2().getY() / 10);
            g.drawLine(e3.getPoint1().getX() / 10, e3.getPoint1().getY() / 10, e3.getPoint2().getX() / 10, e3.getPoint2().getY() / 10);
        }
    }

    public static boolean outerEdge(Edge edge) {
        ArrayList<Point> excludedArr = new ArrayList<Point>(Arrays.asList(new Point(0, 0), new Point(10000, 0), new Point(5000, 8660)));
        return excludedArr.contains(edge.getPoint1()) || excludedArr.contains(edge.getPoint2());
    }

    public static boolean outerPoint(Point point) {
        ArrayList<Point> excludedArr = new ArrayList<Point>(Arrays.asList(new Point(0, 0), new Point(10000, 0), new Point(5000, 8660)));
        return excludedArr.contains(point);
    }
}