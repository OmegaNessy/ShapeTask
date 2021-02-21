package by.omeganessy.shapetask.factory.impl;

import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.factory.PointFactoryInterface;

import java.util.ArrayList;
import java.util.List;

public class PointFactory implements PointFactoryInterface {

    @Override
    public List<Point> createPoints(List<Integer> pointsCoordinates){
        List<Point> points = new ArrayList<>();
        for (int i = 0; i<pointsCoordinates.size()/3;i++){
            points.add(new Point(pointsCoordinates.get(i),
                    pointsCoordinates.get(i*2),
                    pointsCoordinates.get(i*3)));
        }
        return points;
    }
}
