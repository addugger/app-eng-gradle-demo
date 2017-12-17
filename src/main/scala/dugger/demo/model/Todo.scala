package dugger.demo.model

import com.google.cloud.datastore.StructuredQuery.PropertyFilter
import com.google.cloud.datastore._

case class Todo(id: Long = 0,
                body: String = "",
                completed: Boolean = false,
                parent: String,
                datastore: Datastore = DatastoreOptions.getDefaultInstance.getService)
  extends IdEntity with EntityWithAncestor {

  val Kind: String = Todo.Kind

  lazy val paths: Iterable[PathElement] = Iterable[PathElement](PathElement.of(User.Kind, parent))
  lazy val parentKey: Key = User(parent).getKey

  def newEntity: FullEntity[IncompleteKey] = {
    FullEntity.newBuilder(keyFactory.newKey())
      .set("body", body)
      .set("completed", completed)
      .build()
  }

  def complete(): Unit = { updateBoolean("completed", value = true) }

  def getTodos: QueryResults[Entity] = {
    val query: Query[Entity] = Query.newEntityQueryBuilder().setKind(Kind).setFilter(PropertyFilter.hasAncestor(parentKey)).build()
    datastore.run[Entity](query, ReadOption.eventualConsistency())
  }
}

object Todo {
  val Kind = "todo"

  def fromEntity(entity: Entity): Todo = {
    val key = entity.getKey
    new Todo(key.getId, entity.getString("body"), entity.getBoolean("completed"), key.getParent.getName)
  }
}