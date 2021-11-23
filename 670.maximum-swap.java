/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start


// Method: Greedy Algorithm
// Time Complexity: O(N) where N is the number of digit in the given number. Because we consider each digit only once.
// Space complexity: O(1) because we only allocate 10 space for the newly created array
class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int length = s.length();
        char[] charArray = s.toCharArray();
        int[] numberIndexArr = new int[10];
        for (int i = 0; i < length; i++) {
            numberIndexArr[charArray[i] - '0'] = i;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 9; j > charArray[i] - '0'; j--) {
                if (numberIndexArr[j] > i) {
                    swap(charArray, numberIndexArr[j], i);
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }

    public void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}
// @lc code=end

