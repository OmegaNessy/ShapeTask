package by.omeganessy.shapetask.entity;

public class Point {
    int pointX;
    int pointY;
    int pointZ;

    public Point() {
    }

    public Point(int pointX, int pointY, int pointZ) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getPointZ() {
        return pointZ;
    }

    public void setPointZ(int pointZ) {
        this.pointZ = pointZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return pointX == point.pointX &&
                pointY == point.pointY &&
                pointZ == point.pointZ;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + pointX;
        result = PRIME * result + pointY;
        result = PRIME * result + pointZ;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Point: " + "pointX=");
        string.append(pointX);
        string.append(",\n");
        string.append("pointY=");
        string.append(pointY);
        string.append(",\n");
        string.append("pointY=");
        string.append(pointY);
        string.append("\n");
        return string.toString();
    }
}
