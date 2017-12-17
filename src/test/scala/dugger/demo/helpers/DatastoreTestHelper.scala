package dugger.demo.helpers

import com.google.appengine.tools.development.testing.{LocalDatastoreServiceTestConfig, LocalServiceTestHelper}

object DatastoreTestHelper {
  def getDatastoreHelper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());


}
