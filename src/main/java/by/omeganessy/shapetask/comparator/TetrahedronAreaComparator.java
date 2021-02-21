package by.omeganessy.shapetask.comparator;

import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.impl.TetrahedronCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TetrahedronAreaComparator implements Comparator<Tetrahedron> {
    static final Logger logger = LogManager.getLogger();
    private TetrahedronCalculator calculator;

    @Override
    public int compare(Tetrahedron firstShape, Tetrahedron secondShape) {
        calculator = new TetrahedronCalculator();
        double firstArea = 0;
        double secondArea = 0;
        try {
            firstArea = calculator.findArea(firstShape);
            secondArea = calculator.findArea(secondShape);
        } catch (CustomException e) {
            logger.error("Object cant be null",e);
        }
        return Double.compare(firstArea, secondArea);
    }
}
