package cz.janstefl.tasksync.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import cz.janstefl.tasksync.core.SystemProperties;

@Embeddable
public class SystemPropertiesItem extends SystemProperties {

  @Id
  @GeneratedValue
  private int id;
  @Column(nullable = false)
  private String systemClassName;
  private ConnectionItem connection;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSystemClassName() {
    return systemClassName;
  }

  public void setSystemClassName(String systemClassName) {
    this.systemClassName = systemClassName;
  }

  public ConnectionItem getConnection() {
    return connection;
  }

  public void setConnection(ConnectionItem connection) {
    this.connection = connection;
  }

}
