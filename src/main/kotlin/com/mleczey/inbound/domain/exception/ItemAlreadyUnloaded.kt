package com.mleczey.inbound.domain.exception

import com.mleczey.inbound.domain.value.ItemName
import com.mleczey.inbound.domain.value.ShipmentId
import com.mleczey.infrastracture.exception.OnionException

class ItemAlreadyUnloaded(private val shipmentId: ShipmentId, private val itemName: ItemName) :
  OnionException("""Item $itemName from shipment $shipmentId was already unloaded.""")