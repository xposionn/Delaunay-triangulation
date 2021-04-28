import DataSheet.DataContainer;
import Reader.FileLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> data = FileLoader.readFile("D:\\Study\\Computational Geometry\\Delaunay-triangulation\\src\\examples\\input1.txt");
        DataContainer data1 = new DataContainer(data);
    }
}
