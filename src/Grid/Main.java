package Grid;

import Grid.DimentionalUnitsConversion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double lengthAtoC, AC = 0, lengthBtoC, BC = 0, AB, lengthAtoB;
        Scanner scan = new Scanner(System.in);
        double lat, lon;

        System.out.print("latitude at A:");
        lat = scan.nextDouble();
        System.out.print("longitude at A:");
        lon = scan.nextDouble();
        GridPoint A = new GridPoint(lat, lon);

        System.out.print("latitude at B:");
        lat = scan.nextDouble();
        System.out.print("longitude at B:");
        lon = scan.nextDouble();
        GridPoint B = new GridPoint(lat, lon);

        System.out.println();
        // to select units
        System.out.println("Type the case:");
        System.out.println("case 1: If both lengths are in links");
        System.out.println("case 2: If both lengths are in meters");
        System.out.println("case 3: If lengthAtoC is in links and lengthBtoC is in meters");
        System.out.println("case 4: If lengthAtoC is in meters and length is in links");
        switch (scan.nextInt()) {
            case 1:
                System.out.print("lengthAtoC = ");
                lengthAtoC = scan.nextInt();
                System.out.print("lengthBtoC = ");
                lengthBtoC = scan.nextInt();
                AC = DimentionalUnitsConversion.linksToRadians(lengthAtoC);
                BC = DimentionalUnitsConversion.linksToRadians(lengthBtoC);
                break;
            case 2:
                System.out.print("lengthAtoC = ");
                lengthAtoC = scan.nextInt();
                System.out.print("lengthBtoC = ");
                lengthBtoC = scan.nextInt();
                AC = DimentionalUnitsConversion.metersToRadians(lengthAtoC);
                BC = DimentionalUnitsConversion.metersToRadians(lengthBtoC);
                break;
            case 3:
                System.out.print("lengthAtoC = ");
                lengthAtoC = scan.nextInt();
                System.out.print("lengthBtoC = ");
                lengthBtoC = scan.nextInt();
                AC = DimentionalUnitsConversion.linksToRadians(lengthAtoC);
                BC = DimentionalUnitsConversion.metersToRadians(lengthBtoC);
                break;
            case 4:
                System.out.print("lengthAtoC = ");
                lengthAtoC = scan.nextInt();
                System.out.print("lengthBtoC = ");
                lengthBtoC = scan.nextInt();
                AC = DimentionalUnitsConversion.metersToRadians(lengthAtoC);
                BC = DimentionalUnitsConversion.linksToRadians(lengthBtoC);
                break;
            default:
                break;
        }

        AB = Math.acos(Math.sin(A.getLatitude())*Math.sin(B.getLatitude())
                +Math.cos(A.getLatitude())*Math.cos(B.getLatitude())*Math.cos(A.getLongitude()-B.getLongitude()));

        System.out.println("AB : "+AB +"\n"+"cos(AB) :"+ Math.cos(AB));
        System.out.println();
        System.out.println("Select Units for lengthAtoB:");
        System.out.println("case 1 in meters:");
        System.out.println("case 2 in links:");
        switch (scan.nextInt()){
            case 1:
                lengthAtoB = DimentionalUnitsConversion.radiansTometers(AB);
                System.out.println("AB(meters):"+lengthAtoB);
                break;
            case 2:
                lengthAtoB = DimentionalUnitsConversion.radiansTolinks(AB);
                System.out.println("AB(links):"+lengthAtoB);
                break;
            default:
                break;
        }
        double anglePAB, angleCAB, longitudeAtC, latitudeAtC, anglePAC, BC1, cosAnglePAB, numarator, denominator;

       // numarator =Math.sin(B.getLatitude())-Math.sin(A.getLatitude())*Math.cos(AB);
     //   denominator =Math.cos(A.getLatitude())*Math.sin(AB);
      //  System.out.println("numarator : "+numarator+"\n"+"denominator : "+denominator);

        anglePAB = Math.acos((Math.sin(B.getLatitude())-Math.sin(A.getLatitude())*Math.cos(AB))
                /(Math.cos(A.getLatitude())*Math.sin(AB))) ;

      //  cosAnglePAB = ((Math.sin(B.getLatitude())-Math.sin(A.getLatitude())*Math.cos(AB))
      //          /(Math.cos(A.getLatitude())*Math.sin(AB))) ;

      //  System.out.println("cos (AnglePAB) : "+cosAnglePAB);
     //   System.out.println("cosInverse(cos(AnglePAB)) : "+ Math.acos(cosAnglePAB));

     //   System.out.println("anglePAB(Radians): "+anglePAB);

    //    System.out.println("cos (anglePAB) : "+ Math.cos(anglePAB));

        angleCAB = Math.acos((Math.cos(BC) - Math.cos(AC)*Math.cos(AB))
                /(Math.sin(AC)*Math.sin(AB)));
      //  System.out.println("cos BC : "+Math.cos(BC)+"\n"+"cos AC : "+Math.cos(AC)+"\n"+"cos AB : "+Math.cos(AB)+"\n"+"sin AC : "+Math.sin(AC)+"\n"+"sin AB : "+Math.sin(AB));

      //  System.out.println("BC(Radians) : "+ BC +"\n"+"AC(Radians) : "+ AC +"\n" + "AB(Radians) : "+ AB);

       // System.out.println("angleCAB(Radians) : "+angleCAB);

        anglePAC = Math.acos(Math.cos(anglePAB)*Math.cos(angleCAB)+Math.sin(anglePAB)*Math.sin(angleCAB));

      //  System.out.println("anglePAC(Radians): "+anglePAC);

        latitudeAtC = Math.asin(Math.sin(A.getLatitude())*Math.cos(AC)+
                Math.cos(A.getLatitude())*Math.sin(AC)*Math.cos(anglePAC));

      //  System.out.println("longitude at A(Radians): "+A.getLongitude());
        //System.out.println("latitude at C(Radians) : "+ latitudeAtC);

        longitudeAtC = A.getLongitude()+(Math.acos((Math.cos(AC)- Math.sin(A.getLatitude())*Math.sin(latitudeAtC))
                /(Math.cos(A.getLatitude())*Math.cos(latitudeAtC))));
    //    System.out.println("longitude at C(Radians) : "+ longitudeAtC);

        //Grid.GridPoint C = new Grid.GridPoint(latitudeAtC, longitudeAtC);
        System.out.println("("+"latitude at C : "+Math.toDegrees(latitudeAtC)+", "+
                "longitude at C : "+Math.toDegrees(longitudeAtC)+")");

        BC1 = Math.acos(Math.sin(B.getLatitude())*Math.sin(latitudeAtC)
                +Math.cos(B.getLatitude())*Math.cos(latitudeAtC)*Math.cos(B.getLongitude()-longitudeAtC));

        System.out.println("BC1 : "+ BC1);
        System.out.println("BC1(links)"+DimentionalUnitsConversion.radiansTolinks(BC1));

    }
}
