import java.sql.ClientInfoStatus;
import java.util.*;

public class Zigzag {
    public int[] create(int n) {
        int[] res = {};
        // TODO
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                res = Arrays.copyOf(res, res.length + 1); //create new array from old array and allocate one more element
                res[res.length - 1] = i;
            } else {
                int[] newList = Arrays.copyOf(res, res.length + 1); //create new array from old array and allocate one more element
                newList[0] = i;
                System.arraycopy(res, 0, newList, 1, res.length);
                res = newList;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Zigzag z = new Zigzag();
        System.out.println(Arrays.toString(z.create(1))); // [1]
        System.out.println(Arrays.toString(z.create(2))); // [1,2]
        System.out.println(Arrays.toString(z.create(3))); // [3,1,2]
        System.out.println(Arrays.toString(z.create(4))); // [3,1,2,4]
        System.out.println(Arrays.toString(z.create(5))); // [5,3,1,2,4]
    }
}