package cz.janstefl.tasksync.core;

import java.util.List;
import java.util.Vector;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.janstefl.tasksync.persistence.ConnectionItem;
import cz.janstefl.tasksync.persistence.ical.ICalendarItem;

/**
 * Session Bean implementation class Connections
 */
@Singleton
@LocalBean
public class Connections {
  
  @PersistenceContext(unitName = "TaskSync")
  private EntityManager em;

  private List<ConnectionItem> connections = new Vector<ConnectionItem>();


  public void init() {
    Query query = em.createNamedQuery("loadAllConnections");
    
    @SuppressWarnings("unchecked")
    List<ConnectionItem> res = query.getResultList();
    connections.addAll(res);
  }
  
  public List<ConnectionItem> get() {
    return connections;
  }

  public ICalendarItem createTask(ICalendarItem task) {
    em.persist(task);
    return task;
  }

  public ConnectionItem createConnection(ConnectionItem connection) {
    em.persist(connection);
    return connection;
  }
  
  public void createConnection(List<ConnectionItem> connections) {
    for (ConnectionItem connection : connections) {
      createConnection(connection);
    }
  }

  public ICalendarItem markTaskForDelete(ICalendarItem task) {
    return task;
  }

}
