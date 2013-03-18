import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triplets {
	
	
	
	public static void main(String[] args) {
		List<int[]> answers = Triplets.pythagoreanTripplets(new int[]{6,3,4,2,5,1});
		for(int[] ans : answers){
			for(int a : ans){
				System.out.print(a);
				System.out.print(" ,");
			}
			
		}
		System.out.println(" ** ");
		answers = Triplets.pythagoreanTripplets(new int[]{6,3,4,2,5,1,12, 13});
		for(int[] ans : answers){
			for(int a : ans){
				System.out.print(a);
				System.out.print(" ,");
			}
			System.out.println(" *** ");
		}
			
	}

	public static List<int[]> pythagoreanTripplets(int[] input) {
		List<int[]> answers = new ArrayList<int[]>();
		Map<Long, Integer> map = new HashMap<Long, Integer>();

		for (int i = 0; i < input.length; i++) {
			map.put((long) input[i] * (long) input[i], input[i]);
		}

		Long[] unique = (Long[]) map.keySet().toArray(new Long[0]);
		Arrays.sort(unique);
		long comps = 0;
		for (int i = 1; i < unique.length; i++) {
			Long halfC = unique[i] / 2;
			for (int j = i - 1; j >= 0; j--) {

				if (unique[j] < halfC)
					break;
				if (map.containsKey(unique[i] - unique[j])) {
					answers.add(new int[] { map.get(unique[i] - unique[j]),
							map.get(unique[j]), map.get(unique[i]) });
				}
			}
		}
		return answers;
	}
}