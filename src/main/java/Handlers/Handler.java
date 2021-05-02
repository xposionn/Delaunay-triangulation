package main.java.Handlers;

import main.java.DataSheet.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Handler {
    public static List<Triangular> getTriangularsByPoint(Triangular triangular, Point p) {

        Triangular ab;
        Triangular bc;
        Triangular ca;


        ab = new Triangular(triangular.getA(), triangular.getB(), p);
        bc = new Triangular(triangular.getB(),triangular.getC(), p );
        ca = new Triangular(triangular.getC(), triangular.getA(), p);

        makeNeighbors(ab, bc, new Edge(p, triangular.getB()));
        makeNeighbors(bc, ca, new Edge(p, triangular.getC()));
        makeNeighbors(ca, ab, new Edge(p, triangular.getA()));

        makeNeighbors(ab, triangular.getAb(), new Edge(triangular.getA(), triangular.getB()));
        makeNeighbors(bc, triangular.getBc(), new Edge(triangular.getC(), triangular.getB()));
        makeNeighbors(ca, triangular.getCa(), new Edge(triangular.getA(), triangular.getC()));

        return new ArrayList<>(Arrays.asList(ab, bc, ca));
    }

    public static void makeNeighbors(Triangular t1, Triangular t2, Edge edge) {
        if (t1 != null) {
            if (edge.equals(t1.getEdgeAb())) {
                t1.setAb(t2);
            }else if(edge.equals(t1.getEdgeBc())){
                t1.setBc(t2);
            }else if(edge.equals(t1.getEdgeCa()))
                t1.setCa(t2);
            else{
                System.out.println("ERROR in make neighbors.");
            }
        }

        if (t2 != null) {
            if (edge.equals(t2.getEdgeAb())) {
                t2.setAb(t1);
            }else if(edge.equals(t2.getEdgeBc())){
                t2.setBc(t1);
            }else if(edge.equals(t2.getEdgeCa()))
                t2.setCa(t1);
            else{
                System.out.println("ERROR in make neighbors.");
            }
        }



    }

    public static Point getCutPoint(Edge a, Edge b) {
        List<Point> aPoints = new ArrayList<>(Arrays.asList(a.getPoint1(), a.getPoint2()));
        if (aPoints.contains(b.getPoint1()))
            return b.getPoint1();
        else if (aPoints.contains(b.getPoint2()))
            return b.getPoint2();
        return null;
    }


    public static long determinantMMatrix(Point x1, Point x2, Point x3, Point x4) {
        long[] r1 = {x1.getX(), x1.getY(), x1.getX() * x1.getX() + x1.getY() * x1.getY()};
        long[] r2 = {x2.getX(), x2.getY(), x2.getX() * x2.getX() + x2.getY() * x2.getY()};
        long[] r3 = {x3.getX(), x3.getY(), x3.getX() * x3.getX() + x3.getY() * x3.getY()};
        long[] r4 = {x4.getX(), x4.getY(), x4.getX() * x4.getX() + x4.getY() * x4.getY()};
        return determinant3(r2, r3, r4)
                - determinant3(r1, r3, r4)
                + determinant3(r1, r2, r4)
                - determinant3(r1, r2, r3);
    }

    public static long determinant3(long[] r1, long[] r2, long[] r3) {
        return r1[0] * ((r2[1] * r3[2]) - (r3[1] * r2[2]))
                - r1[1] * ((r2[0] * r3[2]) - (r3[0] * r2[2]))
                + r1[2] * ((r2[0] * r3[1]) - (r2[1] * r3[0]));
    }

}
