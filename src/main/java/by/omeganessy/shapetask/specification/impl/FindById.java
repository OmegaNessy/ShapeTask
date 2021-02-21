package by.omeganessy.shapetask.specification.impl;

import by.omeganessy.shapetask.entity.CustomShape;
import by.omeganessy.shapetask.specification.Specification;

public class FindById implements Specification {
    private int id;

    public FindById(int shapeId) {
        this.id = shapeId;
    }
    @Override
    public boolean specify(CustomShape customShape) {
        return customShape.getId() == id;
    }
}
