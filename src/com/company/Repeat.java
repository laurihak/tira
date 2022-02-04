import java.util.HashMap;
import java.util.Map;

public class Repeat {
    public int find(String s) {
        HashMap<String, String> map = new HashMap<String, String>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));
            String found = map.get(currentChar);
            if (found == null) {
                map.put(currentChar, currentChar);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Repeat r = new Repeat();
        System.out.println(r.find("aaa")); // 1
        System.out.println(r.find("abcd")); // 4
        System.out.println(r.find("abcabcabcabc")); // 3
        System.out.println(r.find("aybabtuaybabtu")); // 7
        System.out.println(r.find("abcabca")); // 7
    }
}