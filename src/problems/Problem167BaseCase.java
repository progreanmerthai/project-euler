package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem167BaseCase {
	
	public static void main(String[] args) {
		/**
		 * ER KUN 2 PARTALL PER SEKVENS
		 */
		
		for (int n = 2; n <= 10; n++) {
			List<Integer> Us = getFirstUs(2, 2*n+1, 100);
			
			System.out.println(Us.get(0));
			System.out.println(Us);
			
			break;
		}
	}
	
	public static List<Integer> getFirstUs(int a, int b, int count) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		reccurse(list, b, 1, count-1);
		return list;
	}

	private static void reccurse(List<Integer> U, int last, int n, int limit) {
		if (n == limit) {
			return;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < U.size(); i++) {
			int u1 = U.get(i);
			for (int j = i+1; j < U.size(); j++) {
				int u2 = U.get(j);
				if (u1 + u2 <= last)
					continue;
				int un = u1 + u2;
				map.put(un, (map.containsKey(un) ? map.get(un)+1 : 1));
			}
		}
		
		int newLast = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> u: map.entrySet()) {
			if (u.getValue() == 1) {
				newLast = Math.min(newLast, u.getKey());
			}
		}
		U.add(newLast);
		reccurse(U, newLast, n+1, limit);
	}
}
