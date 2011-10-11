package org.gsu.cs

class PureInsertionSort {

  def sort(input: Array[Int]) = {

    var i = 0
    var j = 0
    var value = 0

    for (i <- 1 until input.length) {
      value = input(i)
      j = i

      while (j > 0 && input(j - 1) > value) {
        input(j) = input(j - 1)
        j = j - 1;
      }

      input(j) = value
    }
  }
}