package com.mleczey.inbound.core.port.`in`

import com.mleczey.inbound.domain.value.ItemName
import com.mleczey.inbound.domain.value.ShipmentId
import com.mleczey.infrastracture.value.CommandId

// TODO: add validation
data class UnloadItemCommand(val commandId: CommandId, val shipmentId: ShipmentId, val itemName: ItemName, val quantity: Int)
