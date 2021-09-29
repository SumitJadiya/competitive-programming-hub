package main.com.sumit.coding.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Problem URL : https://leetcode.com/problems/employee-importance/
 * */
public class EmployeeImportanceProblem {
    HashMap<Integer, Employee> map;

    public static void main(String[] args) {

        int id = 1;
        List<Employee> list = new ArrayList<>();
        Employee emp = new Employee();
        emp.id = 1;
        emp.importance = 5;
        emp.subordinates = new ArrayList<>(Arrays.asList(2, 3));
        list.add(emp);

        Employee emp2 = new Employee();
        emp2.id = 2;
        emp2.importance = 3;
        emp2.subordinates = new ArrayList<>();
        list.add(emp2);

        Employee emp3 = new Employee();
        emp3.id = 3;
        emp3.importance = 3;
        emp3.subordinates = new ArrayList<>();
        list.add(emp3);

        System.out.println(new EmployeeImportanceProblem().getImportance(list, id));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();

        for (Employee emp : employees)
            map.put(emp.id, emp);

        return dfs(id);
    }

    public int dfs(int id) {
        Employee emp = map.get(id);
        int ans = emp.importance;

        for (Integer sub : emp.subordinates)
            ans += dfs(sub);

        return ans;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
