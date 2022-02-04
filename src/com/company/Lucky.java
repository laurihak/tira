import java.util.Arrays;
import java.util.stream.Stream;

public class Lucky {
    public boolean check(int n) {
        Integer[] digits = Arrays.stream(Integer.toString(n).split("")).map(Integer::valueOf).toArray(Integer[]::new);

        int totalSum = Arrays.stream(digits).reduce(0, (acc, sum) -> acc + (sum));

        if (totalSum % 7 == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Lucky l = new Lucky();
        System.out.println(l.check(14)); // false
        System.out.println(l.check(16)); // true
        System.out.println(l.check(123)); // false
        System.out.println(l.check(777)); // true
        System.out.println(l.check(9999999)); // true
    }
}
