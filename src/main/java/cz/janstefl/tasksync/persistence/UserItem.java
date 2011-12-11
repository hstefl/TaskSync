package cz.janstefl.tasksync.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  
  public UserItem(int id, String email) {
    super();
    this.id = id;
    this.email = email;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}