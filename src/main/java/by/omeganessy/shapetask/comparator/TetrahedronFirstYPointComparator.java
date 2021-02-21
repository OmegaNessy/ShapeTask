package by.omeganessy.shapetask.comparator;

import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;

import java.util.Comparator;

public class TetrahedronFirstYPointComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron firstShape, Tetrahedron secondShape) {
        Point[] firstPoints = firstShape.getPoints();
        Point[] secondPoints = secondShape.getPoints();
        Point firstAPoint = firstPoints[0];
        Point secondAPoint = secondPoints[0];
        return Double.compare(firstAPoint.getPointY(), secondAPoint.getPointY());
    }
}
