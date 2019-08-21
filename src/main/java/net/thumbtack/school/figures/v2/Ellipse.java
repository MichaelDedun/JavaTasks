package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Stretchable;

import java.util.Objects;

public class Ellipse extends Figure implements Stretchable {
    private Point center;
    private int xAxis, yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xAxis, int yAxis) {
        this.center = new Point(0, 0);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse() {
        this.center = new Point(0, 0);
        this.xAxis = 1;
        this.yAxis = 1;
    }

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }


    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        stretch(ratio, ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis = (int) (getXAxis() * xRatio);
        yAxis = (int) (getYAxis() * yRatio);
    }

    public double getArea() {
        return Math.PI * getXAxis() / 2 * getYAxis() / 2;
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt(Math.pow(xAxis, 2) / 8 + Math.pow(yAxis, 2) / 8);
    }

    public boolean isInside(int x, int y) {
        return Math.pow(center.getX() - x, 2) / Math.pow(xAxis / 2, 2) + Math.pow(center.getY() - y, 2) / Math.pow(yAxis / 2, 2) <= 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}
