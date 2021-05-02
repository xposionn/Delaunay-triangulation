import Algorithm.Delaunay;
import DataSheet.*;
import Printers.UIPrint;
import Reader.FileLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> data = FileLoader.readFile("D:\\Study\\Computational Geometry\\Delaunay-triangulation\\src\\main\\java\\examples\\input1.txt");
        DataContainer data1 = new DataContainer(data);
//        data1.shuffle();

        //First Triangular.
        Point a = new Point(0, 0);
        Point b = new Point(10000, 0);
        Point c = new Point(5000, 8660);
        Triangular triangular = new Triangular(a, b, c);
        Delaunay delaunay = new Delaunay(triangular);
        int i = 0;
        for (Point point : data1.getListOfPoints()) {
            i++;
            System.out.println("insert point: "+point);
            delaunay.insertPoint(point);
            if(i==2){
                break;
            }




        }
        UIPrint.print(delaunay.getAllLeafs());

    }
}
