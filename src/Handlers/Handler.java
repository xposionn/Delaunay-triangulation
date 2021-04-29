package Handlers;

import DataSheet.Edge;
import DataSheet.Node;
import DataSheet.Point;
import DataSheet.Triangular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Handler {
    public static List<Triangular> getTriangularsByPoint(Triangular triangular, Point p) {
        List<Point> points = triangular.getPoints();

        List<Triangular> triangulars = new ArrayList<>();
        Triangular triangular0;
        Triangular triangular1;
        Triangular triangular2;

        List<Edge> edges = triangular.getEdges();
        Point cutPoint01 = Handler.getCutPoint(edges.get(0),edges.get(1));
        Point cutPoint02 = Handler.getCutPoint(edges.get(0),edges.get(2));
        Point cutPoint12 = Handler.getCutPoint(edges.get(1),edges.get(2));

        Edge a = new Edge(p, cutPoint01);
        Edge b = new Edge(p, cutPoint02);
        Edge c = new Edge(p, cutPoint12);

        triangular0 = new Triangular(a,b,edges.get(0));
        triangular1 = new Triangular(a,c,edges.get(1));
        triangular2 = new Triangular(b,c,edges.get(2));

        a.setTriangular1(triangular0);
        a.setTriangular2(triangular1);
        b.setTriangular1(triangular0);
        b.setTriangular2(triangular2);
        c.setTriangular1(triangular1);
        c.setTriangular2(triangular2);

        edges.get(0).replace(triangular,triangular0);
        edges.get(1).replace(triangular,triangular1);
        edges.get(2).replace(triangular,triangular2);

        return new ArrayList<>(Arrays.asList(triangular0,triangular1,triangular2));



    }

    //Todo: get the shared point.
    private static Point getCutPoint(Edge a, Edge b) {
        return null;
    }

    public List<Triangular> getTriangularFromNodes(List<Node> nodes) {
        return nodes.stream().map(Node::getTriangular).collect(Collectors.toList());
    }

}
