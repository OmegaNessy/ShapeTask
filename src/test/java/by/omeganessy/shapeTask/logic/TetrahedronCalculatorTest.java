package by.omeganessy.shapeTask.logic;

import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.impl.TetrahedronCalculator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronCalculatorTest extends Assert {
    Tetrahedron testTetrahedron;
    TetrahedronCalculator calculator;
    @BeforeTest
    public void setUp() {
        Point pointA = new Point(1,1,1);
        Point pointB = new Point(-1,-1,1);
        Point pointC = new Point(-1,1,-1);
        Point pointD = new Point(1,-1,-1);
        testTetrahedron =new Tetrahedron(pointA,pointB,pointC,pointD);
        calculator=new TetrahedronCalculator();
    }
    @AfterTest
    public void tearDown() {
        testTetrahedron =null;
    }
    @Test
    public void testFindPerimeter() throws CustomException {
        double expectedResult =16.97;
        double actualResult = calculator.findPerimeter(testTetrahedron);
        assertEquals(actualResult,expectedResult,0.01);
    }
    @Test
    public void testFindVolume() throws CustomException {
        double expectedResult=2.66;
        double actualResult = calculator.findVolume(testTetrahedron);
        assertEquals(actualResult,expectedResult,0.01);
    }
    @Test
    public void testFindSquare() throws CustomException {
        double expectedResult=13.85;
        double actualResult = calculator.findArea(testTetrahedron);
        assertEquals(actualResult,expectedResult,0.01);
    }
}
