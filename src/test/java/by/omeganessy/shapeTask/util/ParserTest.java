package by.omeganessy.shapeTask.util;

import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.util.Parser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ParserTest {
    private Parser parser;

    @BeforeTest
    public void setUp() {
        parser = new Parser();

    }

    @AfterTest
    public void tearDown() {
        parser = null;

    }

    @Test(dataProvider = "ParseInt")
    public void testParseInt(List<String> strings, Integer[] expectedResult) throws CustomException {
        List<Integer[]> parsedData = parser.parseInt(strings);
        Integer[] actualResult=parsedData.get(0);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "ParseInt")
    public Object[][] provide() {
        List<String> data = new ArrayList<>();
        List<Integer[]> parsedData = new ArrayList<>();
        data.add("1 1 2 2 3 -5 2 -7 2 1 2 2");
        return new Object[][]{{data, new Integer[]{1,1,2,2,3,-5,2,-7,2,1,2,2}}
        };
    }
}
