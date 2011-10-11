package org.gsu.cs
import java.util.Random

class RandomArrayGenerator {

  var arrayLength: Int = 1

  def setRandomArrayLength(n: Int) = {
    arrayLength = n
  }

  /*
   * Generates a random array of integers where each element value lies between 0,10000000
   */
  def generateRandomArrayWithInputN(): Array[Int] = {

    val random = new Random()
    
    //random.setSeed(100L)

    var randomNums = new Array[Int](arrayLength);

    for (i <- 0 until arrayLength) {
      val temp = random.nextInt(1000000)
      randomNums(i) = temp
    }

    randomNums
  }

}