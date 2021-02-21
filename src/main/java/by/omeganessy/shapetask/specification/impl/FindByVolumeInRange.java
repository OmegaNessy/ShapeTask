package by.omeganessy.shapetask.specification.impl;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.impl.TetrahedronCalculator;
import by.omeganessy.shapetask.specification.Specification;

public class FindByVolumeInRange implements Specification {
    private double leftBoarder;
    private double rightBoarder;

    public FindByVolumeInRange(double leftBoarder, double rightBoarder) {
        this.leftBoarder = leftBoarder;
        this.rightBoarder = rightBoarder;
    }

    @Override
    public boolean specify(CustomShape customShape) {
        TetrahedronCalculator shapeCalculator = new TetrahedronCalculator();
        double tetrahedronVolume;
        boolean result;
        try {
            tetrahedronVolume = shapeCalculator.findVolume((Tetrahedron)customShape);
            result = tetrahedronVolume >= leftBoarder && tetrahedronVolume <= rightBoarder;
        } catch (CustomException e) {
            result = false;
        }

        return result;
    }
}