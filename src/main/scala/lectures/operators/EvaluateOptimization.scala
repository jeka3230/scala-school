package lectures.operators

import lectures.functions.{Computation, CurriedComputation, Data, FunctionalComputation}

/**
  * В задачке из lectures.functions.Computations, мы реализовали
  * один и тот же метод 3-я разными способами
  *
  * Пришло время оценить на сколько разные имплементации
  * отличаются друг от друга по производительности
  *
  * Для этого, раскомментируйте код, выполните в циклах вызов 3-х имплементаций
  * Оцените разницу во времени выполнения и объясните ее происхожение
  *
  */
object EvaluateOptimization extends App with Data {

  var startTimestamp = System.currentTimeMillis()


//   ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 Computation.computation(
  for (_ <- 1 to 100) {
    Computation.computation(filterData, dataArray)
  }
  var timeBasic = System.currentTimeMillis() - startTimestamp
  print("elapsed time in basic computation " + timeBasic + "\n")


  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 CurriedComputation.partiallyAppliedCurriedFunction(

  startTimestamp = System.currentTimeMillis()

  for(_ <- 1 to 100) {
    (CurriedComputation.curriedComputation(filterData)_)(dataArray)
  }
  var timeCurried = System.currentTimeMillis() - startTimestamp
  print("elapsed time in curried computation " + timeCurried + "\n")

  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 FunctionalComputation.filterApplied

  startTimestamp = System.currentTimeMillis()

  for(_ <- 1 to 100) {
   FunctionalComputation.functionalComputation(filterData)(dataArray)
  }
  var timeFunctional = System.currentTimeMillis() - startTimestamp
  print("elapsed time functional computation " + timeFunctional + "\n")

//   ВЫВЕСТИ РАЗНИЦУ В ПРОДОЛЖИТЕЛЬНОСТИ ВЫПОЛНЕНИЯ МЕЖДУ КАРРИРОВАННОЙ ВЕРСИЕЙ
//   И ФУНКЦИОНАЛЬНОЙ

  val diff = timeCurried - timeFunctional

  print(s"Difference is about $diff milliseconds")
}
// elapsed time in basic computation 11220
// elapsed time in curried computation 11060
// elapsed time functional computation 11048
// Difference is about 12 milliseconds

