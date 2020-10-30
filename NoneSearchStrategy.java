package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class NoneSearchStrategy implements SearchStrategy{
    public NoneSearchStrategy() {
        System.out.println("=== NONE Search strategy is chosen ===");
    }
    @Override
    public void search(ArrayList<String> array, String query) {
        Set<String> result = new TreeSet<>();

        for (String arrayString : array) {
            boolean flag = true;
            String[] words = arrayString.toLowerCase().split(" ");
            for (String queryWord : query.toLowerCase().split(" ")) {
                if (Arrays.asList(words).contains(queryWord)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(arrayString);
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
}
