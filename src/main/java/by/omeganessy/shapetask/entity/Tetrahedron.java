package by.omeganessy.shapetask.entity;


import by.omeganessy.shapetask.exception.CustomException;

import java.util.List;

public class Tetrahedron extends CustomShape {
    private Point[] points;

    public Tetrahedron(List<Point> points) {
        this.points = (Point[]) points.toArray();
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
    }

    public Point getPointByIndex(int index) throws CustomException{
        if (index<points.length){
            return points[index];
        }
        throw new CustomException("The index is out of bounce: " + index);
    }
}
