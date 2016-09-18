package net.atos.kjc.fruitshop.items

case class Oranges(amount: Int) extends Items {
  override val cost: Double = 0.25
  override val name: String = "Orange"
}
