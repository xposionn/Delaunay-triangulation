package DataSheet;

import java.util.ArrayList;
import java.util.List;

public class DataContainer {
    List<Point> listOfPoints;

    public DataContainer(List<String> points){
        listOfPoints = new ArrayList<>();
        for(int i=1;i<points.size();i=i+2){
            int x = Integer.parseInt(points.get(i));
            int y = Integer.parseInt(points.get(i+1));
            listOfPoints.add(new Point(x,y));
        }
    }

    public List<Point> getListOfPoints() {
        return listOfPoints;
    }
}
