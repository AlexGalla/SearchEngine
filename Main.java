package search;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> inputs = readArray(args[1]);
        //ArrayList<String> inputs = readArray("G:\\\\text.txt");
        menu(inputs);
    }

    public static void menu(ArrayList<String> array) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            //printAll(array);
            System.out.println();
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            String choise = scanner.nextLine();
            switch (choise) {
                case "1":
                    System.out.println();
                    SearchEngine searchEngine = new SearchEngine();
                    searchEngine.setSearchStrategy();
                    System.out.println("Enter a name or email to search all suitable people.");
                    String query = scanner.nextLine();
                    searchEngine.search(array, query);
                    break;
                case "2":
                    System.out.println();
                    printAll(array);
                    break;
                case "0":
                    flag = false;
                    System.out.println();
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Incorrect option! Try again");
                    break;
            }
        }
    }
    /***************************************************************************
    public static void search(ArrayList<String> array, String query) {
        Set<String> result = new TreeSet<>();
        TreeMap<String, ArrayList<Integer>> invertedIndexMap = invertedIndex(array);
        for (Map.Entry<String, ArrayList<Integer>> entry : invertedIndexMap.entrySet()) {
            if (entry.getKey().toLowerCase().equals(query.toLowerCase())) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    result.add(array.get(entry.getValue().get(i)));
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
    public static TreeMap<String, ArrayList<Integer>> invertedIndex (ArrayList<String> array) {
        TreeMap<String, ArrayList<Integer>> invIndexMap = new TreeMap<>();
        for (int i = 0; i < array.size(); i++) {
            for (String str : array.get(i).split(" ")) {
                if (invIndexMap.containsKey(str)) {
                    ArrayList<Integer> tempArray = invIndexMap.get(str);
                    tempArray.add(i);
                    invIndexMap.put(str, tempArray);
                } else {
                    ArrayList<Integer> tempArray = new ArrayList<>();
                    tempArray.add(i);
                    invIndexMap.put(str, tempArray);
                }
            }
        }
        System.out.println("The Inverted Index Map: ");
        for (Map.Entry<String, ArrayList<Integer>> entry : invIndexMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }        return invIndexMap;
    }
    ***********************************************************************************************/

    public static void printAll(ArrayList<String> array) {
        System.out.println("=== List of people ===");
        for (String str : array) {
            System.out.println(str);
        }
    }

    public static ArrayList<String> readArray(String fileName) {
        ArrayList<String> array = new ArrayList<>();
        Scanner scanner;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            scanner = new Scanner(fis);
            while (scanner.hasNext()) {
                array.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
        }
        return array;
    }
}
