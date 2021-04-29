package DataSheet;

public class Vertex extends Point {
    HalfEdge h;

    public Vertex(Point point, HalfEdge h) {
        super(point);
        this.h = h;
    }

}
