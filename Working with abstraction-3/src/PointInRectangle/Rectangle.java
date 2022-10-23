package PointInRectangle;

public class Rectangle {
    private Point A;
    private Point C;

    public Rectangle(Point A, Point C) {
        this.A = A;
        this.C = C;
    }
    public boolean contains(Point X){
            if (X.getX()>= getA().getX()&&X.getY()>=getA().getY()&&X.getX()<=getC().getX()&&X.getY()<=getC().getY()){
                return true;
            }
        return false;
    }

    public Point getA() {
        return A;
    }

    public Point getC() {
        return C;
    }
}
