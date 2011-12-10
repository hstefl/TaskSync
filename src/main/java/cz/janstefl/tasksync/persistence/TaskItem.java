package cz.janstefl.tasksync.persistence;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 * 
 */
@Entity
public class TaskItem {

  @Id
  private int id;

  public TaskItem() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
