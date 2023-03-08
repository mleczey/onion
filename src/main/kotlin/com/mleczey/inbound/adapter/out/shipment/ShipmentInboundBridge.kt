package com.mleczey.inbound.adapter.out.shipment

interface ShipmentInboundBridge {
  fun findShipmentByShipmentIdAndItemName(shipmentId: String, itemName: String): ShipmentView?
}