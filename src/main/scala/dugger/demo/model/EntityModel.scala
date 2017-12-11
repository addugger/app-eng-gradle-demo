package dugger.demo.model

import com.google.cloud.datastore._

trait EntityModel {
  val Kind: String

  lazy val keyFactory: KeyFactory = datastore.newKeyFactory().setKind(this.Kind)
  lazy val datastore: Datastore = DatastoreOptions.getDefaultInstance.getService

  def newEntity: FullEntity[IncompleteKey]

  def newKey: IncompleteKey = { keyFactory.newKey }

  def put(): Unit = {
    val txn = datastore.newTransaction
    txn.put(newEntity)
    txn.commit()
  }
}
