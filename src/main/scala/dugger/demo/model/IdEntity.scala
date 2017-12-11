package dugger.demo.model

import com.google.cloud.datastore.{Entity, Key, ReadOption}

trait IdEntity extends EntityModel {
  val id: Long

  def getKey: Key = { keyFactory.newKey(id) }

  def delete(): Unit = {
    val txn = datastore.newTransaction()
    txn.delete(getKey)
    txn.commit()
  }

  def updateBoolean(key: String, value: Boolean): Unit = {
    val txn = datastore.newTransaction
    txn.update(Entity.newBuilder(datastore.get(getKey, ReadOption.eventualConsistency())).set(key, value).build())
    txn.commit()
  }
}
