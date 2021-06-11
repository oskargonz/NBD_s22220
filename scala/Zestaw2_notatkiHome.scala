import scala.io.Source

object Zestaw2_notatkiHome {
  trait Reader{
    def read(source:String):String
  }

  trait StringReader extends Reader {
    override def read(source: String): String = {
      Source.fromString(source).mkString
    }
  }
  abstract class Bird

  trait Flying{
    def flyMessage:String
    def fly() = println(flyMessage)
  }

  trait Swimming {
    def swim() = println("I'm swimming")
  }

  class Penguin extends Bird with Swimming

  class Pigeon extends Bird with Flying {
    val flyMessage = "Im a good flyer"
  }

  class Hawk extends Bird with Swimming with Flying {
    val flyMessage = "Im and excellent flyer"
  }

/*  class Person(var name : String, var age : Int){
    def getDetails = name + " " + age
  }
  class Student(name : String, age : Int, var moreDetails : String) extends Person(name, age) with Reader{
    override def getDetails: String = {
      val details = read(moreDetails)
      "Student details\n" + name + " " + age + "\n" + "More: " + details
    }
  }*/
  def main(args: Array[String]) {
    val pigeon = new Pigeon with Swimming
    pigeon.swim()
    pigeon.fly()

    //var student = new Student("Oskar", 25, "blablabla") with StringReader
  }
}
