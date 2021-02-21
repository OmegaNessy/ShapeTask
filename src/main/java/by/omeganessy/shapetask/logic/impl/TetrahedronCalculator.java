package by.omeganessy.shapetask.logic.impl;

import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.ShapeCalculator;
import by.omeganessy.shapetask.validator.TetrahedronValidator;

public class TetrahedronCalculator implements ShapeCalculator {
    static final int FIRST_POINT_INDEX= 0;
    static final int SECOND_POINT_INDEX= 1;

    @Override
    public double findPerimeter(Tetrahedron tetrahedron) throws CustomException {
        double side = findSide(tetrahedron);
        return side * 6;
    }

    @Override
    public double findArea(Tetrahedron tetrahedron) throws CustomException {
        if (TetrahedronValidator.isEmpty(tetrahedron)){
            throw new CustomException("Function parameter can't be null");
        }
        double side = findSide(tetrahedron);
        return Math.pow(side,2)*Math.sqrt(3);
    }

    @Override
    public double findVolume(Tetrahedron tetrahedron) throws CustomException {
        if (TetrahedronValidator.isEmpty(tetrahedron)){
            throw new CustomException("Function parameter can't be null");
        }
        double side = findSide(tetrahedron);
        return (Math.pow(side,3)*Math.sqrt(2))/12;
    }

    private double findSide(Tetrahedron tetrahedron) throws CustomException {
        Point firstPoint = tetrahedron.getPointByIndex(FIRST_POINT_INDEX);
        Point secondPoint = tetrahedron.getPointByIndex(SECOND_POINT_INDEX);
        return Math.sqrt(
                             Math.pow((double)firstPoint.getPointX()-secondPoint.getPointX(),2)+
                             Math.pow((double)firstPoint.getPointY()-secondPoint.getPointY(),2)+
                             Math.pow((double)firstPoint.getPointZ()-secondPoint.getPointZ(),2));
    }

}
