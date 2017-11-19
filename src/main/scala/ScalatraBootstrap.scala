import javax.servlet.ServletContext

import dugger.demo.model.Todo
import dugger.demo.servlet.{HelloWorldServlet, TodoServlet}
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new HelloWorldServlet, "/hello")
    val todos = collection.mutable.Map[Integer, Todo]()
    context.mount(new TodoServlet(todos), "/*")
  }
}