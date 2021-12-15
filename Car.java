package cs1302.hw03.impl;

import cs1302.hw03.contract.Drivable;

  /**
6   * This class represents a car. It implements
7   * the {@link cs1302.hw03.contract.Drivable} interface.
8   *
9   */
 public class Car implements Drivable {
     private double speed; // in mph
     private double maxSpeed; // in mph
     
     /**
15      * Constructs a {@code Car} object with a specified
16      * maximum speed. The maximum speed of the object
17      * will default to zero if a negative value is given.
18      * @param maxSpeed the maximum speed of the {@code Car}.
		*

19      */
     public Car(double maxSpeed,boolean stops) {
         speed = 0;
         
         if(maxSpeed >= 0) {
             this.maxSpeed = maxSpeed;
         } // if
     } //Car

     public boolean speedUp(double amount) {
         boolean success = false;
         if(speed + amount <= maxSpeed) {
             speed += amount;
             success = true;
         } // if
         return success;
     } // speedUp

     public boolean slowDown(double amount) {
         boolean success = false;
         if(speed - amount >= 0) {
             speed -= amount;
             success = true;
         }
         return success;
     } // slowDown
     
     public boolean stop(boolean stops) {
    	 boolean success = false;
    	 
    	 if(stops = true) {
    		 speed -= speed;
    		 success = true;
    	 }else {
    		 speed -= 0;
    		 success = false;
    	 }
    	 
 
    	 return success;
     }
     
/**
46      * Returns a {@code String} representation of this {@code Car}
47      * in the format Car(speed: speed, maxspeed: maxSpeed)
48      *
49      * @return the {@code String} representation of this object.
50      */
     public String toString() {
         return String.format("Car(speed: %.2f, maxspeed: %.2f)", speed, maxSpeed);
     }
 } // Car

