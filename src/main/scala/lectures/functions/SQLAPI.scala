package lectures.functions

/**
  * Представим себе, как бы мог выглядеть API для работы, например, с БД
  * Строить методы этого API будем через композицию уже определенных методов.
  *
  * Ваша задача реализовать метод execute, композируя методы из объекта SQLAPI
  * Метод execute из объекта SQLAPI должен выполнить следующие действия
  * * * * * залогировать ресурс
  * * * * * получить соединение с помощью метода connection
  * * * * * залогировать соединение
  * * * * * открыть соединение
  * * * * * выполнить SQL
  * * * * * залогировать результат
  *
  *
  * Обратите внимание на то, что композиция функций учит писать код в декларативном виде
  * Благодаря этому мы можем отделить реализацию методов от их применения и, в конечном итоге, иметь переиспользуемую
  * декларацию, которую можно применить, например, для настоящей БД
  *
  *
  */
object SQLAPI extends App {

  case class Connection(resource: String, opened: Boolean = false) {

    private val result = "SQL has been executed. Congratulations!"

    def open(): Connection = this.copy(opened = true)

    def execute(sql: String): String = if(opened) result else throw new Exception("You have to open connection before execute")

  }

  private def logParameter[T](prm: T): T  = {
    println(prm)
    prm
  }

  val connection = (resource: String) => Connection(resource)

  def execute(resource: String, sql: String): String = {
    ((logParameter[String]_ andThen connection andThen logParameter andThen openConnection)(resource) andThen logParameter)(sql)
  }


  def openConnection(connection: Connection): (String) => String =
    (sql: String) => {
      connection.open execute sql
  }

  execute("some DB", "some SQL")
}
