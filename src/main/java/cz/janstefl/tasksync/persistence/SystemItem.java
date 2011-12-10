package cz.janstefl.tasksync.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: SystemItem
 * 
 */
@Entity
public class SystemItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private int systemClassName;
  private long lastLocalUpdate;
  private long lastRemoteUpdate;
  private int interval;
  private long nextPull;
  private int maxTasksPerPull;
  private long nextPush;
  private int maxTasksPerPush;
  private boolean manualRequest;
  private boolean initSync;
  private boolean pullEnabled;

  private ConnectionItem connection;

  public SystemItem() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getLastLocalUpdate() {
    return lastLocalUpdate;
  }

  public void setLastLocalUpdate(long lastLocalUpdate) {
    this.lastLocalUpdate = lastLocalUpdate;
  }

  public long getLastRemoteUpdate() {
    return lastRemoteUpdate;
  }

  public void setLastRemoteUpdate(long lastRemoteUpdate) {
    this.lastRemoteUpdate = lastRemoteUpdate;
  }

  public int getInterval() {
    return interval;
  }

  public void setInterval(int interval) {
    this.interval = interval;
  }

  public ConnectionItem getConnection() {
    return connection;
  }

  public void setConnection(ConnectionItem connection) {
    this.connection = connection;
  }

  public int getSystemClassName() {
    return systemClassName;
  }

  public void setSystemClassName(int systemClassName) {
    this.systemClassName = systemClassName;
  }

  public long getNextPull() {
    return nextPull;
  }

  public void setNextPull(long nextPull) {
    this.nextPull = nextPull;
  }

  public int getMaxTasksPerPull() {
    return maxTasksPerPull;
  }

  public void setMaxTasksPerPull(int maxTasksPerPull) {
    this.maxTasksPerPull = maxTasksPerPull;
  }

  public long getNextPush() {
    return nextPush;
  }

  public void setNextPush(long nextPush) {
    this.nextPush = nextPush;
  }

  public int getMaxTasksPerPush() {
    return maxTasksPerPush;
  }

  public void setMaxTasksPerPush(int maxTasksPerPush) {
    this.maxTasksPerPush = maxTasksPerPush;
  }

  public boolean isManualRequest() {
    return manualRequest;
  }

  public void setManualRequest(boolean manualRequest) {
    this.manualRequest = manualRequest;
  }

  public boolean isInitSync() {
    return initSync;
  }

  public void setInitSync(boolean initSync) {
    this.initSync = initSync;
  }

  public boolean isPullEnabled() {
    return pullEnabled;
  }

  public void setPullEnabled(boolean pullEnabled) {
    this.pullEnabled = pullEnabled;
  }

}