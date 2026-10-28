package q1.Week5;

import java.util.Scanner;

public class pelican37_8 {
    public static class LinearFunction implements LinearFunctionMethods {
        private double m;
        private double b;

        public LinearFunction(double slope, double yIntc) {
            this.m = slope;
            this.b = yIntc;
        }

        public double getSlope() {
            return m;
        }

        public double getYintercept() {
            return b;
        }

        public double getRoot() {
            return -(b/m);
        }

        public double getYvalue(double x) {
            return m * x + b;
        } //return the y value corresponding to x 
        
        public double getXvalue(double y) {
            return (y-b)/m;
        }

    }
    public interface LinearFunctionMethods { 
        
        double getSlope( );
        double getYintercept( ); 
        double getRoot( ); 
        double getYvalue(double x); //return the y value corresponding to x 
        double getXvalue(double y); //return the x value corresponding to y 
    } 
    public static void main(String[] args) {
        Scanner kbReader = new Scanner(System.in); 
 
        System.out.print("What is the slope of your line? "); 
        double slope = kbReader.nextDouble( );
        
        System.out.print("What is the y-intercept of your line? "); 
        double yIntc = kbReader.nextDouble( ); 
        
        LinearFunction line = new LinearFunction(slope, yIntc);
 
        System.out.println("\nSlope of this line is: " + line.getSlope( ));

        System.out.println("Y-intercept of this line is: " + line.getYintercept( ));

        System.out.println("Root of this line is: " + line.getRoot( ));
 
        System.out.print("\nWhat is an x value for which you wish to solve for y? "); 
        double x = kbReader.nextDouble( ); 
        double yValue = line.getYvalue(x); 
        System.out.println("The y value corresponding to x = " + x + " is " + yValue); 
 
        System.out.print("\nWhat is a y value for which you wish to solve for x? "); 
        double y = kbReader.nextDouble( ); 
        double xValue = line.getXvalue(y); 
        System.out.println("The x value corresponding to y = " + y + " is " + xValue);
    }
}
/*
What is the slope of your line? 25
What is the y-intercept of your line? 5

Slope of this line is: 25.0
Y-intercept of this line is: 5.0
Root of this line is: -0.2

What is an x value for which you wish to solve for y? 3
The y value corresponding to x = 3.0 is 80.0

What is a y value for which you wish to solve for x? 50
The x value corresponding to y = 50.0 is 1.8
*/