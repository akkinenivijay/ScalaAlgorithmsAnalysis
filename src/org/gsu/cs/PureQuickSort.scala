package org.gsu.cs

class PureQuickSort {

  /*
   * Function to perform a quicksort on the given input
   * It calls the sort method recursively on the left and right partitions
   */
  def sort(input: Array[Int], left: Int, right: Int): Unit = {
    if (left >= right) return
    val index = partition(input, left, right)
    sort(input, left, index)
    sort(input, index + 1, right)
  }

  def partition(input: Array[Int], left: Int, right: Int) = {
    var i: Int = left - 1
    var j: Int = right + 1

    var pivot = input(left)

    while (i < j) {
      i = i + 1
      while (input(i) < pivot)
        i = i + 1;

      j = j - 1
      while (input(j) > pivot)
        j = j - 1;
      if (i < j) {
        val temp = input(i);
        input(i) = input(j);
        input(j) = temp;
      }
    };
    j
  }

}