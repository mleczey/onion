package com.mleczey.inbound.domain

import com.mleczey.inbound.domain.value.ItemName
import com.mleczey.inbound.domain.value.ShipmentId

class Cargo(val id: ShipmentId, val itemName: ItemName, val quantity: Int)