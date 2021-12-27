/*
 * @lc app=leetcode id=690 lang=java
 *
 * [690] Employee Importance
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> eMap;
    public int getImportance(List<Employee> employees, int id) {
        eMap = new HashMap();
        for (Employee e: employees) eMap.put(e.id, e);
        return getImportanceHelper(id);
    }
    
    private int getImportanceHelper(int id) {
        Employee employee = eMap.get(id);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates) {
            ans += getImportanceHelper(subid);
        }
        return ans;
    }
}
// @lc code=end

