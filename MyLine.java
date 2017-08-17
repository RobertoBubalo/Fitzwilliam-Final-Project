package com.robertobubalo;
//By Roberto Bubalo 1.8.2017


        import java.awt.Color;
        import java.awt.Graphics;

public class MyLine extends MyShape{

    public MyLine() {
        super();
    }

    // constructor with input values
    public MyLine( int x1, int y1, int x2, int y2, Color color )
    {
        super(x1, y1, x2, y2, color);
    } // end MyLine constructor

    // Actually draws the line
    @Override
    public void draw(Graphics g )
    {
        g.setColor( getColor() );
        g.drawLine( getX1(), getY1(), getX2(), getY2() );
    } // end method
}
