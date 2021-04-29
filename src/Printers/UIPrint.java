package Printers;

import Algorithm.Delaunay;
import DataSheet.Edge;
import DataSheet.HalfEdge;
import DataSheet.Triangular;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UIPrint {
    public static void print(List<Triangular> triangulars){
        Set<Edge> set = new HashSet<>();
        for(Triangular t:triangulars){
            set.addAll(t.getAllEdges());
        }

        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new DrawingCircleExample().displayGUI (set);
            }
        };
        EventQueue.invokeLater ( runnable );

    }
}
