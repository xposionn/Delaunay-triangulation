package Handlers;

import DataSheet.Edge;
import DataSheet.Node;
import DataSheet.Point;
import DataSheet.Triangular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Handler {
    public static List<Node> getTriangularsByPoint(Node triangular, Point p) {

        Node triangular0;
        Node triangular1;
        Node triangular2;

        List<Edge> edges = triangular.getEdges();
        Point cutPoint01 = Handler.getCutPoint(edges.get(0),edges.get(1));
        Point cutPoint02 = Handler.getCutPoint(edges.get(0),edges.get(2));
        Point cutPoint12 = Handler.getCutPoint(edges.get(1),edges.get(2));

        Edge a = new Edge(p, cutPoint01);
        Edge b = new Edge(p, cutPoint02);
        Edge c = new Edge(p, cutPoint12);

        triangular0 = new Node(new Triangular(a,b,edges.get(0)));
        triangular1 = new Node(new Triangular(a,c,edges.get(1)));
        triangular2 = new Node(new Triangular(b,c,edges.get(2)));

        a.setTriangular1(triangular0);
        a.setTriangular2(triangular1);
        b.setTriangular1(triangular0);
        b.setTriangular2(triangular2);
        c.setTriangular1(triangular1);
        c.setTriangular2(triangular2);

        edges.get(0).replace(triangular,triangular0);
        edges.get(1).replace(triangular,triangular1);
        edges.get(2).replace(triangular,triangular2);

        return new ArrayList<>(Arrays.asList(triangular0,triangular1,triangular2));
    }

    public static Point getCutPoint(Edge a, Edge b) {
        List<Point> aPoints = new ArrayList<>(Arrays.asList(a.getPoint1(), a.getPoint2()));
        if (aPoints.contains(b.getPoint1()))
        	return b.getPoint1();
        else if (aPoints.contains(b.getPoint2()))
        	return b.getPoint2();
        return null;
    }

    public List<Triangular> getTriangularFromNodes(List<Node> nodes) {
        return nodes.stream().map(Node::getTriangular).collect(Collectors.toList());
    }
    
    public static int determinantMMatrix(Point x1, Point x2, Point x3, Point x4) {
    	int[] r1 = {x1.getX(), x1.getY(), x1.getX()*x1.getX() + x1.getY()*x1.getY()};
    	int[] r2 = {x2.getX(), x2.getY(), x2.getX()*x2.getX() + x2.getY()*x2.getY()};
    	int[] r3 = {x3.getX(), x3.getY(), x3.getX()*x3.getX() + x3.getY()*x3.getY()};
    	int[] r4 = {x4.getX(), x4.getY(), x4.getX()*x4.getX() + x4.getY()*x4.getY()};
    	return - determinant3(r2, r3, r4)
    			+ determinant3(r1, r3, r4)
    			- determinant3(r1, r2, r4)
    			+ determinant3(r1, r2, r3);
    }
    
    public static int determinant3(int[] r1, int[]r2, int[]r3) {
    	 return r1[0]*((r2[1]*r3[2])-(r3[1]*r2[2]))
    			 - r1[1]*((r2[0]*r3[2])-(r3[0]*r2[2]))
    			 + r1[2]*((r2[0]*r3[1])-(r2[1]*r3[0]));
    }

}