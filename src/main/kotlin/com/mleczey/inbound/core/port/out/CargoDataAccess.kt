package com.mleczey.inbound.core.port.out

import com.mleczey.inbound.domain.Cargo
import com.mleczey.inbound.domain.value.ItemName
import com.mleczey.inbound.domain.value.ShipmentId

interface CargoDataAccess {
  fun findShipment(id: ShipmentId, itemName: ItemName): Cargo?
}
