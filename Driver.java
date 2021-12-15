package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.p2.ArrayStringList;
import cs1302.p2.BaseStringList;
import cs1302.p2.LinkedStringList;
import cs1302.adt.Node;
import cs1302.adt.FancyStringList;

  /**
7   * This is simply a driver class to test the other classes I am going to be writing.
8   *
9   */

 public class Driver {
     public static void main(String[] args) {
      //StringList sl;  
      FancyStringList sl;
     // To test what the output is for your code, you can use ArrayStringList or Linked\StringList:
     // sl = new OracleStringList(); // uncomment to run the test cases using the oracle.
     sl = new ArrayStringList();
     //fs = new ArrayStringList();// uncomment to run the test cases using your implementation
     //sl = new LinkedStringList(); // uncomment to run the test cases using your implementation.

         // Test isEmpty on an empty list
         /*
         if (sl.isEmpty()) {
             System.out.println("isEmpty: Test Passed");
         } else {
             System.out.println("isEmpty: Test Failed");
            System.exit(0);
         } // if
*/       
     
         //System.out.println(sl.size());
         //sl.clear();
         sl.add(0,"WORKKKKK");
         sl.add(1,"Timothy");
         sl.add(2,"Sarah");
         sl.add(3,"Meegan");
         sl.add(4,"JohnJOhn");
         sl.add(5, "Optimus");
         sl.add(6, "Moffs");
         sl.add(7, "Moffset");
         sl.add(8, "Chilling");
         sl.add(9, "Wack");
         sl.add(10, "Work");
         sl.add(11, "Please");
         
         //System.out.println(sl.size());
         sl.prepend("Hello!!!");
         sl.append("Jex");
         System.out.println(sl.get(3));
         System.out.println(sl.remove(2));
         //fs.add(0,"WORKKKKK");
         //fs.add(1,"Timothy");
         //fs.add(2,"Sarah");
         //fs.add(3,"Meegan");
         //fs.add(4,"JohnJOhn");
         //fs.add(5, "Optimus");
         //fs.add(7, "Moffs");
         //fs.add(8, "Moffset");
         
         //System.out.println(sl.get(3));
         System.out.println(sl.contains​(4, "Meegan"));
         System.out.println(sl.indexOf​(4, "Moffset"));
         System.out.println(sl.reverse());
         //fs.clear();
         System.out.println(sl.slice(1,4));
         
         
         for (int i = 0; i < sl.size(); i++) {
        	 System.out.println(sl.get(i));
         }
         
         sl.clear();
         
         
         //System.out.println(sl.slice(3, 6));
         
         //System.out.println(sl.remove(6));
         
         
         
         //System.out.println(sl.makeString("$","!", "~"));
         //sl.clear();
     // more calls to test methods down here...
    
         
   } // main

 } // Driver

