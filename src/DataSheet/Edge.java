package DataSheet;

import java.util.Objects;

public class Edge {
    Point point1;
    Point point2;
    Node triangular1;
    Node triangular2;
//  Todo: remove
    public Edge(){

    }

    public Edge(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Node getNode1() {
		return triangular1;
	}

	public Node getNode2() {
		return triangular2;
	}

	public Triangular getTriangular1() {
		return triangular1.getTriangular();
	}

	public Triangular getTriangular2() {
		return triangular2.getTriangular();
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (Objects.equals(point1, edge.point1) && Objects.equals(point2, edge.point2) )|| (Objects.equals(point1, edge.point2) && Objects.equals(point2, edge.point1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1)+Objects.hashCode(point2);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setTriangular1(Node triangular1) {
        this.triangular1 = triangular1;
    }

    public void setTriangular2(Node triangular2) {
        this.triangular2 = triangular2;
    }

    public void replace(Node from, Node to) {
    	if (from == getTriangular1())
    		setTriangular1(to);
    	else
    		setTriangular2(to);
    }
}
