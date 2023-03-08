package com.mleczey.shipment.adapter.`in`.web

data class FindShipmentResponse(val id: String, val symbol: String, val items: Collection<FindShipmentItemResponse>)
data class FindShipmentItemResponse(val name: String, val quantity: Int)
