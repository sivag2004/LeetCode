//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class SmallestLetter {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'j';
        char ans = nextGreatestLetter(arr,  target);
        System.out.println(ans);
    }
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end){
            //find the middle element
            // int mid = (start + end)/2; //might be possible that (start + end) exceeds the range of the int in Java
            int mid = start + (end - start) / 2;
            if(target < letters[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
