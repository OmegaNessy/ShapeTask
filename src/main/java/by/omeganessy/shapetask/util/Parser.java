package by.omeganessy.shapetask.util;

import by.omeganessy.shapetask.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    static Logger logger = LogManager.getLogger();
    static final String SPLIT_REGULAR_EXPRESSION = " ";

    public List<Integer[]> parseInt(List<String> data) throws CustomException {
        try {
            List<Integer[]> result = new ArrayList<>();
            for (String string : data) {
                String[] arrayString = string.split(SPLIT_REGULAR_EXPRESSION);
                Integer[] arrayInteger = (Integer[]) Arrays.stream(arrayString).mapToInt(Integer::parseInt).boxed().toArray();
                result.add(arrayInteger);
            }
            return result;
        }catch (NumberFormatException e){
            logger.info("Ошибка в переданных данных: данные не валидны");
            throw new CustomException("Ошибка преобразования данных",e);
        }
    }
}
