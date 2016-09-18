package net.atos.kjc.fruitshop

trait TestConstanceSpec {
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
}
