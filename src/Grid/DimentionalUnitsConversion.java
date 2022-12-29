package Grid;

public class DimentionalUnitsConversion {
    static double linksToRadians(double dimentionValuesLinksToRadians){
        double dimentionValueInRadians;
        dimentionValueInRadians = (dimentionValuesLinksToRadians*0.201168)/6371000;
        return dimentionValueInRadians;
    }
    static double metersToRadians(double dimentionValuesMetersToRadians){
        double dimentionValueInRadians;
        dimentionValueInRadians = dimentionValuesMetersToRadians/6371000;
        return dimentionValueInRadians;
    }
    static double radiansTometers(double dimentionValueInRadians){
        double dimentionValueInMeters;
        dimentionValueInMeters = dimentionValueInRadians * 6371000;
        return dimentionValueInMeters;
    }
    static double radiansTolinks(double dimentionValueInRadians){
        double dimentionValueInLinks;
        dimentionValueInLinks = (dimentionValueInRadians * 6371000)/0.201168;
        return dimentionValueInLinks;
    }
}
