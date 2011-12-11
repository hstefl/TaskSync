package cz.janstefl.tasksync.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: UserItem
 * 
 */
@Entity
public class UserItem {

  @Id @GeneratedValue
  private int id;
  private String email;

  public UserItem() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  public UserItem(String email) {
    super();
    this.email = email;
  }
  
  public int getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}