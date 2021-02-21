package by.omeganessy.shapeTask.util;

import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.util.FileReaderUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FileReaderUtilTest extends Assert {
    String filePath;
    List<String> expectedResult ;
    FileReaderUtil reader;
    @BeforeTest
    public void setUp(){
        filePath = "./resources/data/data.txt";
        expectedResult = new ArrayList<>();
        expectedResult.add("0 0 10 16 12 3 25 -14 12 10 32 -12");
        expectedResult.add("1 1 11 8 13 4 12 -13 12 -23 -23 4");
        expectedResult.add("1 1 1 -1 -1 1 -1 1 -1 1 -1 -1");
    }
    @AfterTest
    public void tearDown(){
        expectedResult = null;
        filePath = null;
        reader=null;
    }
    @Test
    public void testReadStringsFromFile() throws CustomException {
        reader = new FileReaderUtil();
        List<String> actualResult = reader.read(filePath);
        assertEquals(actualResult,expectedResult);
    }
}
