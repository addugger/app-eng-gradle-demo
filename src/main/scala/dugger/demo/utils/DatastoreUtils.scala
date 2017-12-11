package dugger.demo.utils

import com.google.cloud.datastore.{Datastore, DatastoreOptions}

object DatastoreUtils {
  lazy val datastore: Datastore = DatastoreOptions.getDefaultInstance.getService
}
