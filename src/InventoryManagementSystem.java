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
	
	public void checkInputForDoublesAndTriples(ArrayList<String> input) {
		
		for(String string: input) {
			ArrayList<Character> chars = turnStringToList(string);
			checkTriplesAndDoubles(chars);
		}
		setCheckSum(getNumberOfDoubles(), getNumberOfTriples());
	}
	
	public void checkTriplesAndDoubles(ArrayList<Character> chars) {
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

}
