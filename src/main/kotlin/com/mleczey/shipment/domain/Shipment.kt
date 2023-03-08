package com.mleczey.shipment.domain

import com.mleczey.shipment.domain.value.ShipmentId

data class Shipment(val id: ShipmentId, val symbol: String, val items: Collection<Item>) {
  fun findItemByItemName(itemName: String): Item? = items.find { it.name == itemName }
}