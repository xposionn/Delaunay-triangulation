import Reader.FileLoader;

import java.util.List;

import Algorithm.Delaunay;
import DataSheet.DataContainer;
import DataSheet.Point;
import DataSheet.Triangular;
import Printers.UIPrint;

public class Main {
    public static void main(String[] args) {
//        List<String> data = FileLoader.readFile("C:\\Users\\Partner\\git\\Delaunay-triangulation\\src\\main\\java\\examples\\input1.txt");
        List<String> data = FileLoader.readFile("D:\\Study\\Computational Geometry\\Delaunay-triangulation\\src\\examples\\input1.txt");

        DataContainer data1 = new DataContainer(data);
        data1.shuffle();

        //First Triangular.
        Point a = new Point(0, 0);
        Point b = new Point(10000, 0);
        Point c = new Point(5000, 8660);
        Triangular triangular = new Triangular(a, b, c);
        Delaunay delaunay = new Delaunay(triangular);
        for (Point point : data1.getListOfPoints()) {
            delaunay.insertPoint(point);
        }
        UIPrint.print(delaunay.getAllLeafs());

    }
}
