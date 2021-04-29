package DataSheet;


import java.awt.*;
import java.util.*;
import java.util.List;

public class Triangular {

    List<Edge> edges;

    public Triangular(Edge a, Edge b, Edge c) {
        edges = new ArrayList<>();
        edges.addAll(Arrays.asList(a, b, c));
    }

    public Triangular(Triangular tr) {
        this.edges = tr.getEdges();
    }


    public List<Edge> getEdges() {
        return edges;
    }

    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        for (Edge edge : edges) {
            points.add(edge.getPoint1());
            points.add(edge.getPoint2());
        }

        return points;
    }

    public Edge getEdgeByTwoPoints(Point p1, Point p2) {
        for (Edge edge : edges) {
            if ((p1 == edge.getPoint1() && p2 == edge.getPoint2()) || (p1 == edge.getPoint2() && p2 == edge.getPoint1())) {
                return edge;
            }
        }
        return null;
    }
}
