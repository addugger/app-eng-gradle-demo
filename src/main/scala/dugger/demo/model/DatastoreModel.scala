package dugger.demo.model

import com.google.cloud.datastore.Entity.Builder
import com.google.cloud.datastore.{Entity, Key, KeyFactory}

trait DatastoreModel {
  def Kind: String

  val keyFactory: KeyFactory

  def toEntity(key: Key): Entity
}
