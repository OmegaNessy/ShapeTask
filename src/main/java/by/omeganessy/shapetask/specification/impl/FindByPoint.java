package by.omeganessy.shapetask.specification.impl;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.specification.Specification;

public class FindByPoint implements Specification {
    private Point point;

    public FindByPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean specify(CustomShape customShape) {
        boolean result = false;
        for (Point pointFromShape : ((Tetrahedron) customShape).getPoints()) {
            if (point.equals(pointFromShape)) {
                result = true;
                break;
            }
        }
        return result;
    }
}