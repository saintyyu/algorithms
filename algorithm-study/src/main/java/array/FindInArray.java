package array;


import java.util.*;

/**
 * Created by cdyujing7 on 2018/8/12.
 */
public class FindInArray {

    public static void main(String[] args) {
        int[][] array = {{1, 4, 7, 10},{2,5,8,11},{3,6,9,12}};
        System.out.println(array.length);
        System.out.println(exist(array, 9));
        List<Double> list = new LinkedList<Double>();
        Stack<Double> stack = new Stack<Double>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> set = map.keySet();
        String[] strings = (String[]) set.toArray();
    }

    public static boolean exist(int[][] array, int index) {
        if (array == null) {
            return false;
        }
        int rowMax = array.length;
        int columnMax = array[0].length;
        int row = rowMax - 1;
        int column = 0;
        boolean flag = false;
        while (row >= 0 && column < columnMax) {
            if (array[row][column] == index) {
                flag = true;
                break;
            } else if (array[row][column] > index) {
                row--;
            } else {
                column++;
            }
        }
        return flag;
    }
}
