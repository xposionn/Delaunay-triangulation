package Algorithm;

import DataSheet.*;
import Handlers.Handler;
import Printers.DrawingBoard;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Delaunay {
    Graph g;
    Queue<Pair<Edge,Node>> edgesToBeChecked;


    public Delaunay(Triangular t) {
        g = new Graph(t);
        t.getEdges().forEach(e->e.setExteral(true));
        edgesToBeChecked = new LinkedList<>();
    }

    public void insertPoint(Point p) {
        Node triangular = g.findTriangular(p);
        Set<Edge> sureEdges = new HashSet<>();
        List<Node> triangulars = Handler.getTriangularsByPoint(triangular, p);
        Set<Edge> createdEdges = new HashSet<>();
        Set<Edge> blockedEdges = new HashSet<>();
        for(Triangular triangular1:triangulars){
            for(Edge edge:triangular1.getEdges()){
                if(!triangular.getTriangular().getEdges().contains(edge))
                    createdEdges.add(edge);
            }
        }
        sureEdges.addAll(createdEdges);
        triangular.setChilds(triangulars);
        //TODO: why the Node in the pair is triangular? should it be some child?
        // are we sure we need to check the new edges? not the existed ?
        edgesToBeChecked.addAll(triangular.getEdges().stream().map(e -> new Pair<>(e,triangular)).collect(Collectors.toList()));
        while (!edgesToBeChecked.isEmpty()) {

        	Pair<Edge,Node> edge = edgesToBeChecked.poll();
        	if(edge.getKey().isExteral()){
                sureEdges.add(edge.getKey());
                continue;
        	}
        	if(sureEdges.contains(edge.getKey()))continue;
            Edge newEdge = swapIfNeeded(edge.getKey(),edge.getValue());
            if (newEdge != null) {
                sureEdges.add(newEdge);
            	Node northNode = newEdge.getNode1();
            	Node southNode = newEdge.getNode2();
            	Set<Pair<Edge,Node>> filteringSet = new HashSet<>();
            	if(northNode!=null)
            	    filteringSet.addAll(northNode.getEdges().stream().map(e->new Pair<>(e,northNode)).collect(Collectors.toList()));
                if(southNode!=null)
                    filteringSet.addAll(southNode.getEdges().stream().map(e->new Pair<>(e,southNode)).collect(Collectors.toList()));
            	for(Edge e:sureEdges){
            	    edgesToBeChecked.removeIf(ed -> ed.equals(e));
                }
            	edgesToBeChecked.addAll(new ArrayList<>(filteringSet));


            }
        }
    }


    private Edge swapIfNeeded(Edge edge,Node source) {
    	Point northPoint = edge.getPoint1();
    	Point southPoint = edge.getPoint2();
    	Node eastNode = edge.getNode1();
        Node westNode = edge.getNode2();
        if(eastNode==null || westNode==null)
            return null;
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
    	if (DrawingBoard.outerPoint(northPoint) || DrawingBoard.outerPoint(eastPoint) || DrawingBoard.outerPoint(southPoint) || DrawingBoard.outerPoint(westPoint) ||
    	        !isInCircle(northPoint, eastPoint, southPoint, westPoint))
    		return null;
        
        Edge newEdge = new Edge(eastPoint, westPoint);
        Node northNode = new Node(new Triangular(newEdge, eastNode.getEdgeByTwoPoints(northPoint, eastPoint), westNode.getEdgeByTwoPoints(northPoint, westPoint)));
        Node southNode = new Node(new Triangular(newEdge, eastNode.getEdgeByTwoPoints(southPoint, eastPoint), westNode.getEdgeByTwoPoints(southPoint, westPoint)));
        edge.getNode1().getChilds().add(northNode);
        edge.getNode1().getChilds().add(southNode);
        edge.getNode2().getChilds().add(northNode);
        edge.getNode2().getChilds().add(southNode);

        return newEdge;
    }

    // Check if point is in circle of the triangular with the following 3 vertices 
    public static boolean isInCircle(Point vertex1, Point vertex2, Point vertex3, Point point) {
        int orientM = orient(vertex1,vertex2,vertex3);
        int detM = Handler.determinantMMatrix(vertex1, vertex2, vertex3, point);
        return orientM * detM < 0;
    }

    private static int orient(Point vertex1, Point vertex2, Point vertex3) {
        int[] r1 = {1, 1, 1};
        int[] r2 = {vertex1.getX(), vertex2.getX(), vertex3.getX()};
        int[] r3 = {vertex1.getY(), vertex2.getY(), vertex3.getY()};
        return Handler.determinant3(r1,r2,r3);

    }

    public List<Triangular> getAllLeafs() {
        return g.getAllLeafs().stream().map(Node::getTriangular).collect(Collectors.toList());
    }


}
