package cz.janstefl.tasksync.persistence;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import cz.janstefl.tasksync.core.SystemAbstract;

/**
 * Entity implementation class for Entity: SystemItem
 * 
 */
@Entity
public class SystemItem {

  @Embedded
  SystemPropertiesItem properties;

  public SystemItem() {
  }

  public SystemItem(String systemClassName) {
    SystemAbstract sys = (SystemAbstract) SystemAbstract
        .factory(systemClassName);
    
    // TODO revise this (clone)
    properties = (SystemPropertiesItem)(sys.getProperties().clone());
    properties.setSystemClassName(systemClassName);
  }
  
  public SystemItem(String systemClassName, ConnectionItem connection) {
    this(systemClassName);
    this.properties.setConnection(connection);
  }

  public SystemPropertiesItem getProperties() {
    return properties;
  }

  public void setProperties(SystemPropertiesItem properties) {
    this.properties = properties;
  }

  public ConnectionItem getConnectionItem() {
    return properties.getConnection();
  }
  
  public void setConnection(ConnectionItem connection) {
    this.properties.setConnection(connection);
  }

}