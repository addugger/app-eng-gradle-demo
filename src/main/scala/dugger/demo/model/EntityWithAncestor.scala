package dugger.demo.model

import com.google.cloud.datastore.StructuredQuery.PropertyFilter
import com.google.cloud.datastore._

import scala.collection.JavaConverters._

trait EntityWithAncestor extends EntityModel {
  val paths: Iterable[PathElement]

  override lazy val keyFactory: KeyFactory = datastore.newKeyFactory().setKind(Kind).addAncestors(paths.asJava)

  def getAll(parentKey: Key): QueryResults[Entity] = {
    val query: Query[Entity] = Query.newEntityQueryBuilder().setKind(Kind).setFilter(PropertyFilter.hasAncestor(parentKey)).build()
    datastore.run[Entity](query, ReadOption.eventualConsistency())
  }
}
