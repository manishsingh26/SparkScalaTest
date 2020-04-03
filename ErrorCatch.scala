
object ErrorCatch {

  def main(args: Array[String]): Unit = {

    val a = "hello"

    try {
      val b = a.toFloat / 1
      println(b)
    } catch {

      case e: Exception => println("exception caught: " + e)
    }

  }

}
