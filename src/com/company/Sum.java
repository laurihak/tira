public class Sum {
    public int count(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        return result;
    }

    public static void main(String[] args) {
        Sum s = new Sum();
        System.out.println(s.count(1)); // 1
        System.out.println(s.count(2)); // 3
        System.out.println(s.count(3)); // 6
        System.out.println(s.count(10)); // 55
        System.out.println(s.count(123)); // 7626
    }
}
