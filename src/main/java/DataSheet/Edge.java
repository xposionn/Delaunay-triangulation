package DataSheet;

import java.util.Objects;

public class Edge {
    Point point1;
    Point point2;

    public Edge(Edge edgeByTwoPoints) {
        point1 = new Point(edgeByTwoPoints.getPoint1());
        point2 = new Point(edgeByTwoPoints.getPoint2());
    }


    public Edge(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (Objects.equals(point1, edge.point1) && Objects.equals(point2, edge.point2)) || (Objects.equals(point1, edge.point2) && Objects.equals(point2, edge.point1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }


    @Override
    public String toString() {
        return "Edge{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }
}
