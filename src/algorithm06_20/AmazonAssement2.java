package algorithm06_20;

import java.util.*;

public class AmazonAssement2 {
 public static class PairString {
		String first;
		String second;

		public PairString(String first, String second) {
			this.first = first;
			this.second = second;
		}
	}

	public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
		HashMap<String, Integer> indexes = new HashMap<String, Integer>();
		int index = 0;
		int current = 0;
		List<SortedSet<String>> groups = new ArrayList<SortedSet<String>>();
		
		for (PairString item : itemAssociation) {
			// first pair item
			if (indexes.containsKey(item.first) || indexes.containsKey(item.second)) {
				current = indexes.getOrDefault(item.first, indexes.getOrDefault(item.second, index));
			} else {
				current = index;
				index++;
			}
			indexes.put(item.first, current);
			indexes.put(item.second, current);
			if (current < groups.size()) {
				groups.get(current).add(item.first);
				groups.get(current).add(item.second);
			} else {
				SortedSet<String> group = new TreeSet<String>();
				group.add(item.first);
				group.add(item.second);
				groups.add(group);
			}
		}
		
		Collections.sort(groups, (a,b)->{ 
			     if(b.size() == a.size()) {
			    	return a.toString().compareTo(b.toString());
			     }
			     return b.size() - a.size();});
		return new ArrayList<String>(groups.get(0));
	}

	public static void main(String[] args) {
		List<PairString> itemAssociation = new ArrayList<PairString>();
		itemAssociation.add(new PairString("item1","item2"));
		itemAssociation.add(new PairString("item3","item4"));
		itemAssociation.add(new PairString("item4","item5"));
		itemAssociation.add(new PairString("item1","item5"));
		itemAssociation.add(new PairString("item4","item6"));



		List<String> result = largestItemAssociation(itemAssociation);
		System.out.println("Result: "+result);
	}
}
