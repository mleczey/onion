package com.mleczey.inbound.adapter.out.shipment

import com.mleczey.inbound.core.port.out.CargoDataAccess
import com.mleczey.inbound.domain.Cargo
import com.mleczey.inbound.domain.value.ItemName
import com.mleczey.inbound.domain.value.ShipmentId

class CargoAdapter(
  private val bridge: ShipmentInboundBridge
) : CargoDataAccess {
  override fun findShipment(id: ShipmentId, itemName: ItemName): Cargo? =
    bridge.findShipmentByShipmentIdAndItemName(id.toString(), itemName.value)
      ?.let { Cargo(ShipmentId.from(it.shipmentId), ItemName(it.itemName), it.quantity) }
}