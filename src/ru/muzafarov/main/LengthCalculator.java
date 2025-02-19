package ru.muzafarov.main;

import ru.muzafarov.geometry.GeometryService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class LengthCalculator {

    /**
     * ��������� ����� ����� ��� ������� �������������� ��������.
     *
     * @param items ������ ��������, ����������� ��������� GeometryService.
     * @return ����� ����� ���� ��������.
     * @throws IllegalArgumentException ���� ������ ����� null.
     */
    public static double calculateTotalLength(GeometryService[] items) {
        Objects.requireNonNull(items, "������ �� ����� ���� null");
        return calculateTotalLength(Arrays.asList(items));
    }

    /**
     * ��������� ����� ����� ��� ��������� �������������� ��������.
     *
     * @param items ��������� ��������, ����������� ��������� GeometryService.
     * @return ����� ����� ���� ��������.
     * @throws IllegalArgumentException ���� ��������� ����� null.
     */
    public static double calculateTotalLength(Collection<GeometryService> items) {
        Objects.requireNonNull(items, "��������� �� ����� ���� null");
        return items.stream()
                .mapToDouble(GeometryService::getLength)
                .sum();
    }

    /**
     * ��������� ����� ����� ��� ����������� �������������� ��������.
     *
     * @param items ����������� ������, ���������� ��������, ����������� ��������� GeometryService.
     * @return ����� ����� ���� ��������.
     * @throws IllegalArgumentException ���� ����������� ������ ����� null.
     */
    public static double calculateTotalLength(Iterable<GeometryService> items) {
        Objects.requireNonNull(items, "����������� ������ �� ����� ���� null");
        double totalLength = 0.0;
        for (GeometryService item : items) {
            totalLength += item.getLength();
        }
        return totalLength;
    }
}