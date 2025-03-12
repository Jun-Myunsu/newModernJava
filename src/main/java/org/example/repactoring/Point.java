package org.example.repactoring;

public class Point {
    private int x;
    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }
}
