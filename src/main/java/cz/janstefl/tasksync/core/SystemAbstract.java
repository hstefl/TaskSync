/**
 * 
 */
package cz.janstefl.tasksync.core;

import cz.janstefl.tasksync.persistence.SystemItem;

/**
 * TODO null object
 */
public abstract class SystemAbstract {

  protected SystemProperties properties = new SystemProperties();

  abstract public void pull(SystemItem system);

  abstract public void push(SystemItem system);

  /**
   * System Factory
   */
  public static SystemAbstract factory(String SystemClassName) {
    SystemAbstract object = null;
    try {
      Class<?> c = Class.forName(SystemClassName);
      object = (SystemAbstract) c.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return object;
  }

  public SystemProperties getProperties() {
    return properties;
  }

  public void setProperties(SystemProperties properties) {
    this.properties = properties;
  }

}
