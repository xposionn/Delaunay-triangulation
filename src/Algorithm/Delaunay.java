package Algorithm;

import DataSheet.*;
import Handlers.Handler;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Delaunay {
    Graph g;
    Queue<Edge> edgesToBeChecked;


    public Delaunay(Triangular t) {
        Graph g = new Graph(t);
        edgesToBeChecked = new LinkedList<>();
    }

    public void insertPoint(Point p) {
        Node t = g.findTriangular(p);
        Triangular triangular = t.getTriangular();
        List<Triangular> triangulars = Handler.getTriangularsByPoint(triangular, p);
        t.setChilds(triangulars.stream().map(Node::new).collect(Collectors.toList()));
        edgesToBeChecked.addAll(t.getEdges());
        while (!edgesToBeChecked.isEmpty()) {
            Edge edge = edgesToBeChecked.poll();
            swapIfNeeded(edge);

        }


    }


    private void swapIfNeeded(Edge edge) {
        if (swapIsNeeded(edge)) {
            //Todo:add the new edges.
//            edgesToBeChecked.add()
//            edgesToBeChecked.add()
        }
    }

    private boolean swapIsNeeded(Edge edge) {
        //Todo: check if swap is needed
        return true;
    }

    public List<Triangular> getAllLeafs() {
        return g.getAllLeafs().stream().map(node -> node.getTriangular()).collect(Collectors.toList());
    }


}
