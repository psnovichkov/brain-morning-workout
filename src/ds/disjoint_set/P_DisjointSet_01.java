package ds.disjoint_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Start 8:02
 * End   8:13:59
 * @author psnovichkov
 *
 */
public class P_DisjointSet_01 {
	private int[] parents;
	private int[] ranks;
	
	public void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return;
		if(ranks[xRoot] < ranks[yRoot]) {
			parents[xRoot] = parents[yRoot];
		} else if (ranks[yRoot] < ranks[xRoot]) {
			parents[yRoot] = parents[xRoot];			
		} else {
			parents[xRoot] = parents[yRoot];
			ranks[xRoot] ++;
		}
	}
	
	public int find(int x) {
		while(parents[x] != x) {
			parents[x] = find(x);
		}
		return parents[x]; 
	}
	
	public int componentsCount() {
		int count = 0;
		for(int i = 0; i < parents.length; i++) {
			if(parents[i] == i) count ++;
		}
		return count;
	}
	
	
	public int[][] components(){
		Map<Integer, List<Integer>> root2Items = new HashMap<>();
		for(int i =0; i < parents.length; i++) {
			int root = find(i);
			List<Integer> items = root2Items.get(root);
			if(items == null) {
				items = new ArrayList<Integer>();
				root2Items.put(root, items);
			}
			items.add(i);
		}
		
		int[][] components = new int[root2Items.size()][];
		int index = 0;
		for(List<Integer> items: root2Items.values()) {
			components[index++] = items.stream().mapToInt(x->x).toArray();  
		}		
		return components;
	}
	
	public String toString() {
		return Arrays.stream(parents)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(","));
	}
}
