package ru.muzafarov.main;

import ru.muzafarov.geometry.GeometryService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class LengthCalculator {

    /**
     * Вычисляет общую длину для массива геометрических объектов.
     *
     * @param items Массив объектов, реализующих интерфейс GeometryService.
     * @return Общая длина всех объектов.
     * @throws IllegalArgumentException Если массив равен null.
     */
    public static double calculateTotalLength(GeometryService[] items) {
        Objects.requireNonNull(items, "Массив не может быть null");
        return calculateTotalLength(Arrays.asList(items));
    }

    /**
     * Вычисляет общую длину для коллекции геометрических объектов.
     *
     * @param items Коллекция объектов, реализующих интерфейс GeometryService.
     * @return Общая длина всех объектов.
     * @throws IllegalArgumentException Если коллекция равна null.
     */
    public static double calculateTotalLength(Collection<GeometryService> items) {
        Objects.requireNonNull(items, "Коллекция не может быть null");
        return items.stream()
                .mapToDouble(GeometryService::getLength)
                .sum();
    }

    /**
     * Вычисляет общую длину для итерируемых геометрических объектов.
     *
     * @param items Итерируемый объект, содержащий элементы, реализующие интерфейс GeometryService.
     * @return Общая длина всех объектов.
     * @throws IllegalArgumentException Если итерируемый объект равен null.
     */
    public static double calculateTotalLength(Iterable<GeometryService> items) {
        Objects.requireNonNull(items, "Итерируемый объект не может быть null");
        double totalLength = 0.0;
        for (GeometryService item : items) {
            totalLength += item.getLength();
        }
        return totalLength;
    }
}