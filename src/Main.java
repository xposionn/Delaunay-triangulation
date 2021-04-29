import Algorithm.Delaunay;
import DataSheet.*;
import Printers.DrawingCircleExample;
import Printers.UIPrint;
import Reader.FileLoader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> data = FileLoader.readFile("D:\\Study\\Computational Geometry\\Delaunay-triangulation\\src\\examples\\input1.txt");
        DataContainer data1 = new DataContainer(data);
        System.out.println(data1);

        //First Triangular.
        Edge a = new Edge();
        Edge b = new Edge();
        Edge c = new Edge();
        Triangular triangular = new Triangular(a,b,c);

        Delaunay delaunay = new Delaunay(triangular);
        for(Point point:data1.getListOfPoints()){
            delaunay.insertPoint(point);
        }
        UIPrint.print(delaunay.getAllLeafs());


    }
}
