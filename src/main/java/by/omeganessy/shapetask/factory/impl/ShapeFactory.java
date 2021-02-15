package by.omeganessy.shapetask.factory.impl;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.factory.FactoryInterface;
import by.omeganessy.shapetask.validator.TetrahedronValidator;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory implements FactoryInterface {
    @Override
    public CustomShape createShape(List<Integer> pointCoordinates) throws CustomException {
        List<Point> points = createPoints(pointCoordinates);
        if (TetrahedronValidator.isTetrahedron(points)){
            return new Tetrahedron(points);

        }
        throw new CustomException("No shapes that can be created with these coords");
    }

    private List<Point> createPoints(List<Integer> pointsCoordinates){
        List<Point> points = new ArrayList<>();
        for (int i = 0; i<pointsCoordinates.size()/3;i++){
            points.add(new Point(pointsCoordinates.get(i),
                                 pointsCoordinates.get(i*2),
                                 pointsCoordinates.get(i*3)));
        }
        return points;
    }
}
