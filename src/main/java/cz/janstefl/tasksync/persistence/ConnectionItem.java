package cz.janstefl.tasksync.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: ConnectionItem
 * 
 */
@Entity
@NamedQueries({
  @NamedQuery(name = "loadAllConnections", query="select c from ConnectionItem c")
})
public class ConnectionItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private long lastLocalUpdateTs;
  @OneToOne(fetch = FetchType.LAZY)
  private UserItem userItem;
  @OneToMany
  private List<SystemItem> systemItems;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getLastLocalUpdateTs() {
    return lastLocalUpdateTs;
  }

  public void setLastLocalUpdateTs(long lastLocalUpdateTs) {
    this.lastLocalUpdateTs = lastLocalUpdateTs;
  }

  public UserItem getUserItem() {
    return userItem;
  }

  public void setUserItem(UserItem userItem) {
    this.userItem = userItem;
  }

  public List<SystemItem> getSystemItems() {
    return systemItems;
  }

  public void setSystemItem(List<SystemItem> systemItems) {
    this.systemItems = systemItems;
  }

  /**
   * Check if at least one system is in initSync mode.
   */
  public boolean isInitSync() {
    boolean res = false;
    
    for (SystemItem sys : systemItems) {
      if (sys.isInitSync()) {
        res = true;
        break;
      }
    }
    
    return res;
  }
  
}