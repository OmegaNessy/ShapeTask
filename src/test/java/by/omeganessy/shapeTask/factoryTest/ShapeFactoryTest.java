package by.omeganessy.shapeTask.factoryTest;

import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.factory.impl.ShapeFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactoryTest {
    ShapeFactory factory;
    Tetrahedron tetrahedron1;
    List<Point> points;

    @BeforeTest
    public void setUp() {
        factory = new ShapeFactory();
        tetrahedron1 = new Tetrahedron(new Point(1,1,1), new Point(-1,-1,1), new Point(-1,1,-1), new Point(1,-1,-1));
        points = new ArrayList<>();
        points.add(new Point(1,1,1));
        points.add(new Point(-1,-1,1));
        points.add(new Point(-1,1,-1));
        points.add(new Point(1,1,-1));
    }

    @AfterTest
    public void tearDown() {
        factory = null;
        tetrahedron1 = null;
    }

    @Test
    public void testCreateShape() throws CustomException {
        Tetrahedron actualResult = (Tetrahedron) factory.createShape(points);
        Tetrahedron expectedResult = tetrahedron1;
        expectedResult.setId(actualResult.getId());
        Assert.assertEquals(actualResult, expectedResult);
    }

}
