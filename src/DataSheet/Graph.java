package DataSheet;

import java.awt.*;
import java.util.ArrayList;

public class Graph {
    Node root;

    public Graph(Triangular root) {
        this.root = new Node(root);
    }

    public Node findTriangular(Point p){
    	Node current = root;
    	while (!current.isLeaf()) {
    		for (Node child : current.getChilds()) {
    			if (child.isPointInside(p)) {
    				current = child;
    				break;
    			}
    		}
    		return null; //should happen if the point outside the external triangular
    	}
        return current;
    }

    public ArrayList<Node> getAllLeafs(){
        return null;
    }
}
