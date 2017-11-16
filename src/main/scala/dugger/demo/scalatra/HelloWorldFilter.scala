package dugger.demo.scalatra

import org.scalatra.ScalatraFilter

class HelloWorldFilter extends ScalatraFilter {
  get("/") { "Yo Yo World!!!"}
}
