package cz.janstefl.tasksync.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.janstefl.tasksync.persistence.ConnectionItem;
import cz.janstefl.tasksync.persistence.SystemItem;
import cz.janstefl.tasksync.persistence.UserItem;

/**
 * Session Bean implementation class TaskSync
 */
@Singleton
@Startup
@LocalBean
public class TaskSync {

  @PersistenceContext(unitName = "TaskSync")
  private EntityManager em;
  @EJB
  private Systems systems;
  @EJB
  private Connections connections;

  private Queue<SystemItem> pullQueue = new LinkedList<SystemItem>();
  private Queue<SystemItem> pushQueue = new LinkedList<SystemItem>();

  
  @PostConstruct
  public void init() {
    connections.init();
  }

  @Schedule(second = "1", minute = "*")
  public void scheduleToPull() {
    long now = System.currentTimeMillis() / 1000L;
    for (ConnectionItem con : connections.get()) {
      for (SystemItem sys : con.getSystemItems()) {

        // Pull is part of push,
        // because some system demands synchronization "at once".
        // For example Toodledo requires one sync per hour.
        
        if ((sys.isPullEnabled() && sys.getNextPull() <= now && !isSystemItemReadyToPush(sys) 
             && systems.tasksChanged(sys)) 
            || sys.isInitSync()) {
          pullQueue.add(sys);
        }
      }
    }
  }

  @Schedule(second = "30", minute = "*")
  public void scheduleToPush() {
    long now = System.currentTimeMillis() / 1000L;
    for (ConnectionItem con : connections.get()) {
      for (SystemItem sys : con.getSystemItems()) {
        if ((sys.getNextPush() <= now || sys.isManualRequest()) && !con.isInitSync()) {
          pushQueue.add(sys);
       }
      }
    }
  }

  @Schedule(second = "15", minute="*")
  public void syncPull() {

  }

  @Schedule(second = "45", minute="*")
  public void syncPush() {

  }

  private boolean isSystemItemReadyToPush(SystemItem system) {
    return pushQueue.contains(system);
  }

  /**
   * Persists user. 
   * TODO: Refactor into class Users
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
   * TODO: Refactor into class Users
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