package ru.muzafarov.main;

import ru.muzafarov.geometry.GeometryService;


public class LengthCalculator {
    public static double calculateTotalLength(GeometryService[] items) {
        double totalLength = 0.0;
        for (GeometryService item : items) {
            totalLength += item.getLength();
        }
        return totalLength;
    }
}