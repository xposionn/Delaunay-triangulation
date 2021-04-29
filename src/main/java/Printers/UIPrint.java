package Printers;

import DataSheet.Edge;
import DataSheet.Triangular;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UIPrint {
    public static void print(List<Triangular> triangulars){
        Set<Edge> set = new HashSet<>();
        for(Triangular t:triangulars){
            set.addAll(t.getEdges());
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
