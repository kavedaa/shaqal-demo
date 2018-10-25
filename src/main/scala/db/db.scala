package test.db

import org.shaqal._

object MyDB extends Database with DefaultSchema {

  object Person extends Table("Person") with PersonMapper

  def createDB = {
    Person create()
  }
}

