package net.atos.kjc.fruitshop.checkoutsystem

import org.scalatest.{FreeSpec, Matchers}
import Matchers._
import net.atos.kjc.fruitshop.items.{Apples, Items, Oranges}
import net.atos.kjc.fruitshop.purchase.Purchase

class CheckoutSpec extends FreeSpec with Matchers {
  val checkoutName = "Eco Fruit shop checkout system"

  val apple = "Apple"
  val invalidProductName = "InvalidProductName"
  val orange = "Orange"

  val basketEmpty: List[String] = List()

  val basket1Apple: List[String] = List(apple)
  val basket2Apples: List[String] = basket1Apple :+ apple
  val basket3Apples: List[String] = basket2Apples :+ apple

  val basket1Orange: List[String] = List(orange)
  val basket2Oranges: List[String] = basket1Orange :+ orange
  val basket3Oranges: List[String] = basket2Oranges :+ orange

  val basket1InvalidProduct: List[String] = List(invalidProductName)

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
        Checkout.makePurchase(basket1Apple).getPurchaseLength shouldBe 1
      }
      "contain two Apples" - {
        Checkout.makePurchase(basket2Apples).getPurchaseLength shouldBe 2
      }
      "contain tree Apples" - {
        Checkout.makePurchase(basket3Apples).getPurchaseLength shouldBe 3
      }
      "be empty for non valid product" - {
        Checkout.makePurchase(basket1InvalidProduct).getPurchaseLength shouldBe 0
      }
      "contain one Orange" - {
        Checkout.makePurchase(basket1Orange).getPurchaseLength shouldBe 1
      }
      "contain two Oranges" - {
        Checkout.makePurchase(basket2Oranges).getPurchaseLength shouldBe 2
      }
      "contain tree Oranges" - {
        Checkout.makePurchase(basket3Oranges).getPurchaseLength shouldBe 3
      }
      "contain six items for mics basket" - {
        Checkout.makePurchase(basketMics).getPurchaseLength shouldBe 6
      }
      "be a type of Items for misc basket" - {
        Checkout.makePurchase(basketMics).baggingArea.head shouldBe a[Items]
      }

    }
    "For items" - {
      "The cost" - {
        "unit of Apple should be 0.60" - {
          Apples(1).cost shouldBe 0.60 +- 0.001
        }
        "unit of Oranges should be 0.25" - {
          Oranges(1).cost shouldBe 0.25 +- 0.001
        }
      }
      "should indicate right amount of items in cattegory" - {
        Apples(2).amount shouldBe 2
        Apples(6).amount shouldBe 6
        Oranges(2).amount shouldBe 2
        Oranges(6).amount shouldBe 6
      }
      "should inherit from the same Item class" - {
        Apples(1) shouldBe a[Items]
        Oranges(1) shouldBe a[Items]
      }

    }
    "total cost" - {
      "of 1 x Apples should equal to 0.60" - {
        val purchase = Checkout.makePurchase(basket1Apple)
        purchase.getTotalCost shouldBe 0.60 +- 0.001
      }

      "of 2 x Apples equal to 1.20" - {
        val purchase = Checkout.makePurchase(basket2Apples)
        purchase.getTotalCost shouldBe 1.20 +- 0.001
      }

      "of InvalidItems should equal to 0.0" - {
        val purchase = Checkout.makePurchase(basket1InvalidProduct)
        purchase.getTotalCost shouldBe 0.0 +- 0.001
      }

      "of empty basket should equal to 0.0" - {
        val purchase = Checkout.makePurchase(basketEmpty)
        purchase.getTotalCost shouldBe 0.0 +- 0.001
      }

      "of 3 x Apples & 3x Orange & 1x InvalidItem equal to (3*0.60+3*0.25)" - {
        val purchase = Checkout.makePurchase(basketMics)
        purchase.getTotalCost shouldBe (3 * .60 + 3 * .25) +- 0.001
      }
    }
    "print summary" - {
      "for empty basket" - {
        val purchase = Checkout.makePurchase(basketEmpty)
        purchase.getSummary shouldBe "[] = £0.00"
      }
      "for basket with one Apple" - {
        val purchase = Checkout.makePurchase(basket1Apple)
        purchase.getSummary shouldBe "[1x Apple] = £0.60"
      }
    }
  }
}
