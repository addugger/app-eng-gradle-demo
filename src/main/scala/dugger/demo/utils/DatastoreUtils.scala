package dugger.demo.utils

import com.google.cloud.datastore.{Datastore, DatastoreOptions, Entity}
import dugger.demo.model.DatastoreModel

object DatastoreUtils {

  lazy val datastore: Datastore = DatastoreOptions.getDefaultInstance.getService

  def putWholeEntity(id: Long, data: DatastoreModel): Unit = {
    datastore.put(data.toEntity(data.keyFactory.newKey(id)))
  }

  def putWholeEntity(name: String, data: DatastoreModel): Unit = {
    datastore.put(data.toEntity(data.keyFactory.newKey(name)))
  }

  def putProperty(id: Long, model: DatastoreModel, propName: String, propVal: String): Unit = {
    val key = model.keyFactory.newKey(id)
    val entity = Entity.newBuilder(key).set(propName, propVal).build()
    datastore.update(entity)
  }
}
