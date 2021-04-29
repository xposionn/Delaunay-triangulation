package DataSheet;

public class HalfEdge {

    HalfEdge twin;
    HalfEdge next;
    HalfEdge prev;
    Triangular t;
    Vertex source;


    //Todo: remove
    public HalfEdge() {
    }

    public HalfEdge(HalfEdge twin, HalfEdge next, HalfEdge prev, Triangular t, Vertex source) {
        this.twin = twin;
        this.next = next;
        this.prev = prev;
        this.t = t;
        this.source = source;
    }

    public HalfEdge getTwin() {
        return twin;
    }

    public HalfEdge getNext() {
        return next;
    }

    public HalfEdge getPrev() {
        return prev;
    }

    public Triangular getT() {
        return t;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDest(){
        return next.getSource();
    }


    public Edge getEdge(){
        return new Edge(getSource(),getDest());
    }

}
