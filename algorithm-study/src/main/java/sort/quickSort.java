package sort;

/**
 * Created by cdyujing7 on 2018/8/13.
 */
public class quickSort {

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};

        int i = 0;
        int j = array.length-1;
        quickSort(array, i, j);
        System.out.println(array.toString());

    }

    public static void quickSort(int[] array, int i, int j) {
        if (i < j) {
            int edge = partition(array, i, j);
            quickSort(array, i, edge - 1);
            quickSort(array, edge + 1, j);
        }
    }


    public static int partition(int[] array, int i, int j) {
        int tmp = array[i];

        while (i < j) {
            while (i < j && array[j] >= tmp) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
            }
            while (i < j && array[i] <= tmp) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[i] = tmp;
        return i;
    }
}
