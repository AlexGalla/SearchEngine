package search;

import java.util.*;

public class AnySearchStrategy implements SearchStrategy{

    public AnySearchStrategy() {
        System.out.println("=== ANY Search strategy is chosen ===");
    }
    @Override
    public void search(ArrayList<String> array, String query) {
        Set<String> result = new TreeSet<>();
        Set<String> querySet = new TreeSet<>(Set.of(query.split(" ")));
        TreeMap<String, ArrayList<Integer>> invertedIndexMap = invertedIndex(array);

        for (String queryStr : querySet) {
            for (Map.Entry<String, ArrayList<Integer>> entry : invertedIndexMap.entrySet()) {
                if (entry.getKey().toLowerCase().equals(queryStr.toLowerCase())) {
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        result.add(array.get(entry.getValue().get(i)));
                    }
                }
            }
        }

        if (result.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(result.size() + " persons found:");
            for (String str : result) {
                System.out.println(str);
            }
        }
    }

    private TreeMap<String, ArrayList<Integer>> invertedIndex(ArrayList<String> array) {
        TreeMap<String, ArrayList<Integer>> invIndexMap = new TreeMap<>();
        for (int i = 0; i < array.size(); i++) {
            for (String str : array.get(i).split(" ")) {
                ArrayList<Integer> tempArray;
                if (invIndexMap.containsKey(str)) {
                    tempArray = invIndexMap.get(str);
                } else {
                    tempArray = new ArrayList<>();
                }
                tempArray.add(i);
                invIndexMap.put(str, tempArray);
            }
        }
        /*System.out.println("The Inverted Index Map: ");
        for (Map.Entry<String, ArrayList<Integer>> entry : invIndexMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }*/
        return invIndexMap;
    }
}
