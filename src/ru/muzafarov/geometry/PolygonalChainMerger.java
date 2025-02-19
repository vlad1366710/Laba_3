package ru.muzafarov.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * ����� ��� ����������� ������� �����.
 */
public class PolygonalChainMerger {

    /**
     * ���������� ������� ����� � ����.
     *
     * @param chains ������ ������� �����.
     * @return ������������ ������� �����.
     * @throws IllegalArgumentException ���� ������ ����� null.
     */
    public static Polyline mergePolygonalChains(List<GeometryService> chains) {
        if (chains == null) {
            throw new IllegalArgumentException("������ ������� ����� �� ����� ���� null");
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