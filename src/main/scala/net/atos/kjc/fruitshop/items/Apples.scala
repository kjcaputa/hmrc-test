package net.atos.kjc.fruitshop.items

case class Apples(amount: Int) extends Items {
  override val cost: Double = 0.60
  override val name: String = "Apple"
}
