package hot100.Solution12;

public class Solution {
    public boolean isOk(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] a = new int[100];
        int[] b = new int[100];
        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i) - 'A']++;
        }
        int left = 0;
        String min = s;
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'A']++;
            while (isOk(a, b) && left <= i) {
                if (i - left + 1 < min.length()) min = s.substring(left, i + 1);
                a[s.charAt(left) - 'A']--;
                left++;
            }
        }
        if (left == 0) return "";
        return min;

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}