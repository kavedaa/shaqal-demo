package test.db

import org.shaqal._
import model._

trait PersonMapper extends Mapper[Person] with TableDefinition {

  val name = new varchar("name") with notnull with unique with default[String] {
    def defaultValue = "John"
  }
  val age = new int("age") with nullable

  def fields = Seq(name, age)  

  val (reader, writer) = RW(
    implicit rs => Person(
      name.read,
      age.read),
    x => Seq(name := x.name, age := x.age))

  def constraints = Seq(
    Unique(name))

}
