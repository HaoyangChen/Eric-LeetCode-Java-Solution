/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start

// Method: Comparator
// Let N be the number of logs in the list and M be the maximum length of a single log
// Time Complexity: O(M * N * logN) the time complexity of the Arrays.sort() is O(N⋅logN). For each invocation of the compare() function, it can take up to O(M) time since we compare the contents of the logs
// Space Complexity: O(M * logN) - for each invocation of the compare() function, we would need up to O(M) space to hold the parsed logs. 
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                }

                if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}
// @lc code=end

