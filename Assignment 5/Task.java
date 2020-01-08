import java.io.Serializable;
import java.util.ArrayList;

public abstract class Task implements Serializable {
  private int id;
  private String name;
  private ArrayList<Task> parents;

  protected Task(int id, String name) {
    this.id = id;
    this.name = name;
    this.parents = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void addParent(Task parent) {
    this.parents.add(parent);
  }

  public ArrayList<Task> getParents() {
    return this.parents;
  }

  public abstract double getCompletion(int currentTime);
  
}
