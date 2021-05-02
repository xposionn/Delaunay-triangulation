package main.java.Printers;

import main.java.DataSheet.Edge;
import main.java.DataSheet.Triangular;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UIPrint {
    public static void print(List<Triangular> triangulars){
        Set<Triangular> set = new HashSet<>(triangulars);

        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new DrawingCircleExample().displayGUI (set);
            }
        };
        EventQueue.invokeLater ( runnable );

    }
}
