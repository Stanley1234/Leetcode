/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    private Map<Integer, Employee> preprocess(List<Employee> employees) {
      Map<Integer, Employee> employeeMap = new HashMap<>();
      for (Employee employee : employees) {
         employeeMap.put(employee.id, employee);
      }
      return employeeMap;
   }

   public int getImportance(List<Employee> employees, int id) {
      // preprocess
      Map<Integer, Employee> employeeMap = preprocess(employees);
      
      
      // execute
      Set<Integer> visitedId = new HashSet<>();
      Stack<Employee> subordinates = new Stack<>();
      int totalImportance = 0;

      subordinates.add(employeeMap.get(id));
      while (!subordinates.isEmpty()) {
         Employee curEmployee = subordinates.pop();
         totalImportance += curEmployee.importance;

         for (int directSubordinate : curEmployee.subordinates) {
            if (visitedId.contains(directSubordinate)) {
               continue;
            }
            visitedId.add(directSubordinate);
            subordinates.push(employeeMap.get(directSubordinate));
         }
      }
      
      return totalImportance;
   }
}