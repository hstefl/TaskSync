package cz.janstefl.tasksync.core;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.janstefl.tasksync.persistence.SystemItem;

/**
 * Session Bean implementation class Systems
 */
@Singleton
@LocalBean
public class Systems {

  @PersistenceContext(unitName = "TaskSync")
  private EntityManager em;


  public SystemItem createSystemItem(SystemItem system) {
    em.persist(system);
    return system;
  }
  
  public void createSystemItem(List<SystemItem> systems) {
    for (SystemItem sys : systems) {
      createSystemItem(sys);
    }
  }

  public boolean tasksChanged(SystemItem system) {
    return true;
  }

}
