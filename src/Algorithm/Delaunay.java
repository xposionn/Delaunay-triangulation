package Algorithm;

import DataSheet.*;
import Handlers.Handler;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Delaunay {
    Graph g;
    Queue<Pair<Edge, Node>> edgesToBeChecked;


    public Delaunay(Triangular t) {
        Graph g = new Graph(t);
        edgesToBeChecked = new LinkedList<>();
    }

    public void insertPoint(Point p) {
        Node triangular = g.findTriangular(p);
        List<Node> triangulars = Handler.getTriangularsByPoint(triangular, p);
        triangular.setChilds(triangulars);
        edgesToBeChecked.addAll(triangular.getEdges().stream().map(e -> new Pair<Edge, Node>(e, triangular)).collect(Collectors.toList()));
        while (!edgesToBeChecked.isEmpty()) {
        	Pair<Edge, Node> edge = edgesToBeChecked.poll();
            Edge newEdge = swapIfNeeded(edge.getKey());
            if (newEdge != null) {
            	edge.getKey().getTriangular1();
            }
        }


    }


    private Edge swapIfNeeded(Edge edge) {
        if (swapIsNeeded(edge)) {
            //Todo:add the new edges.
//            edgesToBeChecked.add()
//            edgesToBeChecked.add()
        }
        return null;
    }

    private boolean swapIsNeeded(Edge edge) {
        //Todo: check if swap is needed
        return true;
    }

    public List<Triangular> getAllLeafs() {
        return g.getAllLeafs().stream().map(node -> node.getTriangular()).collect(Collectors.toList());
    }


}
