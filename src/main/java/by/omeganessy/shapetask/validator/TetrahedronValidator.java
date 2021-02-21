package by.omeganessy.shapetask.validator;

import by.omeganessy.shapetask.entity.Point;
import by.omeganessy.shapetask.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TetrahedronValidator {
    static Logger logger = LogManager.getLogger();

    private TetrahedronValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isEmpty (Tetrahedron tetrahedron){
        return tetrahedron==null || tetrahedron.getPoints().length==0;
    }

    public static boolean isTetrahedron (List<Point> points) {
        boolean response = false;
        double[] sides = findAllSides(points);
        if (areEqual(sides)){
            response = true;
        }
        return response;
    }

    private static double findSide(Point firstPoint,Point secondPoint){
        return Math.sqrt(
                Math.pow((double)firstPoint.getPointX()-secondPoint.getPointX(),2)+
                        Math.pow((double)firstPoint.getPointY()-secondPoint.getPointY(),2)+
                        Math.pow((double)firstPoint.getPointZ()-secondPoint.getPointZ(),2));
    }

    private static boolean areEqual(double[] sides){
        boolean response = false;
        int counter=0;
        for (int i=1;i<=sides.length-1;i++){
            if (sides[i]==sides[i-1]){
                counter++;
            }
        }
        if(counter==5){
            response = true;
        }
        return response;
    }

    private static double[] findAllSides(List<Point> points){
        int counter=0;
        double[] sides = new double[6];
        for (int i = 0; i<=points.size()-1;i++){
            for (int j = 0; j<=i;j++){
                sides[counter]=findSide(points.get(j),points.get(i));
                counter++;
            }
        }
        return sides;
    }
}
