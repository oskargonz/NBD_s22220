import com.sun.tools.attach.VirtualMachine.list

import scala.annotation.tailrec
import scala.collection.MapView

object zestaw_1 {
  val dniTygodnia = List(
    "Poniedzialek",
    "Wtorek",
    "Sroda",
    "Czwartek",
    "Piatek",
    "Sobota",
    "Niedziela"
  )

  //Zadanie 1a
  println("\nZadanie 1a")
  def dniTygodniaStr(dniTygodnia : List[String]): String ={
    var dniStr = dniTygodnia.head
    for(dzien <- dniTygodnia.tail){
      dniStr += ", " + dzien
    }
    dniStr
  }
  println(dniTygodniaStr(dniTygodnia))

  //Zadanie 1b
  println("\nZadanie 1b")

  def dniTygodniaStrP(dniTygodnia : List[String]) : String= {
    var dniStr = ""
    for (dzien <- dniTygodnia){
      if (dzien.charAt(0) == 'P'){
        dniStr += ", " + dzien
      }
    }
    dniStr.substring(2)
  }
  println(dniTygodniaStrP(dniTygodnia))

  //Zadanie 1c
  println("\nZadanie 1c")

  def dniTygodniaStrWhile(dniTygodnia : List[String]) : String = {
    var dniStr = dniTygodnia.head
    var n = 1
    while (n < dniTygodnia.length){
      dniStr += ", " + dniTygodnia.apply(n)
      n += 1
    }
    dniStr
  }
  println(dniTygodniaStrWhile(dniTygodnia))

  //Zadanie 2a
  println("\nZadanie 2a")

  def dniTygodniaRekurencja(dniTygodnia : List[String]) : String = {
    if (dniTygodnia.tail.isEmpty) dniTygodnia.head
    else dniTygodnia.head + ", " + dniTygodniaRekurencja(dniTygodnia.tail)
  }
  println(dniTygodniaRekurencja(dniTygodnia))

  //Zadanie 2b
  println("\nZadanie 2b")

  def dniTygodniaRekurencja2(dniTygodnia : List[String]) : String = {
    if (dniTygodnia.tail.isEmpty) dniTygodnia.head
    else dniTygodniaRekurencja2(dniTygodnia.tail) + ", " + dniTygodnia.head
  }
  println(dniTygodniaRekurencja2(dniTygodnia))

  //Zadanie 3
  println("\nZadanie 3")

  def dniTygodniaRekurencjaOgonowa(dniTygodnia : List[String]) : String = {
    @tailrec
    def iter(dniTygodnia2 : List[String], result:String): String = {
      if (dniTygodnia2.tail.isEmpty) result + ", " + dniTygodnia2.head
      else iter(dniTygodnia2.tail, result + ", " + dniTygodnia2.head)
    }
    iter(dniTygodnia, "").substring(2)
  }
  println(dniTygodniaRekurencjaOgonowa(dniTygodnia))

  //Zadanie 4a
  println("\nZadanie 4a")

  def dniTygodniaFoldl(dniTygodnia : List[String]) : String = {
    dniTygodnia.foldLeft("")(_ + ", " + _).substring(2)
  }
  println(dniTygodniaFoldl(dniTygodnia))

  //Zadanie 4b
  println("\nZadanie 4b")

  def dniTygodniaFoldr(dniTygodnia : List[String]) : String = {
    dniTygodnia.init.foldRight(dniTygodnia.last)(_ + ", " + _)
  }
  println(dniTygodniaFoldr(dniTygodnia))

  //Zadanie 4c
  println("\nZadanie 4c")

  def dniTygodniaFoldlP(dniTygodnia : List[String]) : String = {
    val dniStrP = dniTygodnia.filter(_.startsWith("P"))
    dniStrP.foldLeft("")(_ + ", " + _).substring(2)
  }
  println(dniTygodniaFoldlP(dniTygodnia))

  //Zadanie 5
  println("\nZadanie 5")

  val produkty = Map("Piwo" -> 5, "Bułka" -> 1, "Herbata" -> 2, "Mięso" -> 10, "Papryka" -> 7)
  def obnizkaCen(products : Map[String, Int]) : Map[String, Double] = {
    products.map(product => (product._1, product._2 * 0.9))
  }
  println(obnizkaCen(produkty))

  //Zadanie 6
  println("\nZadanie 6")

  val myTuple = Tuple3(true, "To jest String", 123)

  def wypiszKrotke[X, Y, Z](t : Tuple3[X, Y, Z]) : Unit =
    println(t._1 + ", " + t._2 + ", " + t._3)

  wypiszKrotke(myTuple)

  //Zadanie 7
  println("\nZadanie 7")

  def opcja(myMap : Map[String, Int], findValue : String) : Option[Int] = {
    if (myMap.get(findValue) == None) return None
    myMap.get(findValue)
  }
  println(opcja(produkty, "Kielbasa"))
  println(opcja(produkty, "Piwo"))

  //Zadanie 8
  println("\nZadanie 8")

  var listOfNumbers = List(1, 2, 3, 0, 4, 5, 6, 0, 7, 8, 0, 9, 10)
    def deleteZeros(myList : List[Int], n : Int) : List[Int] = myList match {
      case Nil => Nil
      case h::t =>
        if (h == n)
          deleteZeros(t, n)
        else
          h :: deleteZeros(t, n)
    }
  println(deleteZeros(listOfNumbers, 0))


  //Zadanie 9
  println("\nZadanie 9")

  def increaseByOne(list: List[Int]) : List[Int] = {
    list map (_ +1)
  }

  println(increaseByOne(listOfNumbers))

  //Zadanie 10
  println("\nZadanie 10")
  var listOfDecimals = List(1.12, 2.14, 3.612, 0, 40, -5, -6, 17, 18.4569, 9, 10.6548)

  def listOfAbs(list : List[Double]) : List[Double] = {
    list filter(_ >= -5) filter(_ <= 12) map (_ abs)
  }

  println(listOfAbs(listOfDecimals))







  def main(args: Array[String]): Unit = {

  }

}
