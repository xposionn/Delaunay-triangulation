import Algorithm.Delaunay;
import DataSheet.*;
import Printers.DrawingCircleExample;
import Printers.UIPrint;
import Reader.FileLoader;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> data = FileLoader.readFile("D:\\Study\\Computational Geometry\\Delaunay-triangulation\\src\\main\\java\\examples\\input1.txt");
        DataContainer data1 = new DataContainer(data);
//        data1.shuffle();

        //First Triangular.
        Edge a = new Edge(new Point(0, 0), new Point(10000, 0));
        Edge b = new Edge(new Point(10000, 0), new Point(5000, 8660));
        Edge c = new Edge(new Point(5000, 8660), new Point(0, 0));
        Triangular triangular = new Triangular(a, b, c);
        Node root = new Node(triangular);
        a.setTriangular1(root);
        b.setTriangular1(root);
        c.setTriangular1(root);

        Delaunay delaunay = new Delaunay(triangular);
        int i = 0;
        for (Point point : data1.getListOfPoints()) {
            i++;
            delaunay.insertPoint(point);
//            if (i == 3) {
//                break;
//            }



        }
        UIPrint.print(delaunay.getAllLeafs());

    }
}
