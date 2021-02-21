package by.omeganessy.shapetask.specification.impl;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.specification.Specification;

public class FindInArea implements Specification {
    private Point minPoint;
    private Point maxPoint;

    public FindInArea(Point minPoint, Point maxPoint) {
        this.minPoint=minPoint;
        this.maxPoint=maxPoint;
    }

    @Override
    public boolean specify(CustomShape shape) {
        Point[] points = ((Tetrahedron) shape).getPoints();
        boolean result = true;
        for (Point point : points) {
            if (point.getPointX() < minPoint.getPointX() || point.getPointX() > maxPoint.getPointX()) {
                result = false;
                break;
            }
            if (point.getPointY() < minPoint.getPointY() || point.getPointY() > maxPoint.getPointY()) {
                result = false;
                break;
            }
            if (point.getPointZ() < minPoint.getPointZ() || point.getPointZ() > maxPoint.getPointZ()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
