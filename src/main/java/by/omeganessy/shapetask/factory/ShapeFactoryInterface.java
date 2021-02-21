package by.omeganessy.shapetask.factory;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.exception.CustomException;

import java.util.List;

public interface ShapeFactoryInterface {
    CustomShape createShape(List<Point> points) throws CustomException;
}
