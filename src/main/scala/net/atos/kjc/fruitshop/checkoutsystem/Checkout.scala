package net.atos.kjc.fruitshop.checkoutsystem

import net.atos.kjc.fruitshop.purchase.Purchase

object Checkout {
  def name = "Eco Fruit shop checkout system"

  def makePurchase(items:List[String]):Purchase = Purchase()

}
