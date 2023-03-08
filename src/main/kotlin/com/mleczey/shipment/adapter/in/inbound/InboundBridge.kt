package com.mleczey.shipment.adapter.`in`.inbound

import com.mleczey.inbound.adapter.out.shipment.ShipmentInboundBridge
import com.mleczey.inbound.adapter.out.shipment.ShipmentView
import com.mleczey.shipment.core.port.`in`.FindShipmentQuery
import com.mleczey.shipment.core.port.`in`.FindShipmentUseCase
import com.mleczey.shipment.domain.value.ShipmentId

class InboundBridge(
  private val findShipmentUseCase: FindShipmentUseCase
) : ShipmentInboundBridge {
  override fun findShipmentByShipmentIdAndItemName(shipmentId: String, itemName: String): ShipmentView? {
    val shipment = findShipmentUseCase.findShipment(FindShipmentQuery(ShipmentId.from(shipmentId)))
    return shipment?.findItemByItemName(itemName)?.let { ShipmentView(shipment.id.toString(), it.name, it.quantity) }
  }
}