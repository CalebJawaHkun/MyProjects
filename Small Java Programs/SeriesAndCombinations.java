import static java.lang.System.out;
import java.util.ArrayList;
import java.util.function.Function;
/*
total digits = 5
total series = 5 * 4 * 3 * 2 * 1 

total digits = 4
total series = 4 * 3 * 2 * 1

total digits = 3
total series = 3 * 2 * 1

Program Summary

This program tries to find the series or order of a given array of characters or a string.

The Logic begind the program is rather intricate. But the summary goes-
for a given array of characters e.g., 'abcd', 
the program wants to find every single combination it has. 

it will have 24 total series.
But we want the actual individual series rather than how many it has.


*/

public class SeriesAndCombinations {
	public static void main(String[] args) {
		
		// getRange(int from, int to)
		// getTheSorted(String chars, int thechar, int to) 
		Function<String, String> swapLastTwoChars = (chars) -> getTheSorted( chars, chars.length() - 1, chars.length() - 2 );

		String chars = "ad325";
		printTheSeries(getTheSeries(chars));
		out.println("Total Series " +calculateTotalSeries(chars.length()));

	}
                                                
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	private static int calculateTotalSeries(int totalDigits) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
		if(totalDigits != 0) {
			return totalDigits * calculateTotalSeries(totalDigits - 1);
		} else {
			return 1;
		}
		
	}

                                                                                                                                                                                                                                                                                                                         
	private static ArrayList<Integer> getCheckPoints(int totalChars) {
		ArrayList<Integer> checkPoints = new ArrayList<Integer>();

		int y = 0;
     
		for(int x = 2; x <= totalChars; ++x) {               
			checkPoints.add(calculateTotalSeries(x));

			out.println(
				String.format("Checkpoint at %d charactes : %d", x, checkPoints.get(y))                               
			);                                                        

			++y;                     
		}
		return checkPoints;
	}                                                            
	private static ArrayList<ArrayList<String>> getTheSeries(String chars) {

		ArrayList<ArrayList<String>> theSeries = new ArrayList<ArrayList<String>>();                                                                                
		int totalChars = chars.length();

		int to = 0;                                                                                                   
        // x represents where the character needs to go to.
        // y pepresents the character that will be moved at the momment.                                                                                                              
		for(int x = to; x < totalChars; x++) {
			
			ArrayList<String> toAdd = new ArrayList<String>();

			if(theSeries.isEmpty()) {
				for(int y = x; y < totalChars; y++) {
					toAdd.add(getTheSorted(chars, y, x));
				}
			} else {

				ArrayList<String> reference = theSeries.get((x - 1));
				
				for(String currentCombination : reference) {
					for(int y = x; y < totalChars; y++) {

						String theSorted = getTheSorted(currentCombination, y, x);

						if(theSorted.equals(currentCombination)) { continue; } // skip this chars if it were to be the same with whats been stored. 

						toAdd.add(theSorted);
					}
				}

			}

			theSeries.add(toAdd);
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
                                                                                                                                                                                                                                                                                               
		return theSeries;
	}

	private static void printTheSeries(ArrayList<ArrayList<String>> theSeries) {
		for(ArrayList<String> currentSet : theSeries) {
			for(String currentCombination : currentSet) {
				out.println(currentCombination);
			}

			out.println("---------------------------");
		}
	}
                      
    private static String getTheSorted(String chars, int thechar, int to) {
		if(thechar == to) { return chars; }

		char[] characters = changeDataType(chars);

		int swapFrequency = thechar - to;

		for(int x = thechar; x > to; x--) {
			int y = (x - 1);
			char temp = characters[x];
			characters[x] = characters[y];
			characters[y] = temp;

			//out.println("x: " +x +". y: " +y +". characters: " +changeDataType(characters));
		}

		return ( changeDataType(characters) );


	}

	private static char[] changeDataType(String chars)  {
		int totalChars = chars.length();
		char[] toReturn = new char[totalChars];

		for(int x = 0; x < totalChars; x++) {
			toReturn[x] = chars.charAt(x);
		}

		return (toReturn);
	}      

	private static String changeDataType(char[] chars) {
		String toReturn = "";
		for(int x = 0; x < chars.length; x++) {
			toReturn += chars[x];
		}

		return (toReturn);
	}         

	// below method finds the series between a certain number TO another. works both incrementaly and decrementally.
	private static int[] getRange(int from, int to) {

		int numOfCharsBetween = 0;
		int[] theRange = null;

		
		if(to > from) {
			numOfCharsBetween = (to - from) - 1;
			theRange = new int[numOfCharsBetween];
			// left to right -->
			int index = 0;
			for(int x = (from + 1); x < to; x++) {
				theRange[index] = x;
				++index;
			}
		} 		
		else if(to < from) {
			// right to left <--
			numOfCharsBetween = (from - to) - 1;
			theRange = new int[numOfCharsBetween];
			int index = 0;
			for(int x = (from - 1); x > to; x--) {
				theRange[index] = x;
				++index;
			}
		}
		
		return (theRange);
	}                                                                         
}               