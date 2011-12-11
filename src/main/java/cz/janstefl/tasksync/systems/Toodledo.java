package cz.janstefl.tasksync.systems;

import cz.janstefl.tasksync.core.SystemAbstract;
import cz.janstefl.tasksync.persistence.SystemItem;

public class Toodledo extends SystemAbstract {

  private Toodledo() {
    this.properties.setPullEnabled(false);
    this.properties.setMaxTasksPerPush(50);
  }

  @Override
  public void pull(SystemItem system) {
    // TODO Auto-generated method stub

  }

  @Override
  public void push(SystemItem system) {
    // TODO Auto-generated method stub

  }

}
