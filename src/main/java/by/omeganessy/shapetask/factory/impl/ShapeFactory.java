package by.omeganessy.shapetask.factory.impl;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.factory.ShapeFactoryInterface;
import java.util.List;

public class ShapeFactory implements ShapeFactoryInterface {
    @Override
    public CustomShape createShape(List<Point> points){
        return new Tetrahedron(points);
    }

}
