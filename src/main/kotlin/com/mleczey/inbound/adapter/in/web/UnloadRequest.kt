package com.mleczey.inbound.adapter.`in`.web

data class UnloadRequest(val shipmentId: String, val itemName: String, val quantity: Int)
