package DataSheet;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

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
        float d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(pt, a, b);
        d2 = sign(pt, b, c);
        d3 = sign(pt, c, a);

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }

    private float sign(Point p1, Point p2, Point p3) {
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
