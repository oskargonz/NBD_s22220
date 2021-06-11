import java.io.{FileNotFoundException, FileReader, IOException}
import scala.annotation.tailrec
import scala.math.sqrt

object Hello {
/*  val dni : List[String] = "Poniedzialek" :: "Wtorek" :: "Sroda" :: "Czwartek" :: "Piatek" :: "Sobota" :: "Niedziela" :: Nil;
  //val prods = Map("a" )
  def join1a(dni : List[String]): String = {
    var resultFor = dni.head;
    for (d <- dni.tail) {resultFor += ", " + d;}
    resultFor
  }
  println(join1a(dni))*/


  def *(): Unit = println("Hello")
  *()
  def whatever(par: String) = println(par)
  whatever("xyz")
  def longer(a: Int, b: Int) = {
    println("Longer")
    a*b+2
  }
  longer(3,2)
  val a : Long= 1
  println(a)

  def fact(n: Integer):Integer={
    if (n==0) 1
    else n*fact(n-1)
  }
  println(fact(5))

  //Rekurencja ogonowa
  def factorial (n: Int):Int={
    @tailrec
    def iter(x: Int, result:Int):Int=
      if (x == 0) result
      else iter (x-1, result * x)
    iter(n,1)
  }

  println(factorial(3))

  //LISTY
  val listTest = "abc" :: List(1,2,3)
  println(listTest)

  var listTest2 : List[Any] = 1 :: 2 :: 3 :: Nil
  println(listTest2)
  listTest2 = "abc" :: listTest2
  println(listTest2)

  def concatList(myList : List[String]) : String={
    if (myList.isEmpty)
      ""
    else myList.head + concatList(myList.tail)
  }
  println(concatList(List("1", "2", "3")))

  //MAPOWANIE
  var listTest3 = List(1,2,3,4)
  println(listTest3)
  listTest3 = listTest3 map (n => 10 * n)
  println(listTest3)
  var listTest4 = List(-1,2,-3,4)
  listTest4 = listTest4 map (_ abs)
  println(listTest4)

  //FILTROWANIE
  var listTest5 = List(1, -2, 3, -4)
  listTest5 = listTest5 filter(_ > 0)
  println(listTest5)

  var listTest6 = List(1, -2, 3, -4)
  listTest6 = listTest6 filterNot(_ > 0)
  println(listTest6)

  //FOLDLEFT
  val listTest7 = List(1, 2, 3, 4)
  println(listTest7.foldLeft(0)(_ + _))

  //TUPLES
  val t = Tuple4("a", 3, 2, 4)
  val tt = ("b", 1, 2)
  println(t)
  println(tt._1)

  //MAPY / SŁOWNIKI
  val colors = Map("red" -> "#FFF0000", "azure" -> "#F0FFFF")
  println(colors.get("red"))
  println(colors.get("blue"))
  println(colors.apply("red"))
  println(colors.contains("red"))

  var carsPrice = Map("Porsche" -> 500000, "BMW" -> 200000, "Seat" -> 50000)

  var newCarPrice = carsPrice.mapValues(_ * 2)

  println(newCarPrice.apply("BMW"))
  println(colors.mapValues(_ *2).apply("red"))

  //ZBIORY
  println("ZBIORY")
  var s = Set(1,2,3,4,1)
  println(s)

  //OPCJE
  println("OPCJE")
  println(colors.get("red").getOrElse(10))
  println(colors.get("blue").getOrElse(10))

  def half(value:Int) : Option[Int] = {
    if ((value%2 == 0)) return Some(value/2)
    None
  }
  println(half(9))
  println(half(10))

  //Function literal

  val foo = (x:Int) => if (x%2 ==0) x / 2 else 3 * 3 + 1
  println(foo(5))
  var myList = List(1, 2, 3, 4, 5)
  println(myList)
  myList = myList.map(foo)
  println(myList)

  //PATTERN MATCHING
  println("\nPATTERN MATCHING")
  val n = 4
  n match {
    case 1 => println("one")
    case 2 => println("two")
    case _ => println("many")
  }

  def whatKind(x:Any) = x match {
    case s: String => s"This is string [$s]"
    case d: Double => s"$d is Double"
    case i: Int => s"$i is an Int"
    case y => s"I don't know what $y is"
  }

  println(whatKind("abc"))
  println(whatKind(5))
  println(whatKind(5.123))
  println(whatKind(false))

  def oddOrEven(n: Any) = n match {
    case n:Int if n % 2 == 0 => "Even integer"
    case n:Int => "Odd integer"
    case x => x + " is something else"
  }

  println(oddOrEven(1))
  println(oddOrEven(2))
  println(oddOrEven("Dupa"))

  //PATTERN MATCHING Try/Catch
  println("\nPATTERN MATCHING Try/Catch")
  try {
    val f = new FileReader("input.txt")
  }catch {
    case ex: FileNotFoundException => {
      println("Missing file exception")
    }
    case ex: IOException => {
      println("IOException")
    }
  } finally {
    println("Exciting finally...")
  }

  def przeciwprostokatna(a:Double, b:Double) = sqrt(a*a + b*b)
  val c3 = przeciwprostokatna(3, _)
  println(c3(4))

  //PATTERN MATCHING case class
  case class Person(name:String)
  def sayHi(p: Person) = p match {
    case Person("Dave") => "Oh, it's just Dave"
    case Person(name) => s"Hi, $name!"
  }















  def main(args: Array[String]): Unit = {
    println("\nPATTERN MATCHING case class")
    val person = Person("Dave")
    val person2 = Person("Oskar")
    println(sayHi(person))
    println(sayHi(person2))


    /*
        val people = List(
          "Bill",
          "Candy",
          123
        )
        for (p <- people) println(p)
        println("Hello, world!")




        val dniTygodnia = List(
          "Poniedzialek",
          "Wtorek",
          "Sroda",
          "Czwartek",
          "Piatek",
          "Sobota",
          "Niedziela"
        )

        def dniTygodniaStr([]):[String]={
          var dzienTygodnia = " "



    } */
  }
}