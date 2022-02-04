public class Primes {
    public int count(int n) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            boolean fail = false;
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
//                    If n is dividable by anything else than 1 and its self its not prime number
                    fail = true;
                }
            }
            if (fail != true) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Primes p = new Primes();
        System.out.println(p.count(2)); // 1
        System.out.println(p.count(10)); // 4
        System.out.println(p.count(11)); // 5
        System.out.println(p.count(100)); // 25
        System.out.println(p.count(1000)); // 168
    }
}
