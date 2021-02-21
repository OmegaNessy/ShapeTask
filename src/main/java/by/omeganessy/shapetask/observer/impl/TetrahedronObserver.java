package by.omeganessy.shapetask.observer.impl;

import by.omeganessy.shapetask.entity.ParameterStorage;
import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.logic.impl.TetrahedronCalculator;
import by.omeganessy.shapetask.observer.Observer;
import by.omeganessy.shapetask.observer.TetrahedronEvent;
import by.omeganessy.shapetask.warehouse.TetrahedronWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronObserver implements Observer {
    public static final Logger logger = LogManager.getLogger();
    private TetrahedronWarehouse warehouse= TetrahedronWarehouse.getInstance();
    private TetrahedronCalculator calculator=new TetrahedronCalculator();
    private ParameterStorage parameterStorage;
    private Tetrahedron tetrahedron;

    @Override
    public void parameterChanged(TetrahedronEvent event) throws CustomException {
        tetrahedron = (Tetrahedron) event.getSource();
        logger.info("parameters changed; shape: {}", tetrahedron);
        double perimeter=calculator.findPerimeter(tetrahedron);
        double area=calculator.findArea(tetrahedron);
        double volume=calculator.findVolume(tetrahedron);
        parameterStorage =warehouse.getShapeParameters(tetrahedron.getId());
        if(parameterStorage!=null){
            parameterStorage.setArea(area);
            parameterStorage.setPerimeter(perimeter);
            parameterStorage.setVolume(volume);
        }else {
            parameterStorage= new ParameterStorage(area,perimeter,volume);
        }
        warehouse.putShapeParameters(tetrahedron.getId(),parameterStorage);
    }
}
