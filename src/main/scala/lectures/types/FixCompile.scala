package types

/**
 * Created by evgeny on 13.07.16.
 */
/**
 * Программа должна удвоить все нечетные члены List и потом просуммировать,
 * сохранив результат в 'result'
 *
 * Ваша задача:
 * Раскоментируйте код
 * Исправьте тело метода mapper так, чтобы программа скопмилировалась
 */
object FixCompile extends App {

        val mapper = (i: Int) => if (i % 2 != 0) i * 2 else 0

        val result = List[Int](1, 2, 3, 4, 5, 6, 7, 8, 9).map {
              mapper
            }.foldLeft(0) { (accumelated, v) => accumelated + v }

         print(result)
        }
