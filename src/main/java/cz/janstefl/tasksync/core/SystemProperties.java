package cz.janstefl.tasksync.core;

public class SystemProperties implements Cloneable {
  private static final int UNLIMITED_TASKS_PER_PUSH = 0;
  private static final int UNLIMITED_TASKS_PER_PULL = 0;
  
  private long lastLocalUpdate = 0;
  private long lastRemoteUpdate = 0;
  private int interval = 3600;
  private long nextPull = interval / 2;
  private long nextPush = interval;
  private boolean manualRequest = false;
  private int maxTasksPerPush = UNLIMITED_TASKS_PER_PUSH;
  private boolean pullEnabled = false;
  private int maxTasksPerPull = UNLIMITED_TASKS_PER_PULL;
  private boolean initSync = true;

  public SystemProperties() {
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

  public long getNextPull() {
    return nextPull;
  }

  public void setNextPull(long nextPull) {
    this.nextPull = nextPull;
  }

  public long getNextPush() {
    return nextPush;
  }

  public void setNextPush(long nextPush) {
    this.nextPush = nextPush;
  }

  public boolean isManualRequest() {
    return manualRequest;
  }

  public void setManualRequest(boolean manualRequest) {
    this.manualRequest = manualRequest;
  }

  public int getMaxTasksPerPush() {
    return maxTasksPerPush;
  }

  public void setMaxTasksPerPush(int maxTasksPerPush) {
    this.maxTasksPerPush = maxTasksPerPush;
  }
  
  public void setMaxTasksPerPushUnlimited() {
    this.maxTasksPerPush = UNLIMITED_TASKS_PER_PUSH;
  }

  public boolean isPullEnabled() {
    return pullEnabled;
  }

  public void setPullEnabled(boolean pullEnabled) {
    this.pullEnabled = pullEnabled;
  }

  public int getMaxTasksPerPull() {
    return maxTasksPerPull;
  }

  public void setMaxTasksPerPull(int maxTasksPerPull) {
    this.maxTasksPerPull = maxTasksPerPull;
  }
  
  public void setMaxTasksPerPullUnlimited() {
    this.maxTasksPerPull = UNLIMITED_TASKS_PER_PULL;
  }

  public boolean isInitSync() {
    return initSync;
  }

  public void setInitSync(boolean initSync) {
    this.initSync = initSync;
  }

  public boolean isMaxTasksPerPullUnlimited() {
    return this.maxTasksPerPull == UNLIMITED_TASKS_PER_PULL;
  }
  
  public boolean isMaxTasksPerPushUnlimited() {
    return this.maxTasksPerPush == UNLIMITED_TASKS_PER_PUSH;
  }
  
  @Override
  public Object clone() {
    SystemProperties properties = new SystemProperties();
    properties.setInitSync(this.initSync);
    properties.setInterval(this.interval);
    properties.setLastLocalUpdate(this.lastLocalUpdate);
    properties.setLastRemoteUpdate(this.lastRemoteUpdate);
    properties.setManualRequest(this.manualRequest);
    properties.setMaxTasksPerPull(this.maxTasksPerPull);
    properties.setMaxTasksPerPush(this.maxTasksPerPush);
    properties.setNextPull(this.nextPull);
    properties.setNextPush(this.nextPush);
    properties.setPullEnabled(this.pullEnabled);
    
    return properties;
  }
  
}
