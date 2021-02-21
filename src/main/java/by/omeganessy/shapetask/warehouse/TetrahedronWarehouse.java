package by.omeganessy.shapetask.warehouse;

import by.omeganessy.shapetask.entity.ParameterStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class TetrahedronWarehouse {
    public static final Logger logger = LogManager.getLogger();
    private static final TetrahedronWarehouse INSTANCE = new TetrahedronWarehouse();
    private Map<Long, ParameterStorage> shapeParameterMap = new HashMap<>();


    public static TetrahedronWarehouse getInstance() {
        return INSTANCE;
    }

    public void putShapeParameters(long id, ParameterStorage shapeParametersStorage) {
        shapeParameterMap.put(id, shapeParametersStorage);
        logger.info("Added in warehouse:\n id={} storage: {}",id, shapeParametersStorage);
    }

    public ParameterStorage getShapeParameters(long id) {
        return shapeParameterMap.get(id);
    }

    public boolean removeShapeParameters(long id, ParameterStorage shapeParametersStorage) {
        logger.info( "Removed from warehouse:\n id={} storage: {}",id, shapeParametersStorage);
        return shapeParameterMap.remove(id, shapeParametersStorage);
    }
}
