package org.gsu.cs
import java.io.File
import java.util.GregorianCalendar
import java.io.BufferedWriter
import java.io.FileWriter

object SortingAnalysis {

  var sumOfInsertionSortRunTimes: Long = 0
  var sumOfQuickSortRunTimes: Long = 0

  def main(args: Array[String]): Unit = {

    val dir = new File("/tmp/sortanalysis")
    dir.mkdirs
    val file = new File(dir, "quicksortaverage.txt")
    val fw = new FileWriter(file)
    var bw = new BufferedWriter(fw)

    for (arraySize <- 1 until 20) {

      sumOfInsertionSortRunTimes = 0;
      sumOfQuickSortRunTimes = 0;

      val insertionSort = new PureInsertionSort

      for (repeat <- 0 until 100000) {

        val insertionSortInputarray = worstCaseArrayForSize(arraySize)

        //        for (inp <- 0 until insertionSortInputarray.length)
        //          print(insertionSortInputarray(inp) + " ")
        //
        //        println

        //val quickSortInputArray = replicateInput(insertionSortInputarray)

        //val tempInsertTime = runInsertionSortOnVariousInputs(insertionSortInputarray)

        //val tempQuickTime = runQuickSortOnVariousInputs(quickSortInputArray)

        val startTime = getTimeInMilliSeconds()
        insertionSort.sort(insertionSortInputarray)
        val endTime = getTimeInMilliSeconds()

        //Not counting the first 99 runs as there are JVM initialization costs
        if (repeat > 999) {
          sumOfInsertionSortRunTimes += (endTime - startTime)
          //sumOfQuickSortRunTimes += tempQuickTime
        }

      }

      //val averageInsertionRunTime: Double = sumOfInsertionSortRunTimes / 99000;
      //val averageQuickRunTime: Double = sumOfQuickSortRunTimes / count;

      println(arraySize + "\t" + sumOfInsertionSortRunTimes / 99000)

      //bw.write(arraySize + "\t" + averageInsertionRunTime + "\t" + averageQuickRunTime + "\n")
    }

    bw.close();
    fw.close()
  }

  def runInsertionSortOnVariousInputs(randomArray: Array[Int]) = {

    //Creating a new instance of Quick Sort
    val insertionSort = new PureInsertionSort

    //Applying Insertion Sort using the newly created object
    val startTime = getTimeInMilliSeconds()
    insertionSort.sort(randomArray)
    val endTime = getTimeInMilliSeconds()

    endTime - startTime
  }

  def runQuickSortOnVariousInputs(randomArray: Array[Int]) = {

    //Creating a new instance of Quick Sort
    val quickSort = new PureQuickSort

    //Applying Insertion Sort using the newly created object
    val startTime = getTimeInMilliSeconds()
    quickSort.sort(randomArray, 0, randomArray.length - 1)
    val endTime = getTimeInMilliSeconds()

    //println(endTime-startTime)

    endTime - startTime
  }

  def randomArrayForSize(n: Int) = {
    val randomArrayGenerator = new RandomArrayGenerator

    //Setting the size of the random numbers array
    randomArrayGenerator.setRandomArrayLength(n)

    //Generating a random array of integers with the length set above
    val returnArray = randomArrayGenerator.generateRandomArrayWithInputN()

    returnArray
  }

  def worstCaseArrayForSize(n: Int) = {
    val returnArray = new Array[Int](n)

    for (i <- 0 until n) {
      returnArray(i) = n - i
    }

    returnArray
  }

  def getTimeInMilliSeconds() = {

    var time = System.nanoTime()

    time
  }

  def replicateInput(inputArray: Array[Int]) = {

    val outputArray = new Array[Int](inputArray.length)

    for (i <- 0 until inputArray.length)
      outputArray(i) = inputArray(i)

    outputArray
  }

}