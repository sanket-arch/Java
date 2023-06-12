import java.util.*;

class MapCollection {
    public static void main(String args[]) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(100, "Amit");
        map.put(101, "Vijay");
        map.put(102, "Rahul");
        map.put(104, "Rahul");
        for (Map.Entry<Integer, String> m : map.entrySet()) {
            System.out.println(m);
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        .forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(System.out::println);
    }

}