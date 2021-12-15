/**
 * 
 */
package application;

import javafx.application.Application;

/**
 * Driver class for my Space Invaders Game.
 *
 */
public class SpaceInvadersDriver {
	
	/**
	 * Main entry point into the application.
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			Application.launch(SpaceInvaders.class, args);
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
			System.err.println();
			System.err.println(e);
			System.err.println("Display X Server Error");
			System.exit(1);
		} catch (RuntimeException re) {
			re.printStackTrace();
			System.err.println();
			System.err.println(re);
			System.err.println("Runtime Error");
			System.exit(1);
		} //try

	} //main

} //Driver
