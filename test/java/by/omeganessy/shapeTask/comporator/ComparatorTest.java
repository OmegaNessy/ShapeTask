package by.omeganessy.shapeTask.comporator;

import by.omeganessy.shapetask.comparator.*;
import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComparatorTest extends Assert {
    Tetrahedron tetrahedron1;
    Tetrahedron tetrahedron2;
    Tetrahedron tetrahedron3;
    Tetrahedron tetrahedron4;

    @BeforeTest
    public void setUp() {
        tetrahedron1 = new Tetrahedron(new Point(1,1,1), new Point(-1,-1,1), new Point(-1,1,-1), new Point(1,-1,-1));
        tetrahedron2 = new Tetrahedron(new Point(3,5,2), new Point(2,3,3), new Point(1,4,2), new Point(1,2,3));
        tetrahedron3 = new Tetrahedron(new Point(2,4,2), new Point(1,2,3), new Point(3,2,2), new Point(5,2,4));
        tetrahedron4 = new Tetrahedron(new Point(4,2,4), new Point(2,3,5), new Point(3, 7,2), new Point(2,3,-1));
    }

    @AfterTest
    public void tearDown() {
        tetrahedron4 = null;
        tetrahedron3 = null;
        tetrahedron2 = null;
        tetrahedron1 = null;
    }

    @Test(dataProvider = "testTetrahedronAreaComparator")
    public void testTetrahedronAreaComparator(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2, int expectedResult) {
        int actualResult = new TetrahedronAreaComparator().compare(tetrahedron1, tetrahedron2);
        assertEquals(actualResult, expectedResult);
    }

    @Test (dataProvider = "testTetrahedronFirstXPointComparator")
    void testTetrahedronFirstXPointComparator(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2, int expectedResult){
        int actualResult = new TetrahedronFirstXPointComparator().compare(tetrahedron1, tetrahedron2);
        assertEquals(actualResult, expectedResult);
    }
    @Test (dataProvider = "testTetrahedronFirstYPointComparator")
    void testTetrahedronFirstYPointComparator(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2, int expectedResult){
        int actualResult = new TetrahedronFirstYPointComparator().compare(tetrahedron1, tetrahedron2);
        assertEquals(actualResult, expectedResult);
    }
    @Test (dataProvider = "testTetrahedronFirstZPointComparator")
    void testTetrahedronFirstZPointComparator(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2, int expectedResult){
        int actualResult = new TetrahedronFirstZPointComparator().compare(tetrahedron1, tetrahedron2);
        assertEquals(actualResult, expectedResult);
    }
    @Test (dataProvider = "testTetrahedronIdComparator")
    void testTetrahedronIdComparator(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2, int expectedResult){
        int actualResult = new TetrahedronIdComparator().compare(tetrahedron1, tetrahedron2);
        assertEquals(actualResult, expectedResult);
    }
    @Test (dataProvider = "testTetrahedronPerimeterComparator")
    void testTetrahedronPerimeterComparator(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2, int expectedResult){
        int actualResult = new TetrahedronPerimeterComparator().compare(tetrahedron1, tetrahedron2);
        assertEquals(actualResult, expectedResult);
    }
    @Test (dataProvider = "testTetrahedronVolumeComparator")
    void testTetrahedronVolumeComparator(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2, int expectedResult){
        int actualResult = new TetrahedronVolumeComparator().compare(tetrahedron1, tetrahedron2);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider
    public Object[][] testTetrahedronAreaComparator() {
        return new Object[][]{
                {tetrahedron1, tetrahedron2, 1},
                {tetrahedron1, tetrahedron3, 1},
                {tetrahedron1, tetrahedron4, 1},
                {tetrahedron2, tetrahedron3, 0},
                {tetrahedron2, tetrahedron4, 0},
                {tetrahedron3, tetrahedron1, -1}
        };
    }
    @DataProvider
    public Object[][] testTetrahedronFirstXPointComparator(){
        return new Object[][]{
                {tetrahedron1, tetrahedron2, -1},
                {tetrahedron1, tetrahedron3, -1},
                {tetrahedron1, tetrahedron4, -1},
                {tetrahedron2, tetrahedron3, 1},
                {tetrahedron2, tetrahedron4, -1},
                {tetrahedron3, tetrahedron1, 1}
        };
    }
    @DataProvider
    public Object[][] testTetrahedronFirstYPointComparator(){
        return new Object[][]{
                {tetrahedron1, tetrahedron2, -1},
                {tetrahedron1, tetrahedron3, -1},
                {tetrahedron1, tetrahedron4, -1},
                {tetrahedron2, tetrahedron3, 1},
                {tetrahedron2, tetrahedron4, 1},
                {tetrahedron3, tetrahedron1, 1}
        };
    }
    @DataProvider
    public Object[][] testTetrahedronFirstZPointComparator(){
        return new Object[][]{
                {tetrahedron1, tetrahedron2, -1},
                {tetrahedron1, tetrahedron3, -1},
                {tetrahedron1, tetrahedron4, -1},
                {tetrahedron2, tetrahedron3, 0},
                {tetrahedron2, tetrahedron4, -1},
                {tetrahedron3, tetrahedron1, 1}
        };
    }
    @DataProvider
    public Object[][] testTetrahedronIdComparator(){
        return new Object[][]{
                {tetrahedron1, tetrahedron2, -1},
                {tetrahedron1, tetrahedron3, -1},
                {tetrahedron1, tetrahedron4, -1},
                {tetrahedron2, tetrahedron3, -1},
                {tetrahedron2, tetrahedron4, -1},
                {tetrahedron3, tetrahedron1, 1}
        };
    }
    @DataProvider
    public Object[][] testTetrahedronPerimeterComparator(){
        return new Object[][]{
                {tetrahedron1, tetrahedron2, 1},
                {tetrahedron1, tetrahedron3, 1},
                {tetrahedron1, tetrahedron4, 1},
                {tetrahedron2, tetrahedron3, 0},
                {tetrahedron2, tetrahedron4, 0},
                {tetrahedron3, tetrahedron1, -1}
        };
    }
    @DataProvider
    public Object[][] testTetrahedronVolumeComparator(){
        return new Object[][]{
                {tetrahedron1, tetrahedron2, 1},
                {tetrahedron1, tetrahedron3, 1},
                {tetrahedron1, tetrahedron4, 1},
                {tetrahedron2, tetrahedron3, 0},
                {tetrahedron2, tetrahedron4, 0},
                {tetrahedron3, tetrahedron1, -1}
        };
    }

}
