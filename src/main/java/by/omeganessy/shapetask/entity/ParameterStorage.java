package by.omeganessy.shapetask.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParameterStorage {
    public static final Logger logger = LogManager.getLogger();

    private double area;
    private double perimeter;
    private double volume;

    public ParameterStorage(double area, double perimeter, double volume) {
        this.area = area;
        this.perimeter = perimeter;
        this.volume = volume;
        logger.info("created ShapeParametersStorage; area={}, perimeter={}", area,  perimeter);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public static Logger getLogger() {
        return logger;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int)area;
        result = PRIME * result + (int)volume;
        result = PRIME * result + (int)perimeter;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParameterStorage)) return false;
        ParameterStorage that = (ParameterStorage) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParameterStorage{");
        sb.append("area=");
        sb.append(area);
        sb.append(", perimeter=");
        sb.append(perimeter);
        sb.append(", volume=");
        sb.append(volume);
        sb.append('}');
        return sb.toString();
    }
}
