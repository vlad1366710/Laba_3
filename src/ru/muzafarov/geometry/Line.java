package ru.muzafarov.geometry;

public class Line implements GeometryService {
    private Point start;
    private Point end;


    public Line (Point start, Point end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public double getLength() {
        return calculateDistance(start, end);
    }


    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public String toString() {
        return "Линия начало " + start + " конец " + end + " длина " + getLength();
    }
    @Override
    public Polyline getPolyline() {
        return new Polyline(new Point[]{start, end});
    }
}