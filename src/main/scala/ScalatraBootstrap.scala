import javax.servlet.ServletContext

import dugger.demo.servlet.{HelloWorldServlet, TodoServlet}
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    context.mount(new HelloWorldServlet, "/hello")
    context.mount(new TodoServlet, "/*")
  }
}