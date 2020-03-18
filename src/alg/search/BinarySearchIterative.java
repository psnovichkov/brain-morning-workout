package alg.search;

/**
 * 
 * @author psnovichkov
 *
 */
public class BinarySearchIterative {

	public int search(int[] vals, int val) {
		if(vals == null ) {
			return -1;
		}
		
		int left = 0;
		int right = vals.length - 1;
		
		while(left < right) {
			int mid = (left + right)/2;
			if (val < vals[mid] ) {
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
