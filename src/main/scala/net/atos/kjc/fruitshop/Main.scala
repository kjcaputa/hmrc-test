package net.atos.kjc.fruitshop

import net.atos.kjc.fruitshop.checkoutsystem.Checkout

object Main {
  def main(args: Array[String]): Unit = {
    val purchase = Checkout.makePurchase(args.toList)

    println(Checkout.name)
    println("Basket contain")
    println(purchase.getSummary)
  }
}
