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
        g = new Graph(t);
        t.getEdges().forEach(e->e.setExteral(true));
        edgesToBeChecked = new LinkedList<>();
    }

    public void insertPoint(Point p) {
        Node triangular = g.findTriangular(p);
        List<Node> triangulars = Handler.getTriangularsByPoint(triangular, p);
        triangular.setChilds(triangulars);
        //TODO: why the Node in the pair is triangular? should it be some child?
        // are we sure we need to check the new edges? not the existed ?
        edgesToBeChecked.addAll(triangular.getEdges().stream().map(e -> new Pair<Edge, Node>(e, triangular)).collect(Collectors.toList()));
        while (!edgesToBeChecked.isEmpty()) {
        	Pair<Edge, Node> edge = edgesToBeChecked.poll();
        	if(edge.getKey().isExteral()) continue;
            Edge newEdge = swapIfNeeded(edge.getKey());
            if (newEdge != null) {
            	Node northNode = newEdge.getNode1();
            	Node southNode = newEdge.getNode2();
            	Node westNode = (edge.getKey().getNode1().equals(edge.getValue()) ? edge.getKey().getNode2() : edge.getKey().getNode1());
            	for (Edge someWestEdge : westNode.getEdges()) {
            		if (someWestEdge.equals(edge.getKey()))
            			continue;
            		if (northNode.getEdges().contains(someWestEdge))
            			edgesToBeChecked.add(new Pair<Edge, Node>(someWestEdge, northNode));
            		else if (southNode.getEdges().contains(someWestEdge))
            			edgesToBeChecked.add(new Pair<Edge, Node>(someWestEdge, southNode));
            	}
            }
        }
    }


    private Edge swapIfNeeded(Edge edge) {
    	Point northPoint = edge.getPoint1();
    	Point southPoint = edge.getPoint2();
    	Node eastNode = edge.getNode1();
        Node westNode = edge.getNode2();
        
        List<Point> eastTraingularPoints = eastNode.getPoints();
        Point eastPoint = null;
        for (Point point : eastTraingularPoints) {
        	if (!point.equals(northPoint) && !point.equals(southPoint))
        		eastPoint = point;
        }
        
        List<Point> westTraingularPoints = westNode.getPoints();
        Point westPoint = null;
        for (Point point : westTraingularPoints) {
        	if (!point.equals(northPoint) && !point.equals(southPoint))
        		westPoint = point;
        }
    	if (!isInCircle(northPoint, eastPoint, southPoint, westPoint))
    		return null;
        
        Edge newEdge = new Edge(eastPoint, westPoint);
        Node northNode = new Node(new Triangular(newEdge, eastNode.getEdgeByTwoPoints(northPoint, eastPoint), westNode.getEdgeByTwoPoints(northPoint, westPoint)));
        Node southNode = new Node(new Triangular(newEdge, eastNode.getEdgeByTwoPoints(southPoint, eastPoint), westNode.getEdgeByTwoPoints(southPoint, westPoint)));
        newEdge.setTriangular1(northNode);
        newEdge.setTriangular2(southNode);
        return newEdge;
    }

    // Check if point is in circle of the triangular with the following 3 vertices 
    public static boolean isInCircle(Point vertex1, Point vertex2, Point vertex3, Point point) {
        int detM = Handler.determinantMMatrix(vertex1, vertex2, vertex3, point);
        return (detM > 0);
    }

    public List<Triangular> getAllLeafs() {
        return g.getAllLeafs().stream().map(Node::getTriangular).collect(Collectors.toList());
    }


}
