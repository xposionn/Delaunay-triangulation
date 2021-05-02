package main.java;

import main.java.Reader.FileLoader;

import java.util.ArrayList;
import java.util.List;

import main.java.Algorithm.Delaunay;
import main.java.DataSheet.DataContainer;
import main.java.DataSheet.Point;
import main.java.DataSheet.Triangular;
import main.java.Printers.UIPrint;

public class Main {
    public static void main(String[] args) {
        List<String> data = FileLoader.readFile("C:\\Users\\Partner\\git\\Delaunay-triangulation\\src\\main\\java\\examples\\input1.txt");
        DataContainer data1 = new DataContainer(data);
        data1.shuffle();

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
            if(i==30){
            	i=30;
            }
            delaunay.insertPoint(point);
        }
        UIPrint.print(delaunay.getAllLeafs());

    }
}
