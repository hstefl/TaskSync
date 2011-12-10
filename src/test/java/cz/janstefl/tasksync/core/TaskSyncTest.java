package cz.janstefl.tasksync.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

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
  }

  @AfterClass
  public static void closeContainer() throws Exception {
    if (ec != null)
      ec.close();
  }

  @Test
  public void testServlet() throws Exception {
    TaskSync ts = (TaskSync) ctx.lookup(
        "java:global/classes/TaskSync!cz.janstefl.tasksync.core.TaskSync");

    UserItem user = new UserItem();
    user.setEmail("janstefl.cz@gmail.com");
    user = ts.createUser(user);
  }

}
