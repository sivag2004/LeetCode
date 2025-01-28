//https://leetcode.com/problems/find-in-mountain-array/
public class SearchInMountain {
    public static void main(String[] args) {
        int[] mountainArr = {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println(search(mountainArr,target));

    }
    static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticsBS(arr, target,0,peak);
        if(firstTry != -1){
            return firstTry;
        }
        // try to search in second half
        return orderAgnosticsBS(arr, target, peak+1,arr.length-1);
    }
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]){
                //You are the decreasing part of the array
                //this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in ascending part of the array
                start = mid + 1;
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what check said
        // more elaboration: at every point of time for start and end, they have the best possible answer till the time
        //and if we are saying that only one item is remaining, hence cause of above line that is the best possible answer
        return start; //or return end as both are equal
    }
    static int orderAgnosticsBS(int[] arr, int target,int start, int end){
        //find whether the array is sorted in ascendng or descending
        boolean isAsc = arr[start]<arr[end];
        while (start <= end){
            //find the middle element
            // int mid = (start + end)/2; //might be possible that (start + end) exceeds the range of the int in Java
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else  {
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
