package Printers;

import DataSheet.Edge;
import Printers.DrawingBoard;

import java.awt.*;
import java.awt.event.*;
import java.util.Set;
import javax.swing.*;

public class DrawingCircleExample {

    private JPanel drawingBoard;

    private static final int GAP = 5;

    public void displayGUI(Set<Edge> edgeList) {
        JFrame frame = new JFrame ( "" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = new JPanel ();
        contentPane.setLayout ( new BorderLayout ( GAP, GAP ) );
        drawingBoard = new DrawingBoard(edgeList);
        contentPane.add ( drawingBoard, BorderLayout.CENTER );
        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

}