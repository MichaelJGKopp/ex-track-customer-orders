public class Task {

  private String taskName;
  private int priority;
  private boolean completed;

  public Task(String taskName, int priority, boolean completed) {
    this.taskName = taskName;
    this.priority = priority;
    this.completed = completed;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  @Override
  public String toString() {
    return "%-20s %-20s %-20s".formatted(taskName, priority, completed);
  }
}
