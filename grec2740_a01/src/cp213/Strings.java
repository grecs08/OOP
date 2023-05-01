package cp213;

/**
 * @author Your name and id here
 * @version 2022-09-23
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {
	boolean palindrome = true;
	int endRange;

	String newString = string.replaceAll("[^a-zA-Z]", "");
	newString = newString.toLowerCase();
	endRange = newString.length() - 1;

	for (int i = 0; i < newString.length(); i++) {
	    String first = String.valueOf(newString.charAt(i));
	    String last = String.valueOf(newString.charAt(endRange));

	    if (!(first.equals(last))) {
		palindrome = false;
	    }

	    endRange--;
	}

	return palindrome;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {
	boolean vName = false;
	int size = name.length();

	if (size > 0) {
	    String character = String.valueOf(name.charAt(0));
	    if (size == 1) {
		if (character.matches("[a-zA-Z]"))
		    ;
		vName = true;
	    } else {
		if (character.matches("[a-zA-Z_]")) {
		    if (character.matches("[a-zA-Z0-9_]"))
			;
		    vName = true;

		}

	    }
	}

	return vName;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {
	int i = 0;
	String pigLatin = "";
	String character = String.valueOf(word.charAt(i));

	if (character.matches("[aeiouAEIOU]")) {
	    pigLatin = word + "way";
	} else {
	    pigLatin = word;
	    while (true) {
		String auxCharacter = String.valueOf(word.charAt(i));
		if (!auxCharacter.matches("[aeiouAEIOU]") && i == 0) {
		    if (character.matches("[A-Z]")) {
			pigLatin = pigLatin.substring(1, 2).toUpperCase() + pigLatin.substring(2)
				+ auxCharacter.toLowerCase();
		    } else {
			pigLatin = pigLatin.substring(1, 2) + pigLatin.substring(2) + auxCharacter;
		    }
		} else if (!auxCharacter.matches("[aeiouyAEIOUY]") && i > 0) {
		    if (character.matches("[A-Z")) {
			pigLatin = pigLatin.substring(1, 2).toUpperCase() + pigLatin.substring(2)
				+ auxCharacter.toLowerCase();
		    } else {
			pigLatin = pigLatin.substring(1, 2) + pigLatin.substring(2) + auxCharacter;
		    }

		} else {
		    pigLatin = pigLatin + "ay";
		    break;
		}
		i++;
	    }
	}

	return pigLatin;
    }

}
