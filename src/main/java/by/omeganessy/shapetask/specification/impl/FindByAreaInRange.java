package by.omeganessy.shapetask.specification.impl;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.impl.TetrahedronCalculator;
import by.omeganessy.shapetask.specification.Specification;

public class FindByAreaInRange implements Specification {
    private double leftBoarder;
    private double rightBoarder;

    public FindByAreaInRange(double leftBoarder, double rightBoarder) {
        this.leftBoarder = leftBoarder;
        this.rightBoarder = rightBoarder;
    }

    @Override
    public boolean specify(CustomShape customShape) {
        double area;
        try{
            TetrahedronCalculator tetraCalculator = new TetrahedronCalculator();
            area = tetraCalculator.findArea((Tetrahedron) customShape);
        }catch (CustomException e){
            return false;
        }
        return leftBoarder < area && area < rightBoarder;
    }
}
