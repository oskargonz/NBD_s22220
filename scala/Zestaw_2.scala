object Zestaw_2 {

  //Zadanie 1
  println("\nZadanie 1:")

  def pracaCzyUczelnia(dzien : String) : String = dzien match {
    case "Poniedziałek" => "Praca"
    case "Wtorek" => "Praca"
    case "Środa" => "Praca"
    case "Czwartek" => "Praca"
    case "Piątek" => "Praca"
    case "Sobota" => "Weekend"
    case "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia."
  }
  println(pracaCzyUczelnia("Poniedziałek"))
  println(pracaCzyUczelnia("Sobota"))
  println(pracaCzyUczelnia("Sprzątek"))

  //Zadanie 2
  class KontoBankowe(stanKonta : Int) {
    private var stanKonta2 = stanKonta

    def this(){
      this(0)
    }

    def wplata(kwotaWplaty : Int): Unit ={
      this.stanKonta2 += kwotaWplaty
    }

    def wyplata(kwotaWyplaty : Int): Unit ={
      if (this.stanKonta > kwotaWyplaty) this.stanKonta2 -= kwotaWyplaty
      else  println("Brak środków na koncie.")
    }

    def getStanKonta = stanKonta2
  }

  //Zadanie 3
  case class Osoba(imie:String, nazwisko:String){

  }
  def przywitanie(osoba: Osoba) : String = osoba match {
    case Osoba("Jan", "Kowalski") => "Cześć Johny!"
    case Osoba("Oskar", "Gąsior") => "Siema Gąs!"
    case Osoba("Lewis","Hamilton") => "Hello Sir!"
    case _ => "Hello " + osoba.imie + " " + osoba.nazwisko
  }

  //Zadanie 4
  println("\nZadanie 4:")

  val funkcja = (x: Int) => x*x
  val x = 2

  def zad4(x : Int, funkcja : Int => Int) = {
    funkcja(funkcja(funkcja(x)))
  }

  //Zadanie 5
  abstract class Person (val imie : String, val nazwisko : String){
    def podatek: Double
  }

  trait Student extends Person {
    override def podatek : Double = 0

  }

  trait Nauczyciel extends Pracownik {
    override def podatek : Double = 0.1 * this.pensja
  }

  trait Pracownik extends Person {
    var pensja = 0.0

    def getPensja : Double = {
      this.pensja
    }

    def setPensja(nowaPensja : Double) = {
      this.pensja = nowaPensja
    }
    override def podatek : Double = 0.2 * this.pensja

  }




  def main(args: Array[String]): Unit = {

    //Zadanie 2
    println("\nZadanie 2:")
    val mojeKonto = new KontoBankowe(1000)
    println("Srodki na koncie: " + mojeKonto.getStanKonta)
    mojeKonto.wplata(1000)
    println("Srodki na koncie: " + mojeKonto.getStanKonta)
    mojeKonto.wyplata(500)
    println("Srodki na koncie: " + mojeKonto.getStanKonta)
    mojeKonto.wyplata(5000)
    println("Srodki na koncie: " + mojeKonto.getStanKonta)

    //Zadanie 3
    println("\nZadanie 3:")
    val osoba1 = new Osoba("Jan", "Kowalski")
    val osoba2 = new Osoba("Oskar", "Gąsior")
    val osoba3 = new Osoba("Lewis", "Hamilton")
    val osoba4 = new Osoba("Roger", "Federer")

    println(przywitanie(osoba1))
    println(przywitanie(osoba2))
    println(przywitanie(osoba3))
    println(przywitanie(osoba4))

    //Zadanie 4
    println("\nZadanie 4:")
    println(zad4(x, funkcja))

    //Zadanie 5
    println("\nZadanie 5:")

    val student = new Person("Oskar", "Gąsior") with Student
    println("Podatek student: " + student.podatek)

    val pracownik = new Person("Jan", "Kowalski") with Pracownik
    pracownik.setPensja(1000)
    println("Podatek pracownik: " + pracownik.podatek + " (Pensja: " + pracownik.getPensja + ")")

    val nauczyciel = new Person("Janina", "Kowalski") with Nauczyciel
    nauczyciel.setPensja(1000)
    println("Podatek nauczyciel: " + nauczyciel.podatek + " (Pensja: " + nauczyciel.getPensja + ")")

    val student_pracownik = new Person("Oskar", "Gąsior") with Student with Pracownik
    student_pracownik.setPensja(1000)
    println("Podatek student_pracownik: " + student_pracownik.podatek + " (Pensja: " + student_pracownik.getPensja + ")")

    val pracownik_student = new Person("Jan", "Kowalski") with Pracownik with Student
    pracownik_student.setPensja(1000)
    println("Podatek pracownik_student: " + pracownik_student.podatek  + " (Pensja: " + pracownik_student.getPensja + ")")


  }
}
