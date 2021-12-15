package cs1302.exceptions;

import cs1302.exceptions.Printer;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * A simpler version of the Unix <code>cat</code> command.
 * This modified, enhanced version of the cat code is supposed to handle exceptions
 * such as, ArrayOutOfBoundsErrors, and FileNotFound Errors. This {@code MyCat} should
 * allow the user more freedom.
 */
public class MyCat {

    /**
     * Entry point for the application. Exactly zero or one command-line arguments are expected.
     * If a filename is given as an argument, then the program should print the contents of that
     * file to standard output. If a single dash (i.e., "-") is given as an argument, then
     * the program should print the contents of standard input.
     *
     * @param args  the command-line arguments
     * With the exceptions statements should handle any error the machine @throws
     * FileNotFoundException - Happens when a file is not found or simply made up
     * ArrayIndexOutOfBoundsException if no command is given
     *
     */
	public static void main(String[] args) {
		
		if(args.length == 0) {
			
			System.out.println("Usage: MyCat [filename]...");
			
			/*throw new ArrayIndexOutOfBoundsException("Index 0 out of bounds for length 0");*/
		} else {
			
		for (int i = 0; i < args.length; i++) {
		 
		try {
			
			String filename = args[i];
	
			Scanner input = null;

			if (filename.equals("-")) {
				
				Printer.printStdInLines();
				
			} else {
				File file = new File(filename);
				
					Printer.printFileLines(file);
				}
			
				} catch (FileNotFoundException e) {
					
					System.out.println(e.getMessage());
        
				} catch (ArrayIndexOutOfBoundsException a) {
					
					System.err.println(a.toString());
				}
		
				System.out.println("Code did not produce an error!"); 

	} // For Statement
		
} //Else Statement

} // Main 
	
}// Class	
	
	
    
	
	
	
	
	
	
	
	
	
