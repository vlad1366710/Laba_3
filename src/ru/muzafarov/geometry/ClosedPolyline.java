package ru.muzafarov.geometry;

/**
 * Класс, представляющий замкнутую ломаную линию.
 */
public class ClosedPolyline extends Polyline {

    /**
     * Создает замкнутую ломаную линию по указанным точкам.
     *
     * @param points Массив точек, образующих ломаную линию.
     * @throws IllegalArgumentException Если массив точек равен null или содержит менее двух точек.
     */
    public ClosedPolyline(Point[] points) {
        super(points);
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("Ломаная линия должна содержать как минимум две точки");
        }
    }

    /**
     * Возвращает длину замкнутой ломаной линии.
     *
     * @return Длина замкнутой ломаной линии.
     */
    @Override
    public double getLength() {
        double length = super.getLength();
        if (getPoints().length > 0) {
            length += calculateDistance(getLastPoint(), getPoints()[0]);
        }
        return length;
    }

    /**
     * Проверяет, является ли ломаная линия замкнутой.
     *
     * @return true, если ломаная линия замкнута, иначе false.
     */
    public boolean isClosed() {
        return getPoints().length > 0 && getPoints()[0].equals(getLastPoint());
    }

    /**
     * Возвращает строковое представление замкнутой ломаной линии.
     *
     * @return Строковое представление замкнутой ломаной линии.
     */
    @Override
    public String toString() {
        return "Замкнутая " + super.toString();
    }

    /**
     * Вычисляет расстояние между двумя точками.
     *
     * @param p1 Первая точка.
     * @param p2 Вторая точка.
     * @return Расстояние между точками.
     */
    public double calculateDistance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}