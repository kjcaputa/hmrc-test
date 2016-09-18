package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}
import net.atos.kjc.fruitshop.TestConstanceSpec

class CheckoutSpec extends FreeSpec with Matchers with TestConstanceSpec{

  "Checkout system should" - {
    "Present right name" - {
      Checkout.name shouldBe checkoutName
    }

  }
}
