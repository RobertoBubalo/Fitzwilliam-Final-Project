package com.robertobubalo;
//By Roberto Bubalo 9.8.2017


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DrawFrame extends JFrame {


    BorderLayout b = new BorderLayout();    // complete borderlayout
    JLabel statusBar = new JLabel();        // Status bar Jlabel
    JPanel mainPanel = new JPanel();        // panel where all the magic happens :)
    JPanel northPanel = new JPanel();       // north panel for the buttons
    DrawPanel panel = new DrawPanel(statusBar);     //making panel DrawPanel class

    // string arrays to fill up combo boxes
    String[] colorNames = new String[]{"Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink",
            "Magenta", "Teal", "Gray", "Brown", "Gold", "Silver"};
    String[] shapeTypes = new String[]{"Line", "Rectangle", "Oval"};

    // all buttons
    JButton undo = new JButton("Undo");
    JButton clear = new JButton("Clear");
    JComboBox color = new JComboBox(colorNames);
    JComboBox shape = new JComboBox(shapeTypes);
    JCheckBox filled = new JCheckBox("Filled");

    public DrawFrame() throws HeadlessException {
        add(mainPanel);
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel.setLayout(b);

        // change listener for the shape combo box
        shape.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // switch statement for choosing shape type
                switch ((String) shape.getSelectedItem()) {
                    case "Line":
                        panel.setShapeType(0);
                        break;
                    case "Rectangle":
                        panel.setShapeType(1);
                        break;
                    case "Oval":
                        panel.shapeType = 2;
                        break;
                }
            }
        });
        // change listener for the check box
        filled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filled.isSelected()) {
                    panel.setFilledShape(true);
                } else {
                    panel.setFilledShape(false);
                }

            }
        });
        // change listener for the color combo box
        color.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch ((String) color.getSelectedItem()) {
                    case "Black":
                        panel.setCurrentColor(Color.BLACK);
                        break;
                    case "Red":
                        panel.setCurrentColor(Color.RED);
                        break;
                    case "Blue":
                        panel.setCurrentColor(Color.BLUE);
                        break;
                    case "Green":
                        panel.setCurrentColor(Color.GREEN);
                        break;
                    case "Yellow":
                        panel.setCurrentColor(Color.YELLOW);
                        break;
                    case "Orange":
                        panel.setCurrentColor(Color.ORANGE);
                        break;
                    case "Pink":
                        panel.setCurrentColor(Color.PINK);
                        break;
                    case "Magneta":
                        panel.setCurrentColor(Color.MAGENTA);
                        break;
                    case "Teal":
                        panel.setCurrentColor(new Color(0, 128, 128));
                        break;
                    case "Gray":
                        panel.setCurrentColor(Color.GRAY);
                        break;
                    case "Gold":
                        panel.setCurrentColor(new Color(255, 215, 0));
                        break;
                    case "Silver":
                        panel.setCurrentColor(new Color(192, 192, 192));
                        break;

                }
            }
        });
        // action listener for undo button
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearLastShape();
            }
        });
        // action listener for clear button
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearDrawing();
                panel.validate();
                panel.repaint();
            }
        });


        // Adding all the stuff to the north panel
        northPanel.add(undo);
        northPanel.add(clear);
        northPanel.add(color);
        northPanel.add(shape);
        northPanel.add(filled);

        // Adding all components to the main panel
        mainPanel.add(statusBar, BorderLayout.SOUTH);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.CENTER);


        setVisible(true);
    }

}
