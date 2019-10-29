import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class FrequencyChangerTest {
	
	private ArrayList<String> readInputAsArrayOfStrings() throws FileNotFoundException{
		Scanner s = new Scanner(new File("inputFrequencyChanges.txt"));
	    ArrayList<String> list = new ArrayList<String>();
	    
	    while (s.hasNext()) {
	        list.add(s.next());
	    }
	    s.close();
		
	    return list;
	}
	
	private static int[] getInputAsArray(ArrayList<String> list) {
		int length = list.size();
		int[] newArray = new int[length];
		
		for (int i = 0; i <length; i++){
			newArray[i] = Integer.valueOf(list.get(i));
		}
		
		return newArray;
	}


	@Test
	void test() {
		FrequencyChanger freguencyChanger = new FrequencyChanger();
		
		int[] testArray = {+1,+1,-2};
		freguencyChanger.changeFrequencyNTimes(testArray);
		
		assert(freguencyChanger.getFrequency() == 0);
	}
	
	@Test
	void onlyNegativeInput() {
		FrequencyChanger freguencyChanger = new FrequencyChanger();
		
		int[] testArray = {-1,-2,-3};
		freguencyChanger.changeFrequencyNTimes(testArray);
		
		assert(freguencyChanger.getFrequency() == -6);
	}
	
	@Test
	void frequencyHits14Twice() {
		FrequencyChanger freguencyChanger = new FrequencyChanger();
		int[] testArray = {+7, +7, -2, -7, -4};
		freguencyChanger.changeFrequencyUntilFrequencyisTwice(testArray);
		assert(freguencyChanger.getFirstFrequencyToAppearTwice() == 14);
	}
	
	@Test
	void inputFileResultsIn525() throws FileNotFoundException {
		FrequencyChanger freguencyChanger = new FrequencyChanger();	
		ArrayList<String> myInputAsArrayList = readInputAsArrayOfStrings();
		int[] input = getInputAsArray(myInputAsArrayList);
		
		freguencyChanger.changeFrequencyNTimes(input);
	    assert(freguencyChanger.getFrequency() == 525);
		
	}
	
	@Test
	void inputFileResultsIn75749Twice() throws FileNotFoundException {
		FrequencyChanger freguencyChanger = new FrequencyChanger();
		ArrayList<String> myInputAsArrayList = readInputAsArrayOfStrings();
		int[] input = getInputAsArray(myInputAsArrayList);
		
		freguencyChanger.changeFrequencyUntilFrequencyisTwice(input);
	    assert(freguencyChanger.getFirstFrequencyToAppearTwice() == 75749);
	}

}
