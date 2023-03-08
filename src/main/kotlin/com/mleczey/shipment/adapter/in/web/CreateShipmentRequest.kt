package com.mleczey.shipment.adapter.`in`.web

data class CreateShipmentRequest(val symbol: String, val items: Collection<CreateShipmentItemRequest>)
data class CreateShipmentItemRequest(val name: String, val quantity: Int)
