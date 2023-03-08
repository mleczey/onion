package com.mleczey.shipment.core.port.`in`

import com.mleczey.shipment.domain.Shipment

interface FindShipmentUseCase {
  fun findShipment(query: FindShipmentQuery): Shipment?
}