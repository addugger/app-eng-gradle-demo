package dugger.demo.model

import com.googlecode.objectify.{Key, Result}
import com.googlecode.objectify.annotation._
import com.googlecode.objectify.ObjectifyService.ofy

import scala.collection.JavaConverters._

import java.lang.{ Long => JLong }


@Entity
class Todo(var body : String,
           @Index var completed : Boolean = false) {
  @Id var id: JLong = null
  // Only for Objectify creation
  private def this() { this(null, false) }

  def getId: JLong = { id }
  def setId(id: JLong) = { this.id = id }
}

object Todo {
  def getTodos(ancestorName: String): List[Todo] = {
    val parentKey = Key.create(classOf[User], ancestorName)
    ofy().load().`type`(classOf[Todo]).ancestor(parentKey).list.asScala.toList
  }
}