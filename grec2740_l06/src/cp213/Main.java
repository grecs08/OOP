package cp213;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * @param args unused
     */
    public static void main(String[] args) {
	System.out.println("Test scannerTest");
	System.out.println();
	Scanner keyboard = new Scanner(System.in);
	int total = scannerTest(keyboard);
	keyboard.close();
	System.out.println("Total: " + total);
	System.out.println();

	System.out.print("Test stringPrinter");
	System.out.println();

	try {
	    String output = stringPrinter(5, "*");
	    System.out.println(output);
	    output = stringPrinter(-5, "*");
	    System.out.println(output);
	} catch (Exception e) {
	    System.out.println();
	    System.out.println("getMessage:");
	    System.out.println(e.getMessage());
	    System.out.println();
	    System.out.println("toString:");
	    System.out.println(e.toString());
	    System.out.println();
	    System.out.println("printStackTrace:");
	    e.printStackTrace();
	}
    }

    /**
     * Uses exceptions to capture bad input from a keyboard Scanner.
     *
     * @return The total of all the integers entered.
     */
    public static int scannerTest(final Scanner keyboard) {

	int in, total = 0;
	String q = "Quit";
	boolean status = true;

	while (status != false) {
	    System.out.println("Enter an integer ('Quit to stop'): ");

	    try {
		in = keyboard.nextInt();
		total += in;
	    } catch (InputMismatchException e) {
		if (keyboard.next().equals(q)) {
		    status = false;
		} else {
		    System.out.println("This is not an integer!");
		}

	    }
	}
	keyboard.close();

	return total;
    }

    /**
     * Repeats a string.
     *
     * @param n   Number of times to repeat a string.
     * @param str The string to print.
     * @return The repeated string.
     * @throws Exception If n is negative.
     */
    public static String stringPrinter(int n, String str) throws Exception {

	String result = "";

	if (n < 0) {
	    throw new Exception("Please Enter a Positive Number!");
	} else {
	    result = str;
	    for (int i = 1; i < n; i++) {
		result += str;
	    }
	}

	return result;
    }

}
