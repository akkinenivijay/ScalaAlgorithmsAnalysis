package org.gsu.cs.util
import scala.util.Random

class SortUtil {

}

/**
 *
 * @author va2839
 *
 */
object SortUtil {

  /**
   * Calculated the number of passes the counting sort should be performed for
   * different bases
   */
  def calculateNumberOfPasses(limit: Int, base: Int) = {
    val count = Math.ceil(Math.log(limit) / Math.log(base));
    count
  }

  def extractIndexNthSignificantDigitForBase(input: Int, base: Int, index: Int) = {
    var reminder = 0
    var times = 0
    var _input = input
    var digit = index

    while (digit > 0) {
      times = _input / base;
      reminder = _input % base;

      _input = times
      digit = digit - 1
    }

    reminder;

    //    //    var temp = _input % Math.pow(base, index)
    //    //    var reminder = (temp / base).toInt
    //
    //    reminder
  }

  def copyArray(inputArray: Array[Int], size: Int) = {
    var outputArray: Array[Int] = new Array(size);
    var i = 0
    for (i <- 0 until size) {
      outputArray(i) = inputArray(i);
    }
    outputArray;
  }

  /**
   * generates a random array where the n range lies between 0 - 20000
   *
   * @param size
   * @return
   */
  def generateRandomArray(size: Int) = {

    var array: Array[Int] = new Array(size)
    var random = new Random()

    var i = 0;
    for (i <- 0 until size) {
      array(i) = random.nextInt(20000);
    }

    array
  }

}


