### Exercise: Employee Tasks

#### **Objective**: 
Implement an employee task management system where tasks are assigned to employees and tracked with priorities.

#### **Instructions**:
1. Create a `Task` class with the following fields:
   - `String taskName` (name of the task)
   - `int priority` (task priority)
   - `boolean completed` (status of the task)
   
2. Create an `Employee` class with the following fields:
   - `String name` (employee's name)
   - `SequencedSet<Task> tasks` (list of tasks assigned to the employee)
   
3. Implement methods in `Employee` to:
   - Add tasks to the employee's task list.
   - Mark tasks as completed.
   - Get tasks by priority using a **lambda expression** to sort by task priority.

4. Use a `SequencedMap<String, Employee>` to store employees by their name. Insert a few employees into the map, each with a set of tasks.
   
5. Implement a method to:
   - Filter tasks by completion status using **Streams** (e.g., all tasks that are not completed).
   - Sort tasks by priority and display them in **insertion order** and **reverse order**.

6. Use **lambdas** to display tasks sorted by priority, and another lambda to filter and display only completed tasks.
