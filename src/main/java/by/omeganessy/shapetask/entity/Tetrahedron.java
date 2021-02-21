package by.omeganessy.shapetask.entity;

import by.omeganessy.shapetask.exception.CustomException;
import by.omeganessy.shapetask.observer.Observable;
import by.omeganessy.shapetask.observer.Observer;
import by.omeganessy.shapetask.observer.TetrahedronEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tetrahedron extends CustomShape implements Observable {
    static final int POINTS_LENGTH = 4;
    public static final Logger logger = LogManager.getLogger();
    private List<Observer> observers = new ArrayList<>();
    private Point[] points ;
    public Tetrahedron(List<Point> pointsArray) {
        this.points= pointsArray.toArray(new Point[POINTS_LENGTH]);
    }

    public Tetrahedron(Point pointA,Point pointB,Point pointC,Point pointD){
        points = new Point[4];
        points[0]=pointA;
        points[1]=pointB;
        points[2]=pointC;
        points[3]=pointD;
    }

    public Point[] getPoints() {
        return points.clone();
    }

    public void setPoints(Point[] points) {
        this.points = points;
        notifyObserver();
    }

    public Point getPointByIndex(int index) throws CustomException{
        if (index<points.length){
            return points[index];
        }
        throw new CustomException("The index is out of bounce: " + index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tetrahedron)) return false;
        if (!super.equals(o)) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = PRIME * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        TetrahedronEvent event = new TetrahedronEvent(this);
        try{
        for (Observer observer : observers) {
            observer.parameterChanged(event);
        }
        }catch (CustomException e){
            logger.error("Error in editing. Trace ",e);
        }

    }
}
