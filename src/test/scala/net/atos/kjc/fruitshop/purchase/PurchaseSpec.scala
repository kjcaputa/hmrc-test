package net.atos.kjc.fruitshop.purchase

import net.atos.kjc.fruitshop.TestConstanceSpec
import net.atos.kjc.fruitshop.items.Items
import org.scalatest.{FreeSpec, Matchers}

class PurchaseSpec extends FreeSpec with Matchers with TestConstanceSpec{
  "When list of products is empty should" - {
    "Return an empty Purchase" - {
      Purchase(basketEmpty) shouldBe a[Purchase]
    }
    "Return empty bagging area" - {
      Purchase(basketEmpty).baggingArea shouldBe Nil
    }
  }

  "The bagging area should" - {
    "contain one Apple" - {
      Purchase(basket1Apple).getPurchaseLength shouldBe 1
    }
    "contain two Apples" - {
      Purchase(basket2Apples).getPurchaseLength shouldBe 2
    }
    "contain tree Apples" - {
      Purchase(basket3Apples).getPurchaseLength shouldBe 3
    }
    "be empty for non valid product" - {
      Purchase(basket1InvalidProduct).getPurchaseLength shouldBe 0
    }
    "contain one Orange" - {
      Purchase(basket1Orange).getPurchaseLength shouldBe 1
    }
    "contain two Oranges" - {
      Purchase(basket2Oranges).getPurchaseLength shouldBe 2
    }
    "contain tree Oranges" - {
      Purchase(basket3Oranges).getPurchaseLength shouldBe 3
    }
    "contain six items for mics basket" - {
      Purchase(basketMics).getPurchaseLength shouldBe 6
    }
    "be a type of Items for misc basket" - {
      Purchase(basketMics).baggingArea.head shouldBe a[Items]
    }

  }

  "total cost" - {
    "of 1 x Apples should equal to 0.60" - {
      val purchase = Purchase(basket1Apple)
      purchase.getTotalCost shouldBe 0.60 +- 0.001
    }

    "of 2 x Apples equal to 1.20" - {
      val purchase = Purchase(basket2Apples)
      purchase.getTotalCost shouldBe 1.20 +- 0.001
    }

    "of InvalidItems should equal to 0.0" - {
      val purchase = Purchase(basket1InvalidProduct)
      purchase.getTotalCost shouldBe 0.0 +- 0.001
    }

    "of empty basket should equal to 0.0" - {
      val purchase = Purchase(basketEmpty)
      purchase.getTotalCost shouldBe 0.0 +- 0.001
    }

    "of 3 x Apples & 3x Orange & 1x InvalidItem equal to (3*0.60+3*0.25)" - {
      val purchase = Purchase(basketMics)
      purchase.getTotalCost shouldBe (3 * .60 + 3 * .25) +- 0.001
    }
  }

  "print summary" - {
    "for empty basket" - {
      val purchase = Purchase(basketEmpty)
      purchase.getSummary shouldBe "[] = £0.00"
    }
    "for basket with one Apple" - {
      val purchase = Purchase(basket1Apple)
      purchase.getSummary shouldBe "[1x Apple] = £0.60"
    }
  }
}
