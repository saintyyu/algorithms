package heap;

/**
 * Created by cdyujing7 on 2018/8/13.
 */
public class maxHeadHeap {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        creatHeap(nums);
        sortHeap(nums);//从小到大
        System.out.println(nums[0]);
    }

    public static void sortHeap(int[] nums) {
        if (nums != null && nums.length > 0) {
            int lengh = nums.length;
            while (lengh > 1) {
                int tmp = nums[0];
                nums[0] = nums[lengh - 1];
                nums[lengh - 1] = tmp;//第一个和最后一个换
                lengh--;
                int index = 1;
                changeOnce(nums, index, lengh);
            }

        }
    }

    public static void creatHeap(int[] nums) {
        if (nums != null && nums.length > 0) {
            int length = nums.length;
            int index = length/2;
            while (index > 0) {
                changeOnce(nums, index, length);
                index--;
            }
        }
    }


    public static void changeOnce(int[] nums, int index, int lengh) {

        boolean flag = true;
        while (flag) {
            while (flag) {
                if (2 * index < lengh) {//该节点有左右孩子
                    int tmp = nums[2*index -1] > nums[2*index] ? 2*index-1 : 2*index;
                    if (nums[index - 1] < nums[tmp]) {//需要交换
                        int value = nums[index - 1];
                        nums[index - 1] = nums[tmp];
                        nums[tmp] = value;
                        index = tmp + 1;
                    } else {
                        flag = false;
                    }
                } else if (2 * index == lengh) {//该节点只有左孩子
                    if (nums[index - 1] < nums[2 * index - 1]) {
                        int value = nums[index - 1];
                        nums[index - 1] = nums[2 * index - 1];
                        nums[2 * index - 1] = value;
                        index = 2*index;
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
        }
    }
}
