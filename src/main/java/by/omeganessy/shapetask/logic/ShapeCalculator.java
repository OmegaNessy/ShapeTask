package by.omeganessy.shapetask.logic;

import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;

public interface ShapeCalculator {
    double findPerimeter (Tetrahedron tetrahedron) throws CustomException;
    double findArea (Tetrahedron tetrahedron) throws CustomException;
    double findVolume (Tetrahedron tetrahedron) throws CustomException;
}
