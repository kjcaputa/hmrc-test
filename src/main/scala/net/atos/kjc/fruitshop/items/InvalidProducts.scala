package net.atos.kjc.fruitshop.items

case class InvalidProducts(list: List[String]) extends Items {
  override val cost: Double = 0.0
  override val amount: Int = list.size
  override val name: String = "Invalid_Product"
}
