package day4.coursesa

class SpecialType {
  //Null // Its a Trait.
  def tryit(thing: Null): Unit = { println("That worked!"); }

  //tryit("hey") 
  //error: type mismatch;
  //found   : java.lang.String("hey")
  //required: Null

  val someRef: String = null
  //tryit(someRef)
  //error: type mismatch;
  //found   : String
  //required: Null

  tryit(null)
  //That worked!

  val nullRef: Null = null

  tryit(nullRef)
  //That worked!

  null // Its an instance of Null- Similar to Java null.

  Nil // Represents an emptry List of anything of zero length. Its not that it refers to nothing but it refers to List which has no contents.
  Nil
  //res4: Nil.type = List()

  Nil.length
  //res5: Int = 0

  Nil + "ABC"
  //res6: List[java.lang.String] = List(ABC)

  //Nil + Nil
  //res7: List[object Nil] = List(List())

  //Nothing// is a Trait. Its a subtype of everything. But not superclass of anything. There are no instances of Nothing.

  val emptyStringList: List[String] = List[Nothing]()
  //emptyStringList: List[String] = List()

  val emptyIntList: List[Int] = List[Nothing]()
  //emptyIntList: List[Int] = List()

  //val emptyStringList: List[String] = List[Nothing]("abc")
  //<console>:4: error: type mismatch;
  // found   : java.lang.String("abc")
  //required: Nothing
  //     val emptyStringList: List[String] = List[Nothing]("abc")

  None //- Used to represent a sensible return value. Just to avoid null pointer exception. Option has exactly 2 subclasses- Some and None. None signifies no result from the method.

  def getAStringMaybe(num: Int): Option[String] = {
    if (num >= 0) Some("A positive number!")
    else None // A number less than 0?  Impossible!
  }

  //getAStringMaybe: (Int)Option[String]

  def printResult(num: Int) = {
    getAStringMaybe(num) match {
      case Some(str) => println(str)
      case None => println("No string!")
    }
  }
  //printResult: (Int)Unit

  printResult(100)
  //A positive number!

  printResult(-50)
  //No string!

  Unit //- Type of method that doesn’t return a value of anys sort.
  def doThreeTimes(fn: (Int) => Unit) = {
    fn(1); fn(2); fn(3);
  }
  //doThreeTimes: ((Int) => Unit)Unit

  doThreeTimes(println)

  def specialPrint(num: Int) = {
    println(">>>" + num + "<<<")
  }
  //specialPrint: (Int)Unit

  doThreeTimes(specialPrint)

  //Note: Any is supertype of AnyRef and AnyVal. AnyRef is the supertype of all the reference classes (like String, List, Iterable) in scala. AnyVal is the supertype of all the value classes (like Int, Float, Double, Byte, Short..). Null is a subtype of all the reference classes. null is its only instance. Nothing is subtype of every other type i.e of reference and value classes.

  //Think- AnyRef == Object in Java.

}