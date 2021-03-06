package DataSheet;

import java.util.*;
import java.util.List;

public class Triangular {

    Point a;
    Point b;
    Point c;
    Triangular ab;
    Triangular bc;
    Triangular ca;
    List<Triangular> childs;

    public Triangular(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        childs = new ArrayList<>();
    }


    public void setChilds(List<Triangular> childs) {
        this.childs = childs;
    }

    public Edge getEdgeAb() {
        return new Edge(a, b);
    }

    public Edge getEdgeBc() {
        return new Edge(c, b);
    }

    public Edge getEdgeCa() {
        return new Edge(a, c);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Triangular getAb() {
        return ab;
    }

    public Point getOppositePoint(Edge edge) {
        if (edge.equals(getEdgeAb())) {
            return c;
        } else if (edge.equals(getEdgeBc())) {
            return a;
        } else if (edge.equals(getEdgeCa()))
            return b;
        else {
            System.out.println("Error in getOppositePoint");
            return null;
        }

    }

    public Triangular getOtherTriangular(Edge edge) {
        if (edge.equals(getEdgeAb())) {
            return ab;
        } else if (edge.equals(getEdgeBc())) {
            return bc;
        } else if (edge.equals(getEdgeCa()))
            return ca;
        else {
            System.out.println("Error in getOtherTriangular");
            return null;
        }
    }


    public void setAb(Triangular ab) {
        this.ab = ab;
    }

    public Triangular getBc() {
        return bc;
    }

    public void setBc(Triangular bc) {
        this.bc = bc;
    }

    public Triangular getCa() {
        return ca;
    }

    public void setCa(Triangular ca) {
        this.ca = ca;
    }

    public List<Triangular> getChilds() {
        return childs;
    }

    public boolean isPointInside(Point pt) {
        float orient1, orient2, orient3;
        orient1 = orient(pt, a, b);
        orient2 = orient(pt, b, c);
        orient3 = orient(pt, c, a);

        // all points are in general position, hence sign will not be 0.
        //point is in triangule iff all the orients have the same sign.

        if(orient1 < 0){
            return (orient2 < 0) && (orient3 < 0);
        }
        else{
            return (orient2 > 0) && (orient3 > 0);
        } 
    }

    private float orient(Point p1, Point p2, Point p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    public Triangular(Triangular oth) {
        this.a = oth.a;
        this.b = oth.b;
        this.c = oth.c;
        this.childs = oth.childs;
    }

    public boolean isLeaf() {
        return childs.size() == 0;
    }
}
