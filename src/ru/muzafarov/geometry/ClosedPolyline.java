package ru.muzafarov.geometry;

public class ClosedPolyline extends Polyline {

    public ClosedPolyline(Point[] points) {
        super(points);
    }


    @Override
    public double getLength() {
        double length = super.getLength();
        if (getPoints().length > 0) {
            length += calculateDistance(getLastPoint(), getPoints()[0]);
        }
        return length;
    }

    @Override
    public String toString() {
        return "Замкнутая " + super.toString();
    }
}