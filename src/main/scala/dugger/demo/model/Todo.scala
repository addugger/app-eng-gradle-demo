package dugger.demo.model

import com.google.cloud.datastore.StructuredQuery.PropertyFilter
import com.google.cloud.datastore._
import dugger.demo.utils.DatastoreUtils

case class Todo(id: Long = 0,
                body: String = "",
                completed: Boolean = false,
                parent: String) extends IdEntity with EntityWithAncestor{

  val Kind: String = Todo.Kind

  lazy val paths: Iterable[PathElement] = Iterable[PathElement](PathElement.of(User.Kind, parent))
  lazy val parentKey: Key = User(parent).getKey

  def newEntity: FullEntity[IncompleteKey] = {
    FullEntity.newBuilder(keyFactory.newKey())
      .set("body", body)
      .set("completed", completed)

  }

  def complete(): Unit = { updateBoolean("completed", value = true) }
}

object Todo {
  val Kind = "todo"

  def fromEntity(entity: Entity): Todo = {
    val key = entity.getKey
    new Todo(key.getId, entity.getString("body"), entity.getBoolean("completed"), key.getParent.getName) }

  def getTodos(ancestorName: String): QueryResults[Entity] = {
    val parentKey = User(ancestorName).getKey
    val query: Query[Entity] = Query.newEntityQueryBuilder().setKind(Kind).setFilter(PropertyFilter.hasAncestor(parentKey)).build()
    DatastoreUtils.datastore.run[Entity](query, ReadOption.eventualConsistency())
  }
}