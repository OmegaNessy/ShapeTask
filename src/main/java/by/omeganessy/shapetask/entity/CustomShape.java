package by.omeganessy.shapetask.entity;

import by.omeganessy.shapetask.generator.IdGenerator;

public abstract class CustomShape {
    protected long id;

    protected CustomShape() {
        this.id = IdGenerator.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomShape)) return false;
        CustomShape shape = (CustomShape) o;
        return id == shape.id;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int) id;
        return result;
    }
}
