import java.util.Arrays;
import java.util.List;

public class Wildcard {
    public static void ListSum(List<? extends Number> l) {
        int sum = 0;
        for (Number x : l) {
            sum += x.intValue();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {

        List<Integer> x = Arrays.asList(1, 2, 3, 4);
        Wildcard.ListSum(x);
    }
}
