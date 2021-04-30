import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ 
    public static boolean contains(String[] array, String value) {
    	for(String str : array) {
    		if(str.equals(value)) {
    			return true;
    		}
    	}
    	
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */
    public static String[] reverse(String[] array) {
    	String temp;
    	
    	for(int i = 0, j = array.length - 1; i < j; i++, j--) {
    		temp = array[i];
    		array[i] = array[j];
    		array[j] = temp;
    	}
    	
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */
    public static boolean isPalindromic(String[] array) {
    	for(int i = 0, j = array.length - 1; i < j; i++, j--) {
    		if(!array[i].equals(array[j])) {
    			return false;
    		}
    	}
  
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ 
    public static boolean isPangramic(String[] array) {
    	boolean[] alphabet = new boolean[26];
    	char curr;
    	
    	for(String sentence : array) {
    		for(int i = 0; i < sentence.length(); i++) {
    			curr = sentence.charAt(i);
    			
    			if('a' <= curr && curr <= 'z') {
    				alphabet[curr - 'a'] = true;
    			}else if('A' <= curr && curr <= 'Z') {
    				alphabet[curr - 'A'] = true;
    			}
    		}
    	}
    	
    	for(boolean isUsed : alphabet) {
    		if(!isUsed) {
    			return false;
    		}
    	}
    	
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ 
    public static int getNumberOfOccurrences(String[] array, String value) {
    	int count = 0;
    	
    	for(String word : array) {
    		if(word.equals(value)) {
    			count++;
    		}
    	}
    	
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ 
    public static String[] removeValue(String[] array, String valueToRemove) {
    	int newIndex = 0;
    	
    	for(String word : array) {
    		if(!word.equals(valueToRemove)) {
    			array[newIndex++] = word;
    		}
    	}
    	
        return Arrays.copyOfRange(array, 0, newIndex);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ 
    public static String[] removeConsecutiveDuplicates(String[] array) {
    	String prev = "";
    	int resultSize = 0;
    	
    	for(String word : array) {
    		if(!word.equals(prev)) {
    			array[resultSize++] = word;
    			prev = word;
    		}
    	}
    	
        return Arrays.copyOfRange(array, 0, resultSize);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ 
    public static String[] packConsecutiveDuplicates(String[] array) {
    	int prevIndex = -1;
    	String cons = "";
    	
    	for(String character : array) {
    		if(character.equals(cons)) {
    			array[prevIndex] += character;
    		}else {
    			array[++prevIndex] = character;
    			cons = character;
    		}
    	}
    	
        return Arrays.copyOfRange(array, 0, prevIndex + 1);
    }


}
