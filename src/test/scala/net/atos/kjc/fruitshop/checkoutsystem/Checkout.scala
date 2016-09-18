package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}

class CheckoutSpec extends FreeSpec with Matchers {
  val checkoutName = "Eco Fruit shop checkout system"

  "Checkout system should" - {
    "Present right name" - {
      Checkout.name shouldBe checkoutName
    }
  }
}
