import java.util.stream.IntStream;

public class Sequence {
    public int generate(int n) {
        // TODO
        return generateNumber(n, 10);
    }

    public int generateNumber(int n, Integer lastNumber) {
        int howMany = 0;
        while (howMany < n) {
            int count = 0;

            lastNumber++;
            String resultAsString = lastNumber.toString();


            for (int i = 0; i < resultAsString.length(); i++) {
                count = 0;
                char curChar = resultAsString.charAt(i);
                
                for (int j = 0; j < resultAsString.length(); j++) {
                    char nextChar = resultAsString.charAt(j);
                    if (curChar == nextChar) count++;

                    if (count == 2) {
                        break;
                    }
                }
                if (count == 2) {
                    howMany++;
                    break;
                }
            }
        }
        return lastNumber;
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        System.out.println(s.generate(1)); // 11
        System.out.println(s.generate(2)); // 22
        System.out.println(s.generate(3)); // 33
        System.out.println(s.generate(10)); // 100
        System.out.println(s.generate(123)); // 505
    }
}