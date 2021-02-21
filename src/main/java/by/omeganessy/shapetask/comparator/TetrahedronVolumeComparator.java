package by.omeganessy.shapetask.comparator;

import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.impl.TetrahedronCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TetrahedronVolumeComparator implements Comparator<Tetrahedron> {
    static final Logger logger = LogManager.getLogger();
    private TetrahedronCalculator calculator;

    @Override
    public int compare(Tetrahedron firstShape, Tetrahedron secondShape) {
        calculator=new TetrahedronCalculator();
        double firstVolume = 0;
        double secondVolume = 0;
        try {
            firstVolume = calculator.findVolume(firstShape);
            secondVolume = calculator.findVolume(secondShape);

        } catch (CustomException e) {
            logger.error("Object cant be null",e);
        }
        return Double.compare(firstVolume, secondVolume);
    }
}
