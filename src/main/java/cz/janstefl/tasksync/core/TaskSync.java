package cz.janstefl.tasksync.core;

import java.util.LinkedList;
import java.util.Queue;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import cz.janstefl.tasksync.persistence.ConnectionItem;
import cz.janstefl.tasksync.persistence.SystemItem;

/**
 * Session Bean implementation class TaskSync
 */
@Singleton
@Startup
@LocalBean
public class TaskSync {

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
        
        if ((sys.getProperties().isPullEnabled() && sys.getProperties().getNextPull() <= now && !isSystemItemReadyToPush(sys) 
             && systems.tasksChanged(sys)) 
            || sys.getProperties().isInitSync()) {
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
        if ((sys.getProperties().getNextPush() <= now || sys.getProperties().isManualRequest()) && !con.isInitSync()) {
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

}