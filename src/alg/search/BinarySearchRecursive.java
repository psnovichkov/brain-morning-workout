package alg.search;

/**
 * 
 * 
 * @author psnovichkov
 *
 */
public class BinarySearchRecursive {
	public int search(int[] vals, int val) {
		if(vals == null) return -1;
		return search(vals, 0, vals.length - 1, val);
	}

	private int search(int[] vals, int left, int right, int val) {
		if(left > right) return -1;
		
		int mid = (left + right)/2;
		if(val < vals[mid]) {
			return search(vals, left, mid - 1, val);
		} else if (val > vals[mid]) {
			return search(vals, mid + 1, right, val);
		}
		return mid;
	}
}
