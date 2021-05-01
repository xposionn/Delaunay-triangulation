package DataSheet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    Node root;

    public Graph(Triangular root) {
        this.root = new Node(root);
    }

    public Node findTriangular(Point p){
    	Node current = root;
    	boolean found = false;
    	while (!current.isLeaf()) {
			for (Node child : current.getChilds()) {
				if (child.isPointInside(p)) {
					current = child;
					if (current.isLeaf()) {
						found = true;
					}
					break;
				}
			}
		}
		if(current!=root && !found)
			return null; //should happen if the point outside the external triangular
        return current;
    }

    public ArrayList<Node> getAllLeafs(){
    	if (root == null)
    		return null;
        ArrayList<Node> leafsList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
        	Node next = queue.poll();
        	if (next.isLeaf())
        		leafsList.add(next);
        	else
        		queue.addAll(next.getChilds());
        }
    	return leafsList;
    }
}
