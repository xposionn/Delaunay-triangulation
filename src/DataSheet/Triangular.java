package DataSheet;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangular {

    HalfEdge halfEdge;

    public Triangular(HalfEdge halfEdge) {
        this.halfEdge = halfEdge;
    }

    public Triangular(Triangular triangular) {
        this.halfEdge = triangular.getHalfEdge();
    }

    public HalfEdge getHalfEdge() {
        return halfEdge;
    }

    public List<Edge> getAllEdges(){
        List<Edge> list = new ArrayList<>();
        list.add(halfEdge.getEdge());
        list.add(halfEdge.getNext().getEdge());
        list.add(halfEdge.getNext().getNext().getEdge());
        return list;
    }
}
