import java.util.ArrayList;
import java.util.Collections;

public class InventoryManagementSystem {
	private int checkSum;
	private int numberOfDoubles;
	private int numberOfTriples;
	
	InventoryManagementSystem() {
		checkSum = 0;
		numberOfDoubles = 0;
		numberOfTriples = 0;
	}
	
	private ArrayList<Character> turnStringToList(String stringToConvert) {
		ArrayList<Character> listOfChars = new ArrayList<Character>();
		
        for (char ch : stringToConvert.toCharArray()) { 
        	  
        	listOfChars.add(ch); 
        } 
        
        return listOfChars;
	}
	
	void checkInputForDoublesAndTriples(ArrayList<String> input) {
		
		for(String string: input) {
			ArrayList<Character> chars = turnStringToList(string);
			checkTriplesAndDoubles(chars);
		}
		setCheckSum(getNumberOfDoubles(), getNumberOfTriples());
	}
	
	void checkTriplesAndDoubles(ArrayList<Character> chars) {
		ArrayList<Character> triples = new ArrayList<Character>();
		ArrayList<Character> doubles = new ArrayList<Character>();
		boolean gotDoubles = false;
		boolean gotTriples = false;
		
		for (int i = 0; i < chars.size(); i++) {
			
			if ( (Collections.frequency(chars, chars.get(i))) == 3 ){
				triples.add(chars.get(i));   
			    gotTriples = true;
			}
			
			else if ( (Collections.frequency(chars, chars.get(i))) == 2 ){
				doubles.add(chars.get(i));		    
			    gotDoubles = true;
			}
			else {
				
			}
			
		}
		
		if (gotDoubles) {
			numberOfDoubles++;
		}
		
		if (gotTriples) {
			numberOfTriples++;
		}
	}
	
	private void setCheckSum(int numberOfDoubles, int numberOfTriples) {
		checkSum = numberOfDoubles * numberOfTriples;
	}
	
	public int getNumberOfDoubles() {
		return numberOfDoubles;
	}
	
	public int getNumberOfTriples() {
		return numberOfTriples;
	}
	
	public int getCheckSum() {
		return checkSum;
	}
	
	String findCorrectCheckID(ArrayList<String> list) {
		String result = "";
		
		while(!list.isEmpty()) {
			String firstElemInList = list.get(0);
			list.remove(0);
			String temp = findStringWithMostCommonChars(firstElemInList, list);
			
			if (temp.length() > result.length()) {
				result = temp;
			}
		}
		
		return result;
		
	}
	
	String findStringWithMostCommonChars(String stringToCompare, ArrayList<String> list) {
		
		String result = "";
		int noOfCommons = 0;
		
		for (int i = 0; i < list.size(); i++) {
			
			String temp = removeDiff(stringToCompare, list.get(i));
			
			if (temp.length() >= noOfCommons) {
				noOfCommons = temp.length();
				result = temp;
				
			}
		}
		
		return result;
	}
	
	
	String removeDiff(String string, String stringToCompare) {
		String result = "";
		
		for (int i = 0; i < stringToCompare.length(); i++) {
            if (string.charAt(i) == stringToCompare.charAt(i)) {
                result += string.charAt(i);
            }
		}
		
        return result;
	}


}
