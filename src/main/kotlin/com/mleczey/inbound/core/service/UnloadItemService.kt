package com.mleczey.inbound.core.service

import com.mleczey.inbound.core.port.`in`.UnloadItemCommand
import com.mleczey.inbound.core.port.`in`.UnloadItemUseCase
import com.mleczey.inbound.core.port.out.CargoDataAccess
import com.mleczey.inbound.domain.Acceptance
import com.mleczey.inbound.domain.exception.ItemAlreadyUnloaded
import com.mleczey.inbound.domain.exception.ShipmentNotFound
import com.mleczey.inbound.core.port.out.AcceptanceDataAccess

class UnloadItemService(
  private val acceptanceDataAccess: AcceptanceDataAccess,
  private val cargoDataAccess: CargoDataAccess
) : UnloadItemUseCase {
  override fun unloadItem(command: UnloadItemCommand) {
    // TODO: check if command was already processed using commandId
    val shipment = cargoDataAccess.findShipment(command.shipmentId, command.itemName)
    if (null == shipment) {
      throw ShipmentNotFound(command.shipmentId)
    } else {
      val acceptances = acceptanceDataAccess.findByItemName(command.itemName)
      val unloadedQuantity = acceptances.fold(0) { result, acceptance ->
        result + acceptance.unloadedQuantity
      }

      if (unloadedQuantity >= shipment.quantity) {
        throw ItemAlreadyUnloaded(command.shipmentId, command.itemName)
      }

      acceptanceDataAccess.save(Acceptance(command.itemName, command.quantity))
    }
  }
}