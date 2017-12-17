package dugger.demo.model

import com.google.cloud.datastore._

case class User(var name: String, datastore: Datastore = DatastoreOptions.getDefaultInstance.getService) extends NameEntity {
  final val Kind: String = User.Kind

  override def newEntity: FullEntity[IncompleteKey] = {
    FullEntity.newBuilder(newKey)
      .set("id", name)
      .build()
  }
}

object User {
  val Kind = "user"
}

