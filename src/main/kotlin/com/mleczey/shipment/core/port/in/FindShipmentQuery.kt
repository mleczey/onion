package com.mleczey.shipment.core.port.`in`

import com.mleczey.shipment.domain.value.ShipmentId

// TODO: add validation
data class FindShipmentQuery(val id: ShipmentId)
