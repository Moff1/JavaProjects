package cs1302.hw03.impl;
import cs1302.hw03.contract.Drivable;
/**
 * @author Moffatt
 *
 */
public class Truck implements Drivable {
	 private double speed; // in mph
     private double maxSpeed; // in mph

     /**
      * Constructs a {@code Truck} object with a specified
      * maximum speed. The maximum speed of the object
      * will default to zero if a negative value is given.
      * @param maxSpeed the maximum speed of the {@code Truck}
      */
     public Truck(double maxSpeed,boolean stops) {
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
    	 if(stops = true) {
    		 speed -= speed;
    	 }else {
    		 speed -= 0;
    	 }
    	 
 
    	 return stops;
     }
     
/**
      * Returns a {@code String} representation of this {@code Truck}
      * in the format Truck(speed: speed, maxspeed: maxSpeed)
      *
      * @return the {@code String} representation of this object.
      */
     public String toString() {
         return String.format("TRuck(speed: %.2f, maxspeed: %.2f)", speed, maxSpeed);
     }
 } // Car

