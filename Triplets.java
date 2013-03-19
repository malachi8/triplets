import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triplets {
	
	
	
	public static void main(String[] args) {
		Triplets triplets = new Triplets();
		List<int[]> answers = triplets.findAndPrintPythagorusTriplets(new int[]{6,3,4,2,5,1});
		
		answers = triplets.findAndPrintPythagorusTriplets(new int[]{6,3,4,2,5,1,12, 13});
		
		answers = triplets.findAndPrintPythagorusTriplets(new int[]{6,3,4,2,5,1,12,13,12,6,8,2,10,2,24,26});
			
	}
	
	public List<int[]> findAndPrintPythagorusTriplets(int[] input) {
		List<int[]> answers = pythagorusTriplets(input);
		
		System.out.print("input:[");
		int count = 0;
		for(int i : input){
				if(count > 0)
					System.out.print(" ,");
				
				System.out.print(i);				
				count++;
		}
		System.out.println("]");
		
		
		for(int[] ans : answers){
			count = 0;
			System.out.print("answer: [");
			for(int a : ans){
				if(count > 0)
					System.out.print(" ,");
				
				System.out.print(a);				
				count++;
			}
			System.out.println("]");
			
		}
		
		return answers;
	}

	public List<int[]> pythagorusTriplets(int[] input) {
		List<int[]> answers = new ArrayList<int[]>();
		Map<Long, Integer> map = new HashMap<Long, Integer>();

		// collect all the squares into a map 
		// key -> i squared value -> i
		for (int i = 0; i < input.length; i++) {
			map.put((long) input[i] * (long) input[i], input[i]);
		}

		// copy all the unique squares into an array
		Long[] unique = (Long[]) map.keySet().toArray(new Long[0]);
		
		// sort unique squares
		Arrays.sort(unique);
		
		
		long comps = 0;
		
		// loop thru squares
		for (int i = 1; i < unique.length; i++) {
			
			// get square / 2
			Long halfC = unique[i] / 2;
			
			// loop thru squares smaller than unique[i]
			for (int j = i - 1; j >= 0; j--) {

				// each triplet first candidate must be at least
				// greater equal unique[i] / 2 else wont total
				if (unique[j] < halfC)
					break;
				
				// if the map of squares contains difference
				// between unique[i] - unique[j] then there is a triplet
				if (map.containsKey(unique[i] - unique[j])) {
					answers.add(new int[] { map.get(unique[i] - unique[j]),
							map.get(unique[j]), map.get(unique[i]) });
				}
			}
		}
		return answers;
	}
}