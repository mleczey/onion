package com.mleczey.shipment.core.port.`in`

// TODO: add validation
data class CreateShipmentCommand(val symbol: String, val items: Collection<CreateShipmentItemCommand>)
data class CreateShipmentItemCommand(val name: String, val quantity: Int)
