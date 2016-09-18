package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}
import Matchers._
import net.atos.kjc.fruitshop.purchase.Purchase

class CheckoutSpec extends FreeSpec with Matchers {
  val checkoutName = "Eco Fruit shop checkout system"

  val apple = "Apple"
  val invalidProductName = "InvalidProductName"

  val basketEmpty: List[String] = List()

  val basket1Apple:List[String] = List(apple)
  val basket2Apples:List[String] = basket1Apple :+ apple
  val basket3Apples:List[String] = basket2Apples :+ apple

  val basket1InvalidProduct:List[String] = List(invalidProductName)

  "Checkout system should" - {
    "Present right name" - {
      Checkout.name shouldBe checkoutName
    }

    "When list of products is empty should" - {
      "Return an empty Purchase" - {
        Checkout.makePurchase(basketEmpty) shouldBe a[Purchase]
      }
      "Return empty bagging area" - {
        Checkout.makePurchase(basketEmpty).baggingArea shouldBe Nil
      }
    }
    "The bagging area should" - {
      "contain one Apple" - {
        Checkout.makePurchase(basket1Apple).baggingArea.length shouldBe 1
      }
      "contain two Apples" - {
        Checkout.makePurchase(basket2Apples).baggingArea.length shouldBe 2
      }
      "contain tree Apples" - {
        Checkout.makePurchase(basket3Apples).baggingArea.length shouldBe 3
      }
      "be emty for non valid product" - {
        Checkout.makePurchase(basket1InvalidProduct).baggingArea.length shouldBe 0
      }

    }


  }
}
