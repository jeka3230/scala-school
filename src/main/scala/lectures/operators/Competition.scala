package operators

/**
  * Created by evgeny on 13.07.16.
  */
object Competition extends App {

  val locals = Map("Artem" -> 6, "Sergey" -> 5, "Anton" -> 2, "Vladimir" -> "2", "Alexander" -> 4l)
  val foreigners = Map("John" -> 3, "James" -> 1, "Tom" -> 2, "Dick" -> 5, "Eric" -> 6)

    val results = for (l <- locals;
                       f <- foreigners)
    yield {
      val localName = l._1
      val localValue = l._2.toString.toInt
      val foreignName = f._1
      val foreignValue = f._2.toString.toInt
      localName + " vs " + foreignName -> (localValue - foreignValue)
    }

    var finalResult = 0
    for(r <- results) {
      if (r._2 > 0) {
        finalResult += 1
      }
      else if (r._2 < 0) {
        finalResult -= 1
      } else {
        finalResult = finalResult
      }
    }
  if (finalResult > 0) {
    print("Победили наши")
  } else if (finalResult < 0) {
    print("Победили чужие")
  } else {
    print("Победила дружба")
  }
}
