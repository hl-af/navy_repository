package leetcode;

public class L5_longestPalindrome {
    public static void main(String[] args){

    }
    public String longestPalindrome(String s) {
        int maxlength = 1;
        int begin = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                begin = i;
                maxlength = 2;
            }
        }
        for (int l = 3; l < s.length()-l; l++) {

            for (int i = 0; i < s.length(); i++) {
                int j = i+l-1;
                if (s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==1) {
                    dp[i][j] = 1;
                    int tmp = j-i+1;
                    if (tmp>maxlength) {
                        maxlength = tmp;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, maxlength);



    }
}
