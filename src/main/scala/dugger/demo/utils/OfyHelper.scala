package dugger.demo.utils

import com.googlecode.objectify.ObjectifyService
import javax.servlet.ServletContextListener
import javax.servlet.ServletContextEvent

import dugger.demo.model.{Todo, User}


/**
  * OfyHelper, a ServletContextListener, is setup in web.xml to run before a JSP is run.  This is
  * required to let JSP's access Ofy.
  **/
class OfyHelper extends ServletContextListener {
  override def contextInitialized(event: ServletContextEvent): Unit = { // This will be invoked as part of a warmup request, or the first user request if no warmup
    // request.
    ObjectifyService.register(classOf[Todo])
    ObjectifyService.register(classOf[User])
  }

  override def contextDestroyed(event: ServletContextEvent): Unit = {
    // App Engine does not currently invoke this method.
  }
}