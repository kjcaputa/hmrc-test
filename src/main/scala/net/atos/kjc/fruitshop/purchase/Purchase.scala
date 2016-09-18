package net.atos.kjc.fruitshop.purchase

case class Purchase(items: List[String]) {
  val baggingArea = {

    def productChecker(item: String): Boolean = item match {
      case "Apple" => true
      case "Orange" => true
      case _ => false
    }

    def helper(items: List[String], acc: List[String]): List[String] = {
      items match {
        case Nil => acc
        case x :: xs =>
          if (productChecker(x))
            helper(xs, acc :+ x)
          else
            helper(xs, acc)
      }
    }

    helper(items, Nil)
  }
}
