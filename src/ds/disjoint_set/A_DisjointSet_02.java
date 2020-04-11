package ds.disjoint_set;

import java.util.HashMap;

import ds.DisjointSet;

public class A_DisjointSet_02 {

	public static void main(String[] args) {
		int[] values = new int[] {3,2,1,99,4,5,100};
		HashMap<Integer, Integer> val2index = new HashMap<Integer, Integer>();
		for(int i = 0; i < values.length; i++) {
			val2index.put(values[i], i);
		}
		
		
		DisjointSet ds = new DisjointSet(values.length);
		for(int i = 0; i < values.length; i++) {
			Integer index1 = val2index.get(values[i] + 1);
			Integer index2 = val2index.get(values[i] - 1 );
			
			if(index1 != null) {
				ds.union(i, index1);
			}
			if(index2 != null) {
				ds.union(i, index2);
			}			
		}
		
		int maxSize = 0;
		int[][] cmps = ds.components();
		for(int[] cmp: cmps) {
			maxSize = Math.max(cmp.length, maxSize);
			System.out.println("");
			for(int ind: cmp) {
				System.out.println(values[ind]);
			}
		}
//		System.out.println(maxSize);
	}
	
}
