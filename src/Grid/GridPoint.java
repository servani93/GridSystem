package Grid;

public class GridPoint {
    private double longitude;
    private double latitude;

    GridPoint(double longitude, double latitude){
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public double getLatitude() {
        return Math.toRadians(this.latitude);
    }
    public double getLongitude() {
        return Math.toRadians(this.longitude);
    }
    public String toString(){
        return " "+longitude+" "+latitude+" ";
    }
}