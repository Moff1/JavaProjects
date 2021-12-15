package cs1302.hw03.contract;

  /**
   * Represents the interface for an object that is drivable.
   * Drivable objects can {@code speedUp} and {@code slowDown}.
   * Drivable objects can also come to {@code stop}.
   */
public interface Drivable {

      /**      * Increases the speed of the object by the specified amount.
      * @param amount the specified amount in mph
      * @return true when the operation was successful; false otherwise
      */
     public boolean speedUp(double amount);

     /**
      * Decreases the speed of the object by the specified amount.
      * @param amount the specified amount in mph
      * @return true when the operation was successful; false otherwise
      */
     public boolean slowDown(double amount);
     /**
      * When the vehicle has stopped (or when the mph hits 0) it prints out a message
      * @return true when the certain conditions are met; otherwise it prints another message if conditions aren't met
      * 
      */

     
     public boolean stop(boolean stops);
     
     
 } // Drivable

