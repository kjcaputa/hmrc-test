package net.atos.kjc.fruitshop.offers

import net.atos.kjc.fruitshop.items.Items

case class Offer(amount:Int, priceInRelationToUnitCost:Double, item: Items)
