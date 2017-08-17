package com.robertobubalo;
//By Roberto Bubalo 9.8.2017

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel {

    // All the necessary variables
    public MyShape arrayShapes[];
    public int shapeCount;
    public int shapeType;
    public MyShape currentShape;
    public Color currentColor;
    public boolean filledShape;
    public JLabel statusLabel;



    // DrawPanel constructor
    public DrawPanel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
        arrayShapes = new MyShape[100];
        shapeCount = 0;
        shapeType = 0;
        currentShape = null;
        currentColor = Color.BLACK;
        setBackground(Color.WHITE);

        // adding and registering mouse listener and mouse adapter
        MouseActions m = new MouseActions();
        addMouseListener(m);
        addMouseMotionListener(m);
    }

    public class MouseActions extends MouseAdapter implements MouseMotionListener{
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            // switch statement to determine which shape to draw
            switch(shapeType){
                case 0:
                    currentShape = new MyLine();
                    break;
                case 1:
                    currentShape = new MyRect();
                    break;
                case 2:
                    currentShape = new MyOval();
                    break;
            }
            // getting the mouse pressed coords to current shape x and y
            currentShape.setX1(e.getX());
            currentShape.setY1(e.getY());



        }

        // after the mouse released the shape is added into array and shape count is increased
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            currentShape.setX2(e.getX());       // setting x
            currentShape.setY2(e.getY());       // setting y
            currentShape.setColor(currentColor);    // setting color


            // loop determine when to add a shape and which one to the array
            for (int i = 0; i <= shapeCount; i++)
            {
                try{
                    if ( i == shapeCount && shapeType == 0){
                        arrayShapes[i] = new MyLine(currentShape.getX1(),currentShape.getY1(),currentShape.getX2(),currentShape.getY2(),currentShape.getColor());
                    }else if(i == shapeCount && shapeType == 1){
                        arrayShapes[i] = new MyRect(currentShape.getX1(),currentShape.getY1(),currentShape.getX2(),currentShape.getY2(),currentShape.getColor(), filledShape);
                    }else if(i == shapeCount && shapeType == 2){
                        arrayShapes[i] = new MyOval(currentShape.getX1(),currentShape.getY1(),currentShape.getX2(),currentShape.getY2(),currentShape.getColor(), filledShape);
                    }
                }catch (Exception a){
                    System.out.println("There has been an error" + a);
                }

            }

            // increase shape count, reset currentShape and repaint
            shapeCount++;
            currentShape = null;
            repaint();

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            currentShape.setColor(currentColor);
            // loop to show user current shape drawn without increasing the shapecount
            for (int i = 0; i <= shapeCount; i++)
            {
                try{
                    if ( i == shapeCount && shapeType == 0){
                        arrayShapes[i] = new MyLine(currentShape.getX1(),currentShape.getY1(),currentShape.getX2(),currentShape.getY2(),currentShape.getColor());
                    }else if(i == shapeCount && shapeType == 1){
                        arrayShapes[i] = new MyRect(currentShape.getX1(),currentShape.getY1(),currentShape.getX2(),currentShape.getY2(),currentShape.getColor(), filledShape);
                    }else if(i == shapeCount && shapeType == 2){
                        arrayShapes[i] = new MyOval(currentShape.getX1(),currentShape.getY1(),currentShape.getX2(),currentShape.getY2(),currentShape.getColor(), filledShape);
                    }
                }catch (Exception b){
                    System.out.println("There has been an error" +b);
                }

            }

            // repaint and set statusLabel proper coords
            repaint();
            statusLabel.setText("(" + e.getX() + "," + e.getY() + ")");
        }

        // simple statuslabel update
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            statusLabel.setText("(" + e.getX() + "," + e.getY() + ")");
        }
    }



        // necessary set methods
    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }


    // method to clear last shape, decrementing shapecount value and deleting last entry in array
    // calling repaint to refresh screen
    public void clearLastShape(){
        if(shapeCount>0){
            for ( int i = 0; i < arrayShapes.length; i ++){
                arrayShapes[shapeCount-1] = null;
            }
            shapeCount--;
        }
        repaint();

    }


    // method to clear drawing, setting shapecount to 0 and emptying the array
    // calling repaint to refresh screen
    public void clearDrawing(){
        shapeCount = 0;
        for ( int i = 0; i < arrayShapes.length; i ++){
            arrayShapes[i] = null;
        }
        this.repaint();


    }


    @Override
    // for each shape array, draw the individual shapes
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        try{
            // go through myShape array and draw needed shape using polymorphism
            for (MyShape myShape : arrayShapes){
                // checking if the element in array is null
                if(myShape != null ){
                    myShape.draw( g );
                }
            }

        }catch (Exception e){
            System.out.println("There has been an error" + e);
        }

    } // end method
}
