import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Repeat {
    public int find(String s) {
        ArrayList<String> listOfWords = new ArrayList<>();
        int stringLength = s.length();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));

            if (i > 0) {
                String lastWord = listOfWords.get(i - 1);
                listOfWords.add(lastWord + currentChar);
            } else {
                listOfWords.add(currentChar);
            }
        }
// List of words that are dividable by original string
        List<String> filtered = listOfWords.stream().filter(word -> s.length() % word.length() == 0).collect(Collectors.toList());

        int lengthOfRepeatedWord = 0;

        for (int i = filtered.size() - 1; i >= 0; i--) {
            String currentWord = filtered.get(i);
            String repeatedWord = currentWord.repeat(stringLength / currentWord.length());

            if (repeatedWord.equals(s)) {
                lengthOfRepeatedWord = currentWord.length();
            }
        }

        return lengthOfRepeatedWord;
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