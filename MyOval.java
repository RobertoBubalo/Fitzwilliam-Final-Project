package com.robertobubalo;
//By Roberto Bubalo 1.8.2017

import java.awt.*;

/**
 * Created by rober on 15/07/2017.
 */
public class MyOval extends  MyBoundedShape{

    // inherited empty constructor default all 0 values and black color
    public MyOval(){
        super();
    }

    // inherited constructor with all the arguments and setting the flag
    public MyOval(int x1, int y1, int x2, int y2, Color color, Boolean flag) {
        super(x1, y1, x2, y2, color, flag);
    }

    //overriden draw method
    @Override
    public void draw( Graphics g )
    {
        g.setColor( getColor() );

        if( getFlag() == true){ // checking the flag boolean for filled property
            g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()  );
        }else
            g.drawOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()  );

    }
}
