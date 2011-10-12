package test

object WorldlyApp {

  def main(args: Array[String]): Unit = {
    var wg = new WorldlyGreeter("hello")
    wg.greet();
    var str = WorldlyGreeter.worldify("heippyyyyy")
    print(str)
  }

}