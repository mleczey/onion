package com.mleczey.shipment.core.service

import com.mleczey.shipment.core.port.`in`.FindShipmentQuery
import com.mleczey.shipment.core.port.`in`.FindShipmentUseCase
import com.mleczey.shipment.core.port.out.ShipmentDataAccess
import com.mleczey.shipment.domain.Shipment

class FindShipmentService(
  private val shipmentDataAccess: ShipmentDataAccess
) : FindShipmentUseCase {
  override fun findShipment(query: FindShipmentQuery): Shipment? {
    return shipmentDataAccess.findById(query.id)
  }
}