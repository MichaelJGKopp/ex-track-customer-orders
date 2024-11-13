import java.util.LinkedHashMap;
import java.util.Random;
import java.util.SequencedMap;
import java.util.stream.Stream;

public class Main {

  private final static Random random = new Random();

  public static void main(String[] args) {

    SequencedMap<String, Employee> employeesMap = new LinkedHashMap<>();
    for (int i = 0; i < 20; i++) {  // populate map with 20 random employees and tasks
      Employee randomEm = randomEmployee();
      employeesMap.putLast(randomEm.getName(), randomEm);
    }

    employeesMap.values().stream()
      .limit(1)
      .forEach(System.out::println);

    Employee randomEm = randomEmployee();
    displayTasks("Completed Tasks",
      randomEm.tasksByCompletion(true).limit(3));
    displayTasks("Incomplete Tasks",
      randomEm.tasksByCompletion(false).limit(3));
    displayTasks("Tasks by Priority",
      randomEm.tasksByPriority().limit(3));
    displayTasks("Tasks by Insertion Order",
      randomEm.stream().limit(3));
    displayTasks("Tasks by Reverse Order",
      randomEm.getTasks().reversed().stream().limit(3));
    displayTasks("Completed Tasks by Priority",
      randomEm.tasksByPriority().filter(Task::isCompleted).limit(3));
    displayTasks("Incomplete Tasks by Priority",
      randomEm.tasksByPriority().filter(t -> !t.isCompleted()).limit(3));
  }

  private static void displayTasks(String title, Stream<Task> tasks) {
    System.out.println(title);
    tasks.forEach(System.out::println);
    System.out.println();
  }

  private static Task randomTask() {

    String[] names = {"DevOps", "SQL", "AWS", "Spring Boot"};

    return new Task(
      names[random.nextInt(names.length - 1)]
        + " no." + random.nextInt(100),
      random.nextInt(1, 11),
      random.nextBoolean()
      );
  }

  private static Employee randomEmployee() {

    String[] firstNames = {"Alfred", "Norbert", "Gert", "Annika"};

    Employee randomEm = new Employee(
      firstNames[random.nextInt(firstNames.length - 1)] + " "
        + (char) random.nextInt('A', 'Z') + ".");

    for (int i = 0; i < 10; i++) {
      Task task = randomTask();
      randomEm.addTask(
        task.getTaskName(),
        task.getPriority(),
        task.isCompleted());
    }

    return randomEm;
  }
}
