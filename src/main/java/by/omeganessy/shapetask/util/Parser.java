package by.omeganessy.shapetask.util;

import by.omeganessy.shapetask.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    static Logger logger = LogManager.getLogger();
    static final String SPLIT_REGULAR_EXPRESSION = " ";
    static final int LINE_LENGTH = 12;

    public List<Integer[]> parseInt(List<String> data) throws CustomException {
        try {
            List<Integer[]> result = new ArrayList<>();
            for (String string : data) {
                Integer[] arrayInteger = new Integer[LINE_LENGTH];
                String[] arrayString = string.split(SPLIT_REGULAR_EXPRESSION);
                for (int i = 0; i<arrayString.length;i++) {
                    arrayInteger[i] = Integer.parseInt(arrayString[i]);
                }
                result.add(arrayInteger);
            }
            return result;
        }catch (NumberFormatException e){
            logger.info("Ошибка в переданных данных: данные не валидны");
            throw new CustomException("Ошибка преобразования данных",e);
        }
    }
}
