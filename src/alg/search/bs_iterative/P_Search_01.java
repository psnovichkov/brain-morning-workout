package alg.search.bs_iterative;

/**
 * start 9:09:00 
 * end   9:10:25
 * @author psnovichkov
 *
 */
public class P_Search_01 {
	public int search(int[] vals, int val) {
		if(vals == null) return -1;
		
		int left = 0;
		int right = vals.length - 1;
		while(left < right) {
			int mid = (left + right)/2;
			if(val < vals[mid]) {
				right = mid - 1;
			} else if (val > vals[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}

		}
		return -1;
	}
}
