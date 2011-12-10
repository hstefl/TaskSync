package cz.janstefl.tasksync.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.janstefl.tasksync.persistence.UserItem;

public class TaskSyncTest {

  private static EJBContainer ec;
  private static Context ctx;

  @BeforeClass
  public static void initContainer() throws Exception {
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put(EJBContainer.MODULES, new File("target/classes"));
    ec = EJBContainer.createEJBContainer(properties);
    ctx = ec.getContext();

    generateUsers();
    generateSystems();
    generateConnections();
  }

  @AfterClass
  public static void closeContainer() throws Exception {
    if (ec != null)
      ec.close();
  }

  @Test
  public void betterTest() throws Exception {
    TaskSync ts = (TaskSync) ctx
        .lookup("java:global/classes/TaskSync!cz.janstefl.tasksync.core.TaskSync");
  }

  private static void generateUsers() throws NamingException {
    List<UserItem> users = new ArrayList<UserItem>();
    users.add(new UserItem(1, "janstefl.cz@gmail.com"));
    users.add(new UserItem(2, "petrova.aneta@gmail.com"));
    users.add(new UserItem(3, "alois@manas.cz"));
    users.add(new UserItem(4, "jakekoliv@jmeno.cz"));
    users.add(new UserItem(5, "arjen@lucassen.net"));

    TaskSync ts = (TaskSync) ctx
        .lookup("java:global/classes/TaskSync!cz.janstefl.tasksync.core.TaskSync");

    ts.createUser(users);
  }

  private static void generateSystems() throws NamingException {
    Systems systems = (Systems) ctx
        .lookup("java:global/classes/Systems!cz.janstefl.tasksync.core.Systems");
  }

  private static void generateConnections() throws NamingException {
    Connections connections = (Connections) ctx
        .lookup("java:global/classes/Connections!cz.janstefl.tasksync.core.Connections");

  }

}
