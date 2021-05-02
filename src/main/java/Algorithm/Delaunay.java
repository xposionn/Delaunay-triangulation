package Algorithm;

import DataSheet.*;
import Handlers.Handler;

import java.util.*;

public class Delaunay {
    Graph g;


    public Delaunay(Triangular t) {
        g = new Graph(t);
    }

    public void insertPoint(Point p) {
        Triangular triangular = g.findTriangular(p);
        List<Triangular> triangulars = Handler.getTriangularsByPoint(triangular, p);
        triangular.setChilds(triangulars);

        swapIfNeeded(triangulars.get(0),triangular.getEdgeAb(),p);
        swapIfNeeded(triangulars.get(1),triangular.getEdgeBc(),p);
        swapIfNeeded(triangulars.get(2),triangular.getEdgeCa(),p);


    }


    private void swapIfNeeded(Triangular eastTriangular, Edge edge, Point eastPoint) {
        Triangular westTriangular = eastTriangular.getOtherTriangular(edge);
        if(westTriangular==null)
            return;
        Point westPoint = westTriangular.getOppositePoint(edge);
        if(isInCircle(edge.getPoint1(), eastPoint,edge.getPoint2(), westPoint)) {
            Triangular northTriangular = new Triangular(westPoint, edge.getPoint1(), eastPoint);
            Triangular southTriangular = new Triangular(westPoint, edge.getPoint2(), eastPoint);
            eastTriangular.getChilds().add(northTriangular);
            eastTriangular.getChilds().add(southTriangular);

            westTriangular.getChilds().add(northTriangular);
            westTriangular.getChilds().add(southTriangular);

            Edge northeast = new Edge(edge.getPoint1(),eastPoint);
            Edge northwest = new Edge(edge.getPoint1(),westPoint);
            Edge southeast = new Edge(edge.getPoint2(),eastPoint);
            Edge southwest = new Edge(edge.getPoint2(),westPoint);



            Handler.makeNeighbors(northTriangular,southTriangular,new Edge(westPoint,eastPoint));

            Handler.makeNeighbors(northTriangular,eastTriangular.getOtherTriangular(northeast),northeast);
            Handler.makeNeighbors(northTriangular,westTriangular.getOtherTriangular(northwest),northwest);
            Handler.makeNeighbors(southTriangular,eastTriangular.getOtherTriangular(southeast),southeast);
            Handler.makeNeighbors(southTriangular,westTriangular.getOtherTriangular(southwest),southwest);

            swapIfNeeded(westTriangular,northwest,edge.getPoint2());
            swapIfNeeded(westTriangular,southwest,edge.getPoint1());



        }

    }

    // Check if point is in circle of the triangular with the following 3 vertices 
    public static boolean isInCircle(Point vertex1, Point vertex2, Point vertex3, Point point) {
        int orientM = orient(vertex1, vertex2, vertex3);
        int detM = Handler.determinantMMatrix(vertex1, vertex2, vertex3, point);
        return orientM * detM < 0;
    }

    private static int orient(Point vertex1, Point vertex2, Point vertex3) {
        int[] r1 = {1, 1, 1};
        int[] r2 = {vertex1.getX(), vertex2.getX(), vertex3.getX()};
        int[] r3 = {vertex1.getY(), vertex2.getY(), vertex3.getY()};
        return Handler.determinant3(r1, r2, r3);

    }

    public List<Triangular> getAllLeafs() {
        return g.getAllLeafs();
    }


}
