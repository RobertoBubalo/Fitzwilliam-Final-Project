package com.robertobubalo;
//By Roberto Bubalo 9.8.2017


import java.awt.*;

public abstract class MyBoundedShape extends MyShape {
    private Boolean flag;


    // inherited empty constructor default all 0 values and black color
    public MyBoundedShape() {
        super();
        setFlag(false);
    }
    // inherited constructor with all the arguments and setting the flag
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, Boolean flag) {
        super(x1, y1, x2, y2, color);
        setFlag(flag);
    }

    // all of the override getters and setters with addition of flag one
    @Override
    public int getX1() {
        return super.getX1();
    }

    @Override
    public void setX1(int x1) {
        super.setX1(x1);
    }

    @Override
    public int getY1() {
        return super.getY1();
    }

    @Override
    public void setY1(int y1) {
        super.setY1(y1);
    }

    @Override
    public int getX2() {
        return super.getX2();
    }

    @Override
    public void setX2(int x2) {
        super.setX2(x2);
    }

    @Override
    public int getY2() {
        return super.getY2();
    }

    @Override
    public void setY2(int y2) {
        super.setY2(y2);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }

    @Override
    public void draw(Graphics g) {
    }


    // flag getter
    public Boolean getFlag() {
        return flag;
    }
    // flag setter
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    // getters and setters finish


    // checking which X coordinate is smaller and returning it
    // used for determining which value to use for drawing the shapes
    public int getUpperLeftX() {
        if (getX1() > getX2()){
            return getX2();
        }else{
            return getX1();
        }
    }
    // checking which Y coordinate is smaller and returning it
    // used for determining which value to use for drawing the shapes
    public int getUpperLeftY(){
        if(getY1() > getY2()){
            return getY2();
        }else{
            return getY1();
        }
    }
    // getting absolute X value
    public int getWidth(){
        if( getX1()> getX2()){
            return Math.abs(getX2()-getX1());
        }else{
            return Math.abs(getX1()-getX2());
        }

    }
    // getting absolute Y value
    public int getHeight(){
        if (getY1()>getY2()){
            return Math.abs(getY2()-getY1());
        }else{
            return Math.abs(getY1()-getY2());
        }
    }

}
