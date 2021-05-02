package main.java.DataSheet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    Triangular root;

    public Graph(Triangular root) {
        this.root = root;
    }

    public Triangular findTriangular(Point p) {
        Triangular current = root;
        while (!current.isLeaf()) {
            boolean foundChild = false;
            for (Triangular child : current.getChilds()) {
                if (child.isPointInside(p)) {
                    current = child;
                    foundChild = true;
                    break;
                }
            }
            if (!foundChild) {
                System.out.println("Error, couldnt find child.");
            }
        }
        return current;
    }

    public ArrayList<Triangular> getAllLeafs() {
        if (root == null)
            return null;
        ArrayList<Triangular> leafsList = new ArrayList<>();
        Queue<Triangular> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Triangular next = queue.poll();
            if (next.isLeaf())
                leafsList.add(next);
            else
                queue.addAll(next.getChilds());
        }
        return leafsList;
    }
}
