package distance;

import java.util.Arrays;

/**
 * Created by cdyujing7 on 2018/8/3.
 * 字符串Levenshtein距离：从一个字符串转化为另一个字符串所需要的最少编辑次数
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "ab"));
        System.out.println(levenshteinDistance("abc", "acb"));
        System.out.println(levenshteinDistance("abc", "abd"));
        System.out.println(levenshteinDistance("abc", "bab"));
    }

    private static int row = 50;
    private static int column = 50;
    private static int[][] distance = new int[row][column];

    public static int levenshteinDistance(String one, String two) {
        if (one == null || one.isEmpty() || two == null || two.isEmpty()) {
            return -1;
        }
        if (one.length() > Integer.MAX_VALUE || two.length() > Integer.MAX_VALUE) {
            return -1;
        }
        if (one.length() > row || two.length() > column) {
            distance = new int[one.length()][two.length()];
        } else {
            Arrays.fill(distance, 0);
        }
        for (int i = 0; i<one.length(); i++) {
            for (int j=0;j<two.length();j++) {
                if (i == 0) {
                    distance[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    distance[i][j] = i;
                    continue;
                }
                if (one.charAt(i) == two.charAt(j)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i][j-1], distance[i-1][j]), distance[i-1][j-1]) + 1;
                }
            }
        }
        return distance[one.length() - 1][two.length() - 1];
    }

}
