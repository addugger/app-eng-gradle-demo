import javax.servlet.ServletContext

import com.googlecode.objectify.ObjectifyService
import dugger.demo.model.{Todo, User}
import dugger.demo.servlet.{HelloWorldServlet, TodoServlet}
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    ObjectifyService.register(classOf[Todo])
    ObjectifyService.register(classOf[User])

    context.mount(new HelloWorldServlet, "/hello")
    context.mount(new TodoServlet, "/*")
  }
}