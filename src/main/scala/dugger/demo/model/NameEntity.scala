package dugger.demo.model

import com.google.cloud.datastore.Key

trait NameEntity extends EntityModel {
  var name: String

  def getKey: Key = { keyFactory.newKey(name) }
}
