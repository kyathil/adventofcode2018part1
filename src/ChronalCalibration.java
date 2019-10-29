import java.util.ArrayList;

public class ChronalCalibration {
	private int currentFrequency;
	private boolean isFirst; 
	private int firstFrequency;
	ArrayList<Integer> frequencies;
	
	ChronalCalibration(){
		currentFrequency = 0;
		isFirst = false;
		firstFrequency = 0;
		frequencies = new ArrayList<Integer>();
	}
	
	private void changeFrequency(int n) {
		currentFrequency += n;
		
	}
	
	void changeFrequencyNTimes(int[] n) {
		
		for (int i = 0; i < n.length; i++) {
			
			changeFrequency(n[i]);
			
			if(frequencies.contains(currentFrequency) && (isFirst == false)) {
				firstFrequency = currentFrequency;
				isFirst = true;
			}
			
			frequencies.add(currentFrequency);
		}

	}
	
	void changeFrequencyUntilFrequencyisTwice(int[] n) {
		
		while(!isFirst) {
			changeFrequencyNTimes(n);
		}
		
	}
	
	public int getFrequency() {
		return currentFrequency;
	}
	
	public int getFirstFrequencyToAppearTwice() {
		return firstFrequency;
	}
	

}
