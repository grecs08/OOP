package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Your name and id here
 * @version 2022-09-23
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {
	boolean allDig = false;
	if (str.matches("[0-9]+")) {
	    allDig = true;
	}
	return allDig;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {
	boolean validSn = false;
	int size = sn.length();

	if (size == 11) {
	    String snaux = sn.substring(0, 3);
	    String d1 = sn.substring(3, 7);
	    String schar = sn.substring(7, 8);
	    String d2 = sn.substring(8, 11);
	    if (snaux.equals("SN/") && d1.matches("[0-9]+") && schar.equals("-") && d2.matches("[0-9]+")) {
		validSn = true;
	    }
	}

	return validSn;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	boolean validSn;

	while (fileIn.hasNextLine()) {
	    String Sn = fileIn.nextLine();
	    validSn = validSn(Sn);
	    if (validSn == true) {
		goodSns.println(Sn);
	    } else {
		badSns.println(Sn);
	    }
	}

	return;
    }

}
