import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class InventoryManagementSystemTest {
	
	private ArrayList<String> readInputAsArrayOfStrings() throws FileNotFoundException{
		Scanner s = new Scanner(new File("InventoryManagementSystemInput.txt"));
	    ArrayList<String> list = new ArrayList<String>();
	    
	    while (s.hasNext()) {
	        list.add(s.next());
	    }
	    s.close();
		
	    return list;
	}
	
	private ArrayList<Character> turnStringToList(String stringToConvert) {
		ArrayList<Character> listOfChars = new ArrayList<Character>();
		
        for (char ch : stringToConvert.toCharArray()) { 
        	  
        	listOfChars.add(ch); 
        } 
        
        return listOfChars;
	}

	@Test
	void no_doubles_or_triples() {
		InventoryManagementSystem inventory = new InventoryManagementSystem();
		String testCode = "abcdef";
		ArrayList<Character> chars = turnStringToList(testCode);
		inventory.checkTriplesAndDoubles(chars);
		
		
		assert((inventory.getNumberOfDoubles() == 0 && inventory.getNumberOfTriples() == 0));
	}
	
	@Test
	void contains_doubles_no_triples() {
		InventoryManagementSystem inventory = new InventoryManagementSystem();
		String testCode = "abbcde";
		ArrayList<Character> chars = turnStringToList(testCode);
		inventory.checkTriplesAndDoubles(chars);
		
		
		assert(inventory.getNumberOfDoubles() > 0 && inventory.getNumberOfTriples() == 0);
	}
	
	@Test
	void contains_triples_no_doubles() {
		InventoryManagementSystem inventory = new InventoryManagementSystem();
		String testCode = "abcccd";
		ArrayList<Character> chars = turnStringToList(testCode);
		inventory.checkTriplesAndDoubles(chars);
		
		
		assert(inventory.getNumberOfDoubles() == 0 && inventory.getNumberOfTriples() > 0);
	}
	
	@Test
	void total_checkSum_for_arrayList_of_strings() {
		InventoryManagementSystem inventory = new InventoryManagementSystem();
		ArrayList<String> myTestList = new ArrayList<String>();
		
		myTestList.add("abcdef");
		myTestList.add("bababc");
		myTestList.add("abbcde");
		myTestList.add("abcccd");
		myTestList.add("aabcdd");
		myTestList.add("abcdee");
		myTestList.add("ababab");
		
		inventory.checkInputForDoublesAndTriples(myTestList);
		
		
		assert(inventory.getNumberOfDoubles() > 0 && inventory.getNumberOfTriples() > 0);
		assert(inventory.getCheckSum() == 12);
	}
	
	@Test
	void file_input() throws FileNotFoundException {
		InventoryManagementSystem inventory = new InventoryManagementSystem();
		ArrayList<String> myTestInput = readInputAsArrayOfStrings();
		inventory.checkInputForDoublesAndTriples(myTestInput);
		
		assert(inventory.getNumberOfDoubles() > 0 && inventory.getNumberOfTriples() > 0);
		assert(inventory.getCheckSum() == 5880);
	}

}
