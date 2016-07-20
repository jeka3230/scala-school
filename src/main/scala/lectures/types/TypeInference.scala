package types

/**
  * Created by evgeny on 13.07.16.
  */
object TypeInference extends App {

  def printSomething() = "2 плюс 3 - это "

  def calculateSomething() = 1 + 1

  def result = printSomething + 3 + calculateSomething

  print(result)

}