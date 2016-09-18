package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}
import net.atos.kjc.fruitshop.TestConstanceSpec

class CheckoutSpec extends FreeSpec with Matchers with TestConstanceSpec{

  "Checkout system should" - {
    "Present right name" - {
      Checkout.name shouldBe checkoutName
    }

    "offers" - {
      "one Apple" - {
        val purchase = Checkout.makePurchase(basket1Apple)
        assert(purchase.getTotalCost === 0.60)
      }
      "two Apple" - {
        val purchase = Checkout.makePurchase(basket2Apples)
        assert(purchase.getTotalCost === 0.60)
      }
      "tree Apple" - {
        val purchase = Checkout.makePurchase(basket3Apples)
        assert(purchase.getTotalCost === 0.60 * 2)
      }
    }
  }
}
