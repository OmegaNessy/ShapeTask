package factoryTest;

import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.factory.impl.ShapeFactory;
import by.omeganessy.shapetask.logic.implementation.TetrahedronCalculator;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeFactoryTest {
    Tetrahedron testTetrahedron;
    TetrahedronCalculator testTetrahedronCalculator;
    ShapeFactory shapeFactory;

    @BeforeClass
    public void setUp() throws CustomException {
        Integer[] points = {1, 4, 5, 2, 5, 6, 2, 7, 3, 4, 2, 3};
        List<Integer> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.addAll(Arrays.asList(points));
        shapeFactory = new ShapeFactory();
        shapeFactory.createShape(pointsCoordinates);
    }
}
