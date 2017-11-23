package dugger.demo.model

import com.google.cloud.datastore.{Entity, Key, KeyFactory}
import com.googlecode.objectify.annotation
import dugger.demo.utils.DatastoreUtils

@annotation.Entity
case class Todo(id : Long, body : String, var completed : Boolean) extends DatastoreModel {
  override def Kind = "todo"

  override lazy val keyFactory: KeyFactory = DatastoreUtils.datastore.newKeyFactory().setKind(Kind)

  override def toEntity(key: Key): Entity = {
    Entity.newBuilder(key)
      .set("id", id)
      .set("body", body)
      .set("completed", completed)
      .build()
  }
}