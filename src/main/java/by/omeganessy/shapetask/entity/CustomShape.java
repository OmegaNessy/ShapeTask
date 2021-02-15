package by.omeganessy.shapetask.entity;

import java.util.UUID;

public abstract class CustomShape {
    protected UUID id;

    protected CustomShape() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomShape)) return false;
        CustomShape shape = (CustomShape) o;
        return id == shape.id || (id!=null && id.equals(shape.id));
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (id!=null?id.hashCode():0);
        return result;
    }
}
