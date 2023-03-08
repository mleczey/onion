package com.mleczey.shipment.core.port.`in`

import com.mleczey.shipment.domain.value.ShipmentId

interface CreateShipmentUseCase {
  fun createShipment(command: CreateShipmentCommand): ShipmentId
}
