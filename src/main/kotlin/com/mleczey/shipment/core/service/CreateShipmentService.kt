package com.mleczey.shipment.core.service

import com.mleczey.shipment.core.port.`in`.CreateShipmentCommand
import com.mleczey.shipment.core.port.`in`.CreateShipmentUseCase
import com.mleczey.shipment.core.port.out.ShipmentDataAccess
import com.mleczey.shipment.domain.Item
import com.mleczey.shipment.domain.Shipment
import com.mleczey.shipment.domain.value.ShipmentId

class CreateShipmentService(
  private val shipmentDataAccess: ShipmentDataAccess
) : CreateShipmentUseCase {
  override fun createShipment(command: CreateShipmentCommand): ShipmentId {
    val shipment = Shipment(ShipmentId.create(), command.symbol, command.items.map { Item(it.name, it.quantity) })
    return shipmentDataAccess.save(shipment)
  }
}