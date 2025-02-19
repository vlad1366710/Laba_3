package ru.muzafarov.geometry;

/**
 * Класс, представляющий линию между двумя точками.
 */
public class Line implements GeometryService {
    private Point start;
    private Point end;

    /**
     * Создает линию по двум точкам.
     *
     * @param start Начальная точка линии.
     * @param end   Конечная точка линии.
     * @throws IllegalArgumentException Если одна из точек равна null.
     */
    public Line(Point start, Point end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Точки не могут быть null");
        }
        this.start = start;
        this.end = end;
    }

    /**
     * Возвращает длину линии.
     *
     * @return Длина линии.
     */
    @Override
    public double getLength() {
        return calculateDistance(start, end);
    }

    /**
     * Вычисляет расстояние между двумя точками.
     *
     * @param p1 Первая точка.
     * @param p2 Вторая точка.
     * @return Расстояние между точками.
     */
    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /**
     * Возвращает строковое представление линии.
     *
     * @return Строковое представление линии.
     */
    @Override
    public String toString() {
        return "Линия: начало " + start + ", конец " + end + ", длина " + getLength();
    }

    /**
     * Возвращает ломаную линию, состоящую из этой линии.
     *
     * @return Ломаная линия.
     */
    @Override
    public Polyline getPolyline() {
        return new Polyline(new Point[]{start, end});
    }
}