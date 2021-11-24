/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start

// Time Complexity: O(max(N1, N2)) where N1 is the length of num1 and N2 is the length of num2. Here we do max(N1, N2) iterations at most.
// Space Complexity: O(max(N1, N2)) because the length of the new string is at most max(N1, N2) + 1
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int pointer1 = num1.length() - 1;
        int pointer2 = num2.length() - 1;
        while (pointer1 >= 0 || pointer2 >= 0) {
            int value1 = pointer1 >= 0 ? num1.charAt(pointer1) - '0' : 0;
            int value2 = pointer2 >= 0 ? num2.charAt(pointer2) - '0' : 0;
            int value = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            result.append(value);
            pointer1--;
            pointer2--;
        }
        
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
// @lc code=end

