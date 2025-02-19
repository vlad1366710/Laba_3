package ru.muzafarov.geometry;

/**
 * Класс, представляющий ломаную линию.
 */
public class Polyline implements GeometryService {

    private Point[] points;

    /**
     * Создает ломаную линию по массиву точек.
     *
     * @param points Массив точек.
     * @throws IllegalArgumentException Если массив точек равен null.
     */
    public Polyline(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Массив точек не может быть null");
        }
        this.points = points;
    }

    /**
     * Создает пустую ломаную линию.
     */
    public Polyline() {
        this.points = new Point[0];
    }

    /**
     * Возвращает последнюю точку ломаной линии.
     *
     * @return Последняя точка.
     * @throws IllegalStateException Если ломаная линия пуста.
     */
    public Point getLastPoint() {
        if (points.length == 0) {
            throw new IllegalStateException("Ломаная линия пуста");
        }
        return points[points.length - 1];
    }

    /**
     * Возвращает строковое представление ломаной линии.
     *
     * @return Строковое представление.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ломаная линия: [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Возвращает массив точек ломаной линии.
     *
     * @return Массив точек.
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * Возвращает длину ломаной линии.
     *
     * @return Длина ломаной линии.
     */
    @Override
    public double getLength() {
        double length = 0.0;
        for (int i = 0; i < points.length - 1; i++) {
            length += calculateDistance(points[i], points[i + 1]);
        }
        return length;
    }

    /**
     * Вычисляет расстояние между двумя точками.
     *
     * @param p1 Первая точка.
     * @param p2 Вторая точка.
     * @return Расстояние между точками.
     */
    protected double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /**
     * Сравнивает эту ломаную линию с другим объектом.
     *
     * @param obj Объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Polyline)) return false;
        Polyline other = (Polyline) obj;
        if (this.points.length != other.points.length) return false;
        for (int i = 0; i < this.points.length; i++) {
            if (!this.points[i].equals(other.points[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает ломаную линию.
     *
     * @return Ломаная линия.
     */
    @Override
    public Polyline getPolyline() {
        return this;
    }
}