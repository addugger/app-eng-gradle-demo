package dugger.demo.model

import com.googlecode.objectify.annotation.{Entity, Id}

@Entity
class User() {
  @Id var name: String = null
}
