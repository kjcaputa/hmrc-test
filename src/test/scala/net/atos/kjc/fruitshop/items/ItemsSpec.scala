package net.atos.kjc.fruitshop.items

import org.scalatest.{FreeSpec, Matchers}

class ItemsSpec extends FreeSpec with Matchers {
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
}
