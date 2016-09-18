package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}
import Matchers._

class CheckoutSpec extends FreeSpec with Matchers {
  val checkoutName = "Eco Fruit shop checkout system"

  val basketEmpty: List[String] = List()

  "Checkout system should" - {
    "Present right name" - {
      Checkout.name shouldBe checkoutName
    }

    "Return an empty purchase for empty list of products" -{
      assert(Checkout.makePurchase(basketEmpty).equals(Nil))
    }
  }
}
