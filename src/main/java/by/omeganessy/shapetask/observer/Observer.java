package by.omeganessy.shapetask.observer;

import by.omeganessy.shapetask.exception.CustomException;

public interface Observer {
    void parameterChanged(TetrahedronEvent event) throws CustomException;
}
