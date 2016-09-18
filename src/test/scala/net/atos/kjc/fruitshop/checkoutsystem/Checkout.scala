package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}
import Matchers._
import net.atos.kjc.fruitshop.purchase.Purchase

class CheckoutSpec extends FreeSpec with Matchers {
  val checkoutName = "Eco Fruit shop checkout system"

  val apple = "Apple"
  val invalidProductName = "InvalidProductName"
  val orange = "Orange"

  val basketEmpty: List[String] = List()

  val basket1Apple:List[String] = List(apple)
  val basket2Apples:List[String] = basket1Apple :+ apple
  val basket3Apples:List[String] = basket2Apples :+ apple

  val basket1Orange: List[String] = List(orange)
  val basket2Oranges: List[String] = basket1Orange :+ orange
  val basket3Oranges: List[String] = basket2Oranges :+ orange

  val basket1InvalidProduct:List[String] = List(invalidProductName)

  val basketMics: List[String] = basket3Oranges ::: basket3Apples ::: basket1InvalidProduct

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
      "be empty for non valid product" - {
        Checkout.makePurchase(basket1InvalidProduct).baggingArea.length shouldBe 0
      }
      "contain one Orange" - {
        Checkout.makePurchase(basket1Orange).baggingArea.length shouldBe 1
      }
      "contain two Oranges" - {
        Checkout.makePurchase(basket2Oranges).baggingArea.length shouldBe 2
      }
      "contain tree Oranges" - {
        Checkout.makePurchase(basket3Oranges).baggingArea.length shouldBe 3
      }
      "contain six items for mics basket" - {
        Checkout.makePurchase(basketMics).baggingArea.length shouldBe 6
      }
    }


  }
}
