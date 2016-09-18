package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}
import Matchers._
import net.atos.kjc.fruitshop.purchase.Purchase

class CheckoutSpec extends FreeSpec with Matchers {
  val checkoutName = "Eco Fruit shop checkout system"

  val basketEmpty: List[String] = List()

  "Checkout system should" - {
    "Present right name" - {
      Checkout.name shouldBe checkoutName
    }

    "Return an empty purchase for empty list of products" - {
      Checkout.makePurchase(basketEmpty) shouldBe a [Purchase]
    }
  }
}
