package ru.muzafarov.geometry;

import java.util.Objects;

/**
 * Класс, представляющий точку в двумерном пространстве с возможностью клонирования.
 */
public class CloningPoint implements Cloneable {
    private double x;
    private double y;

    /**
     * Создает точку с указанными координатами.
     *
     * @param x Координата X.
     * @param y Координата Y.
     */
    public CloningPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату X точки.
     *
     * @return Координата X.
     */
    public double getX() {
        return x;
    }

    /**
     * Устанавливает координату X точки.
     *
     * @param x Новая координата X.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Возвращает координату Y точки.
     *
     * @return Координата Y.
     */
    public double getY() {
        return y;
    }

    /**
     * Устанавливает координату Y точки.
     *
     * @param y Новая координата Y.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Сдвигает точку на указанные значения по осям X и Y.
     *
     * @param deltaX Сдвиг по оси X.
     * @param deltaY Сдвиг по оси Y.
     */
    public void shift(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Вычисляет расстояние до другой точки.
     *
     * @param other Другая точка.
     * @return Расстояние до другой точки.
     * @throws IllegalArgumentException Если другая точка равна null.
     */
    public double distanceTo(CloningPoint other) {
        if (other == null) {
            throw new IllegalArgumentException("Другая точка не может быть null");
        }
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Возвращает строковое представление точки.
     *
     * @return Строковое представление точки в формате "{x;y}".
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Сравнивает эту точку с другим объектом.
     *
     * @param obj Объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CloningPoint other = (CloningPoint) obj;
        return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0;
    }

    /**
     * Возвращает хэш-код точки.
     *
     * @return Хэш-код точки.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Создает и возвращает копию этой точки.
     *
     * @return Копия этой точки.
     * @throws CloneNotSupportedException Если клонирование не поддерживается.
     */
    @Override
    public CloningPoint clone() throws CloneNotSupportedException {
        return (CloningPoint) super.clone();
    }
}