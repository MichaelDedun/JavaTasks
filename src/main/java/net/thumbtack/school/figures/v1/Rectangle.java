package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point leftTop, rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.leftTop = new Point(xLeft, yTop);
        this.rightBottom = new Point(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        this.leftTop = new Point(0, -width);
        this.rightBottom = new Point(length, 0);
    }

    public Rectangle() {
        this.leftTop = new Point(0, -1);
        this.rightBottom = new Point(1, 0);
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveTo(int x, int y) {
        rightBottom.moveTo(getLength() + x, getWidth() + y);
        leftTop.moveTo(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        stretch(ratio, ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        rightBottom.setX((int) (getLength() * xRatio + leftTop.getX()));
        rightBottom.setY((int) (getWidth() * yRatio + leftTop.getY()));
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return (getLength() + getWidth()) * 2;
    }

    public boolean isInside(int x, int y) {
        return x <= rightBottom.getX() && x >= leftTop.getX() && y <= rightBottom.getY() && y >= leftTop.getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return Math.max(this.getTopLeft().getX(), rectangle.getTopLeft().getX()) < Math.min(this.getBottomRight().getX(), rectangle.getBottomRight().getX()) && Math.max(this.getTopLeft().getY(), rectangle.getTopLeft().getY()) < Math.min(this.getBottomRight().getY(), rectangle.getBottomRight().getY());
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop) &&
                Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, rightBottom);
    }
}
