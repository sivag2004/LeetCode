import java.util.Arrays;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public static void main(String[] args) {
            int[] arr = {3,0,1};
            missingNumber(arr);
            System.out.println(Arrays.toString(arr));
    }
    static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // search for first missing number
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index){
                return index;
            }
        }
        return nums.length;
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
