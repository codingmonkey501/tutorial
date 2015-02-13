package day4.coursesa

class Underscore {

  //Existential types

  def foo(l: List[Option[_]]) = {}

  //Higher kinded type parameters
  case class A[K[_], T](a: K[T])

  //Ignored variables
  val _ = 5

  //Ignored parameters
  List(1, 2, 3) foreach { _ => println("Hi") }

  //Wildcard patterns
  Some(5) match { case Some(_) => println("Yes") }

  //Wildcard imports
  import java.util._

  //Hiding imports
  import java.util.{ ArrayList => _, _ }

  //Joining letters to punctuation
  def bang_!(x: Int) = 5

  //Assignment operators
  def foo_=(x: Int) {}

  //Placeholder syntax
  scala.List(1, 2, 3) map (_ + 2)

  //Partially applied functions
  scala.List(1, 2, 3) foreach println _

  //There may be others I have forgotten!
  //Example showing why foo(_) and foo _ are different:
  //This example comes from 0__:
  trait PlaceholderExample {
    def process[A](f: A => Unit)

    val set: scala.collection.immutable.Set[_ => Unit]

    //set.foreach(process _) // Error 
    set.foreach(process(_)) // No Error
  }

  //In the first case, process _ represents a method; 
  //Scala takes the polymorphic method and attempts to make it monomorphic by filling in the type parameter, 
  //but realizes that there is no type that can be filled in for A that will give the type (_ => Unit) => ? (Existential _ is not a type).
  //In the second case, process(_) is a lambda; 
  //when writing a lambda with no explicit argument type, Scala infers the type from the argument that foreach expects, 
  //and _ => Unit is a type (whereas just plain _ isn't), so it can be substituted and inferred.

  //This may well be the trickiest gotcha in Scala I have ever encountered.

  // Sequence xs is passed as multiple parameters to f(ys: T*)
  def f[T](ys: T*) = {}
  val xs = 1 to 5
  f(xs: _*)

  //case Seq(xs @ _*) // Identifier xs is bound to the whole matched sequence

  // Initialization to the default value
  var i: Int = _

  // An underscore must separate alphanumerics from symbols on identifiers
  def abc_<>! = {}

  // Part of a method name, such as tuple getters
  def _2 = {}
  val aa= new Underscore
  aa._2

}
            