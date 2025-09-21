public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(char[] s1, char[] s2, int i, int j) {
        if (i == s1.length || j == s2.length) {
            return 0;
        } else if (s1[i] == s2[j]) {
            return 1 + longestCommonSubsequence(s1, s2, i + 1, j + 1);
        } else {
            return Math.max(longestCommonSubsequence(s1, s2, i + 1, j), longestCommonSubsequence(s1, s2, i, j + 1));
        }
    }

    public static void main(String[] args) {
        String a = "bd";
        String b = "abcd";

        System.out.println(longestCommonSubsequence(a.toCharArray(), b.toCharArray(), 0, 0));
    }
}