package by.omeganessy.shapetask.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;


public class DataValidator {
    static Logger logger = LogManager.getLogger();
    static final String SPLIT_REGULAR_EXPRESSION = " ";
    static final int REQUIRED_DATA_LENGTH = 12;

    private DataValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isStringValid(String data) {
        boolean response = true;
        String[] dataArray = data.split(SPLIT_REGULAR_EXPRESSION);
        try {
            Arrays.stream(dataArray).mapToDouble(Double::parseDouble).toArray();
            if (dataArray.length<REQUIRED_DATA_LENGTH){
                response = false;
            }
        } catch (NumberFormatException e) {
            logger.info("String is not valid. Input string: \"{}\"\n NEXT STRING...", data);
            response = false;
        }
        return response;
    }
}
