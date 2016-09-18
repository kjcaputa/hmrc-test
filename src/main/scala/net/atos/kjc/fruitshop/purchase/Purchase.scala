package net.atos.kjc.fruitshop.purchase

import net.atos.kjc.fruitshop.items.{Apples, InvalidProducts, Items, Oranges}
import net.atos.kjc.fruitshop.offers.Offer

case class Purchase(items: List[String], offers: List[Offer] = Nil) {
  val baggingArea: List[Items] = {

    def productChecker(item: String): Items = item match {
      case "Apple" => Apples(1)
      case "Orange" => Oranges(1)
      case _ => InvalidProducts(List(item))
    }

    def helper(items: List[String], acc: Map[String, Items]): Map[String, Items] = {
      items match {
        case Nil => acc
        case x :: xs =>
          productChecker(x) match {
            case y: Oranges =>
              helper(xs, acc + (x -> Oranges(acc.getOrElse(x, Oranges(0)).amount + 1)))
            case y: Apples =>
              helper(xs, acc + (x -> Apples(acc.getOrElse(x, Apples(0)).amount + 1)))
            case y: InvalidProducts =>
              helper(xs, acc)
          }
      }
    }

    helper(items, Map()).values.toList
  }

  lazy val getPurchaseLength: Int = baggingArea.foldLeft(0)(_ + _.amount)

  lazy val getTotalCost: Double = baggingArea.foldLeft(0.0) { (acc, i) =>
    offers.find(_.item.getClass.getCanonicalName == i.getClass.getCanonicalName) match {
      case Some(x) =>
        val m = i.amount % x.amount
        acc + (i.cost * x.priceInRelationToUnitCost * (i.amount - m) / x.amount) + (i.cost * m)
      case x =>
        acc + (i.cost * i.amount)
    }
  }


  lazy val getSummary: String =
    baggingArea.map(item => "%dx %s".format(item.amount, item.name)).mkString("[", ", ", "] = £%2.2f".format(getTotalCost))
}
