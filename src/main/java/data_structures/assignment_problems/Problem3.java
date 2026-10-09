package data_structures.assignment_problems;
import java.util.HashMap;

public class Problem3 {
    static Object[] mostPopular(String[] orders) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String item : orders)
            map.put(item, map.getOrDefault(item, 0) + 1);

        String best = orders[0];
        int max = 0;

        for (String item : orders) {
            if (map.get(item) > max) {
                max = map.get(item);
                best = item;
            }
        }

        return new Object[]{best, max};
    }

    public static void main(String[] args) {
        String[] orders1 = {
            "dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"
        };
        Object[] result1 = mostPopular(orders1);
        System.out.println("(" + result1[0] + ", " + result1[1] + ")");

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        Object[] result2 = mostPopular(orders2);
        System.out.println("(" + result2[0] + ", " + result2[1] + ")");
    }
}