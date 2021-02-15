package by.omeganessy.shapetask.factory;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.exception.CustomException;

import java.util.List;

public interface FactoryInterface {
    CustomShape createShape(List<Integer> pointCoordinates) throws CustomException;
}
