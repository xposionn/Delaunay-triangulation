package Algorithm;

import DataSheet.*;
import Handlers.Handler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Delaunay {
        Graph g;
        Queue<HalfEdge> edgesToBeChecked;


    public Delaunay(Triangular t){
        Graph g = new Graph(t);
        edgesToBeChecked = new LinkedList<>();
    }

    public void insertPoint(Point p){
        Node t = g.findTriangular(p);
        Triangular triangular = t.getTriangular();
        List<Triangular> triangulars = Handler.getTriangularByPoint(triangular,p);
        for(Triangular triangularToCheck:triangulars){
            //Todo: insert to the list the edges which needs to be checked.
//            edgesToBeChecked.add()


        }
        while(!edgesToBeChecked.isEmpty()){
            HalfEdge edge = edgesToBeChecked.poll();
            swapIfNeeded(edge);

        }




    }



    private void swapIfNeeded(HalfEdge edge) {
        if(swapIsNeeded(edge)){
            //Todo:add the new edges.
//            edgesToBeChecked.add()
//            edgesToBeChecked.add()
        }
    }

    private boolean swapIsNeeded(HalfEdge edge) {
        //Todo: check if swap is needed
        return true;
    }

    public List<Triangular> getAllLeafs(){
        return g.getAllLeafs().stream().map(node-> node.getTriangular()).collect(Collectors.toList());
    }


}
