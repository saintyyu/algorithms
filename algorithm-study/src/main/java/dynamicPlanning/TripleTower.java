package dynamicPlanning;

/**
 * Created by cdyujing7 on 2018/8/4.
 */
public class TripleTower {
    public static int level = 5;
    public static int[][] tower = new int[level][];
    public static int[] list = {9,12,15,10,6,8,2,18,9,5,19,7,10,4,16};

    public static void main(String[] args) {
        int index = 0;
        for (int i=0;i<level;i++) {
            int[] towerTwo = new int[i + 1];
            tower[i] = towerTwo;
            for (int j=0;j<=i;j++) {
                tower[i][j] = list[index];
                index++;
            }
        }
        for (int i=0;i<level;i++) {
            for (int j=0;j<=i;j++) {
                System.out.print(tower[i][j] + " ");
            }
            System.out.println();
        }

        int[][] towerAdd = new int[level][];
        for (int i=0;i<level;i++) {
            int[] towerAddTwo = new int[i + 1];
            towerAdd[i] = towerAddTwo;
            for (int j=0;j<=i;j++) {
                if (i == 0 && j == 0) {
                    towerAdd[i][j] = tower[i][j];
                    continue;
                }
                if (j == 0) {
                    towerAdd[i][j] = towerAdd[i - 1][j] + tower[i][j];
                    continue;
                }
                if (j == i) {
                    towerAdd[i][j] = towerAdd[i - 1][j - 1] + tower[i][j];
                    continue;
                }
                towerAdd[i][j] = Math.max(towerAdd[i -1][j-1], towerAdd[i-1][j]) + tower[i][j];
            }
        }

        for (int i=0;i<level;i++) {
            for (int j=0;j<=i;j++) {
                System.out.print(towerAdd[i][j] + " ");
            }
            System.out.println();
        }

        int max = 0;
        for (int i=0;i<level;i++) {
            max = Math.max(max, towerAdd[level - 1][i]);
        }
        System.out.println(max);
    }
}
