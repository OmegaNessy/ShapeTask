package by.omeganessy.shapetask.factory;

import by.omeganessy.shapetask.entity.Point;
import java.util.List;

public interface PointFactoryInterface {
    List<Point> createPoints(List<Integer> pointsCoordinates);
}
