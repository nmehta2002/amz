import java.util.UUID

import scala.util.Try


class JaiGurudev(name : String) {

}

val j = new JaiGurudev("foo")

println("Seems to work a lot better")


println("Hi")

// Create an anonymous class
abstract class Abs {
  def name() : String
}

val abs = new Abs {
  override def name(): String = "abc"
}

abs.name()


case class CartItem(name : String, quant : Int, price : Double)

object ShoppingCart {

  def computeTotalCost(item : CartItem, coupon : Option[String]) : Double = {
    import item._
    val costPerItem: Double = coupon match {
      case Some(coupon) if coupon == "abc" => price * 0.90
      case _ => price
    }

    costPerItem * quant
  }
}


ShoppingCart.computeTotalCost(CartItem("table", 2, 240.5), coupon=None)

case class Vehicle(make : String, model : String)

trait InventoryMgr[V] {
  def create(v : V): Unit
  def delete(v : V): Unit
  def update(v : V): Unit
}

trait VehicleInventoryMgrImpl extends InventoryMgr[Vehicle] {
  override def create(v: Vehicle): Unit = ???

  override def delete(v: Vehicle): Unit = ???

  override def update(v: Vehicle): Unit = ???
}


val opt : Option[String] = None
val opt2 : Option[String] = Some("Pritu")


opt2.flatMap(((x) => Option(x + "abc")))
opt2.map((x)=>x + "abc")

case class Address(val street: String)

case class Person(name : String, address : Option[Address])

val person : Option[Person] = Some(Person("Pritu",  Some(Address("wildwood"))))

person.flatMap({p => Option(p) })

val street: Option[String] = person.flatMap({
    p =>  p.address.flatMap({ address =>
    Option(address.street)
  })})

val tryPerson: Try[Person] = Try { Person("Pritu", None) }
tryPerson.flatMap({ p => Try { p.name + "abc"}})


val either : Either[String, Int] = Right(1)
either.flatMap({ x => Right(x.toString())})


def foo(i  : Int): Unit = {

  def bar() : Unit = { println("bar")}

  bar()

}

def bar(q : Int, name: String) { println(q)
  println(name)
}

val i = 10

def foo(name : String) = { bar(i, name) }

foo("hi how are you.")

trait MyTrait {
  def bar : String
}

def cux() : String = {
 "abc"
}

val a = cux()

trait A {
  protected def method(a : Option[Int] = None) = {
    0
  }
}

trait B extends A {
  def method() : Int = {
    1
  }
}

class B1 extends B {

}

val b1 = new B1()
b1.method()

// Practice foreach and how to use it.
val l = List('a', 'b', 'c')

l.foreach({item => println(item)})


for (a <- l if a != 'a')
  yield a

class Num[A](a: A) {

}

// A can be viewed as a Numeric.

/**
 * This does not work.
 * The idea was to make the implicit val of type OperandAllowedType[Parent]
 */

/*
class Parent {

}
class Child extends Parent {

}

class OperandAllowedType[T]  {

}


class Container[A](value: A) {

  def OpOnNum(implicit evidence : OperandAllowedType[A]) : A = {
    println(evidence)
    value
  }

  def sum[B >: A](implicit evidence : OperandAllowedType[B]) : B = {
    value
  }
}

implicit val opParent = new OperandAllowedType[Child]

val con = new Container[Child](new Child)

con.sum
*/

List(1,2).sum

List(1,2).foreach{x => println(x)}

List(1,2).forall{y => y < 3 }

class Container[A](value: A) { def addIt(implicit evidence: A =:= Int) = 123 + value }


(new Container(123)).addIt

(new Container("123"))

val l1 = List(1,2)
val l2 = l1
val hash1 = System.identityHashCode(l1)
val hash2 = System.identityHashCode(l2)

println(s"List references list1: ${hash1} list2: ${hash2}")

class C1(val mem : String, val two : String) {

}



abstract class GraphEvent(val uuid: UUID) {
}


/** example of this method */
class Z(name : String) {

  def this(name : String, age : Int) = this(name)

}

class Collection[+T](first : T) {

  def add[U >: T](other: U): Collection[U] = {
    new Collection(other)
  }
}

class Mamal(name: String)
object  Mamal{
  def apply(name: String): Mamal = new Mamal(name)
}

case class Dog(dogName: String) extends Mamal(dogName)


val dogs : Collection[Dog] = new Collection[Dog](Dog("tommy"))

val mamal : Collection[Mamal] = dogs.add(Mamal("mamal"))



val expList = List[Int](1, 2, 3)
val exps = 55 :: expList

sealed trait NewSealedTrait

object NewSealedTrait {
  case object TimedOut extends NewSealedTrait
}

def foo(reason : NewSealedTrait) : Unit = {

}

import NewSealedTrait._
foo(TimedOut)

class SomeClass(val a: Int)

val sc = new SomeClass(10)
sc.a

val inst = new C1("hi", "two")
println(inst.getClass.getName)
println(inst.getClass.getCanonicalName)
inst.mem

// ====
trait ExpTrait {
  val startTime: Int

  val endTime = startTime + 10
}

case class ExpTraitSubClass(override val startTime: Int) extends ExpTrait {}

val exptsub = ExpTraitSubClass(10)
println(exptsub.endTime)


def callCallback(fn: Int => Unit): Unit = {
  fn(10)
}

def callback(x: Int): Int = { x }

callCallback(callback)

val fn = (a: Int) => { a * 2 }

class Common { }
case class Foo(a: Int) extends Common
case class Bar(b: Int) extends Common

val foo = Foo(10)

def matchFoo(arg: Common): Int = {
  arg match {
    case _: Common => return 1
    case _: Foo => println("A")
      return 0
  }
}






