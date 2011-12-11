package cz.janstefl.tasksync.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import cz.janstefl.tasksync.persistence.ical.CalendarPropertiesItem;

/**
 * Entity implementation class for Entity: ConnectionItem
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "loadAllConnections", query = "select c from ConnectionItem c") })
public class ConnectionItem {

  @Id
  @GeneratedValue
  private int id;
  private long lastLocalUpdateTs;
  @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
      CascadeType.REMOVE })
  private UserItem userItem;
  @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
  private List<SystemItem> systemItems;
  @Embedded
  private CalendarPropertiesItem calendarProperties;

  public ConnectionItem() {
    super();
  }

  public ConnectionItem(long lastLocalUpdateTs, UserItem userItem,
      List<SystemItem> systemItems, CalendarPropertiesItem calendarProperties) {
    super();
    this.lastLocalUpdateTs = lastLocalUpdateTs;
    this.userItem = userItem;
    this.systemItems = systemItems;
    this.calendarProperties = calendarProperties;
  }

  public int getId() {
    return id;
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

  public CalendarPropertiesItem getCalendarProperties() {
    return calendarProperties;
  }

  public void setCalendarProperties(CalendarPropertiesItem calendarProperties) {
    this.calendarProperties = calendarProperties;
  }

  /**
   * Check if at least one system is in initSync mode.
   */
  public boolean isInitSync() {
    boolean res = false;

    for (SystemItem sys : systemItems) {
      if (sys.getProperties().isInitSync()) {
        res = true;
        break;
      }
    }

    return res;
  }

}