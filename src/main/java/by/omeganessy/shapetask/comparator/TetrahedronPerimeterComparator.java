package by.omeganessy.shapetask.comparator;

import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.impl.TetrahedronCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TetrahedronPerimeterComparator implements Comparator<Tetrahedron> {
    static final Logger logger = LogManager.getLogger();
    private TetrahedronCalculator calculator;

    @Override
    public int compare(Tetrahedron firstShape, Tetrahedron secondShape) {
        calculator=new TetrahedronCalculator();
        double firstPerimeter = 0;
        double secondPerimeter = 0;
        try {
            firstPerimeter = calculator.findPerimeter(firstShape);
            secondPerimeter = calculator.findPerimeter(secondShape);

        } catch (CustomException e) {
            logger.error("Object cant be null",e);
        }
        return Double.compare(firstPerimeter, secondPerimeter);
    }
}
