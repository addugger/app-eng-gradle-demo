package dugger.demo.servlet

import com.googlecode.objectify.ObjectifyService.ofy
import dugger.demo.model.Todo
import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport

class TodoServlet() extends ScalatraServlet with ScalateSupport {
  get("/") {
    contentType = "text/html"
    val todos = Todo.getTodos("default")
    jade("/index", "todos" -> todos.sortBy(_.completed))
  }

  post("/new") {
    ofy.save.entity(new Todo(params.get("todo").get))
    redirect("/")
  }

//  get("/:id/completed") {
//    val todo = todos(params("id").toInt)
//    todo.completed = true
//    redirect("/")
//  }
//
//  get("/:id/delete") {
//    todos.remove(params("id").toInt)
//    redirect("/")
//  }
}
