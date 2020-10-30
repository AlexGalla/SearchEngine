package search;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    private SearchStrategy searchStrategy;

    public void setSearchStrategy() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Select a matching strategy: ALL, ANY, NONE");
            String strategyString = scanner.nextLine();
            switch (strategyString) {
                case "ANY":
                    searchStrategy = new AnySearchStrategy();
                    flag = false;
                    break;
                case "ALL":
                    searchStrategy = new AllSearchStrategy();
                    flag = false;
                    break;
                case "NONE":
                    searchStrategy = new NoneSearchStrategy();
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input, try again...");
                    break;
            }
        }
    }

    public void search(ArrayList<String> array, String query) {
        searchStrategy.search(array, query);
    }
}
