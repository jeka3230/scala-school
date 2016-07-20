package functions

/**
  * Created by evgeny on 13.07.16.
  */
/**
  * Цель упражнения, используя приемы динамического программирования
  * реаилзовать более оптимальный алгоритм подсчета чисел фибоначчи
  * Для этого нужно реализовать функцию fibsImpl.
  * Сигнатуру функции Вы можете расширять по своему усмотрению,
  * но реализация должна удовлетварять следующим требованиям
  * * * * метод fibsImpl - должен быть tail recursive
  * * * * параметр acc - аккумулятор посчитанных значений
  *
  */
object Fibonacci2 extends App {

  def fibs2(num: Int) =
    if (num <= 3) Array(1, 1, 2)(num - 1)
    else fibsImpl(num, Array(1, 1, 2))(num - 1)

  private def fibsImpl(num: Int, acc: Array[Int]): Array[Int] = {
    val currentLength:Int = acc.length
    if (currentLength < num) {
      fibsImpl(num, acc :+ acc(currentLength - 2) + acc(currentLength - 1))
    } else {
      acc
    }
  }

  println(fibs2(9))
  println(fibs2(1000))
}
