package Handlers;

import DataSheet.HalfEdge;
import DataSheet.Node;
import DataSheet.Point;
import DataSheet.Triangular;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Handler {
    public static List<Triangular> getTriangularByPoint(Triangular triangular, Point p) {
        //Todo: Create 3 triangulars.

        return new ArrayList<>();
    }

    public List<Triangular> getTriangularFromNodes(List<Node> nodes){
        return nodes.stream().map(Node::getTriangular).collect(Collectors.toList());
    }

}
