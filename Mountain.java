//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class Mountain {
    public static void main(String[] args) {
            int[] arr = {0,2,1,0};
            System.out.println(peakIndexInMountainArray(arr));
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
}
