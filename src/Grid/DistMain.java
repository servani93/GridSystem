package Grid;

import Grid.Calculations;
import Grid.DimentionalUnitsConversion;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

    public class DistMain {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            Queue<GridPoint> coOrdinates = new LinkedList<>();
            while(scan.hasNextDouble()) {
                GridPoint A = new GridPoint(scan.nextDouble(), scan.nextDouble());
                coOrdinates.add(A);
            }
            scan.close();
            GridPoint firstPoint = coOrdinates.peek();
            GridPoint B = coOrdinates.poll();

            while(!coOrdinates.isEmpty()) {
                if(coOrdinates.size() > 1) {
                    GridPoint A = B;
                    B = coOrdinates.poll();
                    double lRad = Calculations.length(A, B);

                    System.out.println("("+ A +","+ B +")");
                    System.out.println(DimentionalUnitsConversion.radiansTometers(lRad)+" "+"mts" );
                    System.out.println(DimentionalUnitsConversion.radiansTolinks(lRad)+" "+"links");
                }
                else {
                    GridPoint A = coOrdinates.poll();
                    B = firstPoint;
                    double lRad = Calculations.length(A, B);

                    System.out.println("("+ A +","+ B +")");
                    System.out.println(DimentionalUnitsConversion.radiansTometers(lRad)+" "+"mts" );
                    System.out.println(DimentionalUnitsConversion.radiansTolinks(lRad)+" "+"links");
                }
                System.out.println();
            }
        }
    }