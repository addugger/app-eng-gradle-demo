package dugger.demo.servlet

import dugger.demo.model.Todo
import dugger.demo.utils.ConverterUtils
import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport

import scala.collection.JavaConverters._

class TodoServlet() extends ScalatraServlet with ScalateSupport {
  get("/") {
    contentType = "text/html"
    val todo = Todo(parent = "default")
    val todos = todo.getAll(todo.parentKey).asScala.map(Todo.fromEntity).toList
    jade("/index", "todos" -> todos.sortBy(_.completed))
  }

  post("/new") {
    Todo(body = params.get("todo").get, parent = "default").put()
    redirect("/")
  }

  get("/:id/completed") {
    Todo(ConverterUtils.toLong(params("id")), parent = "default").complete()
    redirect("/")
  }

  get("/:id/delete") {
    Todo(ConverterUtils.toLong(params("id")), parent = "default").delete()
    redirect("/")
  }
}
