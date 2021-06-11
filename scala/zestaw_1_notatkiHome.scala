
object zestaw_1_notatkiHome {
  val dniTygodnia = List(
    "Poniedzialek",
    "Wtorek",
    "Sroda",
    "Czwartek",
    "Piatek",
    "Sobota",
    "Niedziela"
  )
  //Nil - "strażnik ostatniego elementu listy"

  //Zadanie 1b
  println("\nZadanie 1b")
  def dniTygodniaStrP(dniTygodnia : List[String]) : String= {
    var dniStr = dniTygodnia.head
    val dniStrP = dniTygodnia.filter(_.startsWith("P"))
    for (dzien <- dniStrP.tail){
        dniStr += ", " + dzien
    }
    dniStr
  }
  println(dniTygodniaStrP(dniTygodnia))

  def dniTygodniaStrP2(dniTygodnia : List[String]) : String= {
    var dniStr = ""
    val dniStrP = dniTygodnia.filter(_.startsWith("P"))
    for (dzien <- dniStrP){
      dniStr += ", " + dzien
    }
    dniStr.substring(2)
  }
  println(dniTygodniaStrP2(dniTygodnia))

  //Zadanie 6
  println("\nZadanie 6")
  /*  def wypiszKrotke(krotka : Tuple3[Boolean, String, Int]) : Unit = {
    println(krotka._1 + ", " + krotka._2 + ", " + krotka._3)
  }
  wypiszKrotke(myTuple)*/

  //To rozwiązanie jest lepsze bo przyjmuje wszystkie typy. W powyższym trzeba zdefiniować wcześniej jakie będą
  def tup6[A, B, C](t : Tuple3[A, B, C]) : Unit = println(t._1 + ", " + t._2 + ", " + t._3)

  tup6(true, "To jest String", 123)

  def main(args: Array[String]): Unit = {}
}
