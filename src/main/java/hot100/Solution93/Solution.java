package hot100.Solution93;

public class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = s.substring(0, 1);
        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = true;
            dp[i][i - 1] = s.charAt(i - 1) == s.charAt(i);
            if (result.length() == 1 && dp[i][i - 1]) result = s.substring(i - 1, i + 1);
            for (int j = i - 2; j >= 0; j--) {
                dp[i][j] = dp[i - 1][j + 1] && (s.charAt(j) == s.charAt(i));
                if(dp[i][j] && result.length() < i - j + 1) result = s.substring(j, i + 1);
            }
        }
        return result;


    }
}