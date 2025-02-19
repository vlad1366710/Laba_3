package ru.muzafarov.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для объединения ломаных линий.
 */
public class PolygonalChainMerger {

    /**
     * Объединяет ломаные линии в одну.
     *
     * @param chains Список ломаных линий.
     * @return Объединенная ломаная линия.
     * @throws IllegalArgumentException Если список равен null.
     */
    public static Polyline mergePolygonalChains(List<GeometryService> chains) {
        if (chains == null) {
            throw new IllegalArgumentException("Список ломаных линий не может быть null");
        }

        List<Point> allPoints = new ArrayList<>();

        for (GeometryService chain : chains) {
            Polyline polyline = chain.getPolyline();
            for (Point point : polyline.getPoints()) {
                allPoints.add(point);
            }
        }

        return new Polyline(allPoints.toArray(new Point[0]));
    }
}