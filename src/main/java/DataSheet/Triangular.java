package DataSheet;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

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
        Set<Point> points = new HashSet<>();
        for (Edge edge : edges) {
            points.add(edge.getPoint1());
            points.add(edge.getPoint2());
        }

        return new ArrayList<>(points);
    }

    public Edge getEdgeByTwoPoints(Point p1, Point p2) {
        for (Edge edge : edges) {
            if ((p1.equals(edge.getPoint1()) && p2.equals(edge.getPoint2())) || (p1.equals(edge.getPoint2()) && p2.equals(edge.getPoint1()))) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangular that = (Triangular) o;
        return Objects.equals(edges, that.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edges);
    }
}
