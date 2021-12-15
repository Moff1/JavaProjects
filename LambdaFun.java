/**
 * 
 */
package cs1302.hw06;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Function;
import java.lang.Exception;
/**
 * @author Moffatt
 *
 */
public class LambdaFun {
	private static Scanner input  = new Scanner(System.in);
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] myStrings = new String[] {
				"CSCI", "1302", "is", "an","awesome","course!","Lambda","expressions","scare","me","but","I","will","perservere"
		};
		Email[] inbox = new Email[] {
			new Email("bjb211@uga.edu","yellowjacket@gatech.edu",LocalDate.of(2019, 2,4),"Go GA Tech!"),
			new Email("bjb211@uga.edu","yellowjacket@gatech.edu",LocalDate.of(2019, 2,5),"Go GA Tech!"),
			new Email("bjb211@uga.edu","yellowjacket@gatech.edu",LocalDate.of(2019, 2,6),"Go GA Tech!"),
			new Email("bjb211@uga.edu","yellowjacket@gatech.edu",LocalDate.of(2019, 2,7),"Go GA Tech!"),
			new Email("bjb211@uga.edu","yellowjacket@gatech.edu",LocalDate.of(2019, 2,8),"Go GA Tech!"),
				
		};
		
		Predicate<String> p = (String t) -> {
			return t.contains("a");
		};
		
		Predicate<String> a = (String t) -> {
			return t.contains("b");
		};
		
		Predicate<String> b = (String t) -> {
			return t.contains("g");
		};

		
		printlnMatches(myStrings, p);
		printlnMatches(myStrings, a);
		printlnMatches(myStrings, b);
		
		//Checkpoint 2
		
		Predicate<Email> d = (Email t) -> {
			String string = t.getContents();
			return !string.contains("gatech.edu");
		};
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("CheckPoint 2 ");
		System.out.println(" ");
		System.out.println(" ");
		
		
		Function<Email, String> e = (Email t) -> {
			String contents = t.getContents();
			return contents;
		};
		
		Function<Email, String> f = (Email t) -> {
			String contents = t.getRecipient();
			return contents;
		};
		
		Function<Email, String> g = (Email t) -> {
			String contents = t.getSender();
			return contents;
		};
		
	    printlnMappedMatches(inbox,d,e);
		printlnMappedMatches(inbox,d,f);
		printlnMappedMatches(inbox,d,g);
		

	} //main
	private static <T> void printlnMatches(T[] t, Predicate<T> p) {
		if (p == null) {
			throw new NullPointerException("Predicate cannot be null");
		} else {
		for (T element: t) {
				if (p.test(element) == true) {
					System.out.println(element);
				}
		}
		
	}
	} //printlnMatches
	private static <T> void printlnMappedMatches(T[] t, Predicate<T> p, Function<T,String> f) {
		if (p == null) {
			throw new NullPointerException("Predicate cannot be null");
		} else {
		for (T element:t) {
				if (p.test(element) == true) {
					System.out.println(f.apply(element));
					
					
				}
		}
		
		
	}

} //printlnMappedMatches
} //LambdaFun

