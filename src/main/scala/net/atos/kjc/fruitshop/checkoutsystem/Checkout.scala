package net.atos.kjc.fruitshop.checkoutsystem

import net.atos.kjc.fruitshop.items.{Apples, Oranges}
import net.atos.kjc.fruitshop.offers.Offer
import net.atos.kjc.fruitshop.purchase.Purchase

object Checkout {
  def name = "Eco Fruit shop checkout system"

  def makePurchase(items: List[String]): Purchase = Purchase(items, offers)

  val offers: List[Offer] = List(
    Offer(2, 1, Apples(1)),
    Offer(3, 2, Oranges(1))
  )
}
