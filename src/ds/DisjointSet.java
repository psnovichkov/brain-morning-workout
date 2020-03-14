package ds;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DisjointSet {
	private int[] parents;
	private int[] ranks;	
	
	public DisjointSet(int size) {
		parents = new int[size];
		ranks = new int[size];		
		for(int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	public void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return;
		if( ranks[xRoot] < ranks[yRoot] ) {
			parents[xRoot] = yRoot;
		} else if (ranks[xRoot] > ranks[yRoot]) {
			parents[yRoot] = xRoot;
		} else {
			parents[yRoot] = xRoot;
			ranks[xRoot] += 1;
		}
	}
	
	public int find(int x) {
		if( parents[x] != x) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}
	
	public int componentCount() {
		int count = 0;
		for(int i = 0; i < parents.length; i++) {
			if(parents[i] == i) {
				count++;
			}
		}
		return count;
	}
	
	public int[][] components(){
		Map<Integer, List<Integer>> root2items = new HashMap<>();
		for(int i = 0; i < parents.length; i++) {
			int root = find(i);
			List<Integer> items = root2items.get(root);
			if(items == null) {
				items = new ArrayList<Integer>();
				root2items.put(root, items);
			}
			items.add(i);
		}
		
		int[][] components = new int[root2items.size()][];
		int index = 0;
		for(List<Integer> items: root2items.values()) {
			components[index++] = items.stream().mapToInt(x->x).toArray();
		}
		return components;
	}

	@Override
	public String toString() {
		return Arrays.stream(parents)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining( "," ));
	}
}
