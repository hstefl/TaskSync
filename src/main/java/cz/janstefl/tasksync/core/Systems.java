package cz.janstefl.tasksync.core;

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

  /**
   * Default constructor.
   */
  public Systems() {
    // TODO Auto-generated constructor stub
  }

  public SystemItem createSystemItem(SystemItem system) {
    em.persist(system);
    return system;
  }

  public boolean tasksChanged(SystemItem system) {
    return true;
  }

}
