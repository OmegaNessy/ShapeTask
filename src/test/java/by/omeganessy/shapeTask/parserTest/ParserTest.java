package by.omeganessy.shapeTask.parserTest;

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
    public void setUp(){
        parser = new Parser();

    }
    @AfterTest
    public void tearDown(){
        parser = null;

    }
    @Test(dataProvider = "ParseInt")
    public void testParseInt(List<String> strings,int[] expectedResult) throws CustomException {
        List<Integer[]> actualResult=parser.parseInt(strings);
        assertEquals(actualResult,expectedResult);
    }
    @DataProvider(name = "ParseInt")
    public Object[][] provide(){
        List<String> data = new ArrayList<>();
        data.add("1,1 2,2 3,-5 2,-7");
        return new Object[][]{{data,new int[]{1,1,2,2,3,-5,2,-7}}
        };
    }
}
