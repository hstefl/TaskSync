package cz.janstefl.tasksync.core;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.janstefl.tasksync.persistence.UserItem;

/**
 * Session Bean implementation class Connections
 */
@Singleton
@LocalBean
public class Users {
  
  @PersistenceContext(unitName = "TaskSync")
  private EntityManager em;

  /**
   * Persists user. 
   * 
   * @param user
   * @return
   */
  public UserItem createUser(UserItem user) {
    em.persist(user);
    return user;
  }

  /**
   * Persists users.
   * 
   * @param user
   * @return
   */
  public void createUser(List<UserItem> users) {
    for (UserItem user : users) {
      createUser(user);
    }
  }

}
