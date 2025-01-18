package ru.muzafarov.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolygonalChainMerger {
    public static Polyline mergePolygonalChains(List<GeometryService> chains) {
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
