
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GetAllMaxSubstring {

    public static Set<String> getAllMaxSubstring(String s) {
        Set<String> result = new HashSet<>();
        int windowStart = 0, longest = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            if (map.containsKey(s.charAt(windowEnd))) {
                windowStart = Math.max(windowStart, map.get(s.charAt(windowEnd)) + 1);
            }

            map.put(s.charAt(windowEnd), windowEnd);

            int currentLength = windowEnd - windowStart + 1;
            if (currentLength > longest) {
                longest = currentLength;
                result.clear();
                result.add(s.substring(windowStart, windowEnd + 1));
            } else if (currentLength == longest) {
                String candidate = s.substring(windowStart, windowEnd + 1);
                result.add(candidate);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abcbcadabcd";
        Set<String> result = getAllMaxSubstring(s);
        System.out.println("All longest substrings: " + result);
    }
}
