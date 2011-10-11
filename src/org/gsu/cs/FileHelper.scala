package org.gsu.cs
import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter

class FileHelper(file: File) {
  def write(text: String): Unit = {
    val fw = new FileWriter(file)
    var bw = new BufferedWriter(fw)
    try {
      bw.write(text)
    } finally {
      bw.close
      fw.close
    }
  }
}

object FileHelper {
  implicit def file2helper(file: File) = new FileHelper(file)
}