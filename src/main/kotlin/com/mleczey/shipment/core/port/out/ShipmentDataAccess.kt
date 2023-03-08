package com.mleczey.shipment.core.port.out

import com.mleczey.shipment.domain.Shipment
import com.mleczey.shipment.domain.value.ShipmentId

interface ShipmentDataAccess {
  fun findById(id: ShipmentId): Shipment?
  fun save(shipment: Shipment): ShipmentId
}
