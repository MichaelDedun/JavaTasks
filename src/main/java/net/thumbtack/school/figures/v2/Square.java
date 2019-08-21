package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Square extends Figure {
    private Point leftTop;
    private int size;

    public Square(Point leftTop, int size) {
        this.leftTop = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.leftTop = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        this.leftTop = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this.leftTop = new Point(0, -1);
        this.size = 1;
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return new Point(getTopLeft().getX() + size, getTopLeft().getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.leftTop = topLeft;
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        leftTop.moveTo(x, y);
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        size = (int) (size * ratio);
    }

    public double getArea() {
        return getLength() * getLength();
    }

    public double getPerimeter() {
        return getLength() * 4;
    }

    public boolean isInside(int x, int y) {
        return x <= getBottomRight().getX() && x >= leftTop.getX() && y <= getBottomRight().getY() && y >= leftTop.getY();
    }


    public boolean isIntersects(Square square) {
        return Math.max(this.getTopLeft().getX(), square.getTopLeft().getX()) <= Math.min(this.getBottomRight().getX(), square.getBottomRight().getX())
                && Math.max(this.getTopLeft().getY(), square.getTopLeft().getY()) <= Math.min(this.getBottomRight().getY(), square.getBottomRight().getY());
    }

    public boolean isInside(Square square) {
        return isInside(square.getBottomRight()) && isInside(square.getTopLeft());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size &&
                Objects.equals(leftTop, square.leftTop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftTop, size);
    }
}
