package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.HasArea;
import net.thumbtack.school.iface.v2.Movable;
import net.thumbtack.school.iface.v2.Resizable;

public abstract class Figure implements HasArea, Movable, Resizable {

    public abstract void moveTo(int x, int y);

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public abstract void moveRel(int dx, int dy);

    public abstract void resize(double ratio);

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean isInside(int x, int y);


    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
}