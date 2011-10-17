package test
import org.gsu.cs.util.SortUtil

object WorldlyApp {

  def main(args: Array[String]): Unit = {
    var wg = new WorldlyGreeter("hello")
    wg.greet();
    var str = WorldlyGreeter.worldify("heippyyyyy")
    println(str)

    println(SortUtil.extractIndexNthSignificantDigitForBase(123, 10, 1))

    val arr = Array(1, 2, 3, 4)
    print(arr)
    print(SortUtil.copyArray(arr, 4))
    
    print(SortUtil.generateRandomArray(4))
  }

}