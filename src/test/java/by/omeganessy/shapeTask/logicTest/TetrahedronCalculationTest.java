package by.omeganessy.shapeTask.logicTest;

import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.factory.impl.ShapeFactory;
import by.omeganessy.shapetask.logic.implementation.TetrahedronCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronCalculationTest {
    Tetrahedron testTetrahedron;
    TetrahedronCalculator testTetrahedronCalculator;
    ShapeFactory shapeFactory;

    @BeforeClass
    public void setUp(){
        Point pointA = new Point(1,4,5);
        Point pointB = new Point(2,4,5);
        Point pointC = new Point(2,7,3);
        Point pointD = new Point(4,2,3);
        testTetrahedron = new Tetrahedron(pointA,pointB,pointC,pointD);

    }

    @Test
    public void findPerimeterTest() throws CustomException {
        double expected = 0;
        double actual = testTetrahedronCalculator.findPerimeter(testTetrahedron);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void findAreaTest() throws CustomException {
        double expected = 0;
        double actual = testTetrahedronCalculator.findArea(testTetrahedron);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void findVolumeTest() throws CustomException {
        double expected = 0;
        double actual = testTetrahedronCalculator.findVolume(testTetrahedron);
        Assert.assertEquals(actual,expected);
    }
}
