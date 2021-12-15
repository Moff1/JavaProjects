package cs1302.hw03.i;

import cs1302.hw03.impl.Car;
import cs1302.hw03.impl.Truck;
import cs1302.hw03.contract.Drivable;
/**
6   * A driver program to test the functionality of
7   * {@code cs1302.hw03.impl.Car} which implements
8   * {@code cs1302.hw03.contract.Drivable}
9   */
public class Driver {

     /**
13      * Attempts to speedup and slowdown the {@link cs1302.hw03.impl.Car} or {@link cs1302.hw03.impl.Truck} object
14      * by a specified amount. If the {@link cs1302.hw03.impl.Car} or {@link cs1302.hw03.impl.Truck} object is unable
15      * to speedup or slowdown by the specified amount, an appropriate message is
16      * printed. It also accounts for when the car stops, or the mph reaches 0.
17      *
18      * @param Drivable the  to test
19      * @param speedupAmount the amount to speedup the car
20      * @param slowdownAmount the amount to slowdown the car
21      */
     public static void test(Drivable Drivable, double speedupAmount,
                             double slowdownAmount) {
    	 
         System.out.println(Drivable);
         if(Drivable.speedUp(speedupAmount)) {
            System.out.println("The vehicle sped up by " + speedupAmount + " mph");
        } else {
             System.out.println("The vehicle cannot go that fast");
         } // if

         if(Drivable.slowDown(slowdownAmount)) {
             System.out.println("The vehicle slowed down by " + slowdownAmount + " mph");
         } else {
             System.out.println("The vehicle is cannot slow down by that amount");
             
         }
         
         System.out.println(Drivable);
     }
     
     
         // if
         /*
         if(Drivable.stop(stops)) {
        	 System.out.println("The vehicle hasn't stopped!");
        	 
        	 } else {
        		 System.out.println("The vehicle has stopped!");
        	 }
     			System.out.println(Drivable);
        	 }
         */

        
      // test


/**
      *
      * @param args the command-line arguments to the program
      */
     public static void main(String[] args) {
         Drivable fastCar = new Car(65.0,true);
         Drivable slowCar = new Car(65.0,true);
    	 Drivable fastTruck = new Truck(120.0, false);
    	 Drivable slowTruck = new Truck(35.0, true);

         System.out.println("--------------------");

         test(fastCar, 50, 20.0);
         System.out.println("--------------------");
         
         
         test(slowCar, 59, 20);
         System.out.println("--------------------");
         
         
         test(fastTruck, 85, 20);
         System.out.println("--------------------");

         test(slowTruck, 65, 65);
         System.out.println("--------------------");
         
         
     } // main
 } // Driver


