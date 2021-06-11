object Test {
  val dniTygodnia = List(
    "Poniedzialek",
    "Wtorek",
    "Sroda",
    "Czwartek",
    "Piatek",
    "Sobota",
    "Niedziela"
  )

  def dniTygodniaRekurencja2(dniTygodnia : List[String]) : String = {
    if (dniTygodnia.tail.isEmpty) dniTygodnia.head
    else dniTygodniaRekurencja2(dniTygodnia.tail) + ", " + dniTygodnia.head
  }
  println(dniTygodniaRekurencja2(dniTygodnia))
  def main(args: Array[String]): Unit = {}

}
