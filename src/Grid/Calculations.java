package Grid;

public class Calculations {
    public static double length(GridPoint A, GridPoint B) {
        double AB = Math.acos(Math.sin(A.getLatitude())*Math.sin(B.getLatitude())+
                Math.cos(A.getLatitude())*Math.cos(B.getLatitude())*Math.cos(A.getLongitude()-B.getLongitude()));
        return AB;
    }
}