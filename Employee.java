import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {

  private String name;
  private SequencedSet<Task> tasks = new LinkedHashSet<>();

  public Employee(String name) {
    this.name = name;
  }

  public void addTask(String taskName, int priority, boolean completed) {

    tasks.addLast(new Task(taskName, priority, completed));
  }

  public void markTaskAsCompleted(String taskName) {

    Task completedTask = null;
    for (Task t : tasks) {
      if (t.getTaskName().equalsIgnoreCase(taskName)) {
        completedTask = t;
        break;
      }
    }
    completedTask.setCompleted(true);
  }

  public Stream<Task> stream() {
    return tasks.stream();
  }

  public Stream<Task> tasksByPriority() {
    return tasks.stream()
      .sorted(Comparator.comparing(Task::getPriority).reversed());
  }

  public Stream<Task> tasksByCompletion(boolean completed) {
    return tasks.stream()
      .filter(t -> t.isCompleted() == completed);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public SequencedSet<Task> getTasks() {
    return new LinkedHashSet<>(tasks);
  }

  @Override
  public String toString() {
    return "Employee{" +
      "name='" + name + '\'' +
      ", tasks=\n" +
      "%-20s %-20s %-20s%n".formatted("NAME", "PRIORITY", "COMPLETED") +
      "-".repeat(60) + "\n" +
      tasks.stream()
      .map(Task::toString)
      .collect(Collectors.joining("\n\t", "\t", "\n"))
      + '}';
  }
}
