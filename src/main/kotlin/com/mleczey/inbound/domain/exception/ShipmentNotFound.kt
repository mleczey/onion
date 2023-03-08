package com.mleczey.inbound.domain.exception

import com.mleczey.inbound.domain.value.ShipmentId
import com.mleczey.infrastracture.exception.OnionException

class ShipmentNotFound(private val shipmentId: ShipmentId) : OnionException("""Shipment $shipmentId not found.""")