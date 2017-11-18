import javax.servlet.ServletContext

import dugger.demo.scalatra.HelloWorldServlet
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new HelloWorldServlet, "/*")
  }
}