
import java.util.HashMap;
import java.util.Map;

public class GetMaxSubstring {

    public static String getMaxLenSubStr(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        
        int windowStart = 0;
        int longest = 0; 
        int longestStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }

            charIndexMap.put(rightChar, windowEnd);

            if (windowEnd - windowStart + 1 > longest) {
                longest = windowEnd - windowStart + 1;
                longestStart = windowStart;
            }
        }

        return s.substring(longestStart, longestStart + longest);
    }

    public static void main(String[] args) {
        System.out.println(getMaxLenSubStr("ddvdf"));
    }
}