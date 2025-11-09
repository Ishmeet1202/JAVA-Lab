public class StringMatching {

    public static void KMPMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[] pie = computePrefix(p);
        int q = 0;

        for (int i = 0; i < n; i++) {
            while (q > 0 && s.charAt(i) != p.charAt(q)) { 
                q = pie[q - 1];
            }

            if (s.charAt(i) == p.charAt(q)) {
                q++;
            }

            if (q == m) {
                System.out.println("Pattern occurs with shift : " + (i-m+1));
                q = pie[q-1];
            }
        }
    }
    
    
    public static int[] computePrefix(String p) {
        int m = p.length();
        int[] pie = new int[m];
        pie[0] = 0;
        int k = 0;

        for (int q = 1; q < m; q++) {
            while (k > 0 && p.charAt(q) != p.charAt(k)) {
                k = pie[k - 1];
            }

            if (p.charAt(q) == p.charAt(k)) {
                k++;
            }
            pie[q] = k;
        }

        return pie;
    }

    public static void main(String[] args) {
        String s = "abababdcabababd";
        String p = "ababd";

        KMPMatch(s, p);
    }
}