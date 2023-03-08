package com.mleczey.shipment.adapter.out.persistence

import com.mleczey.shipment.core.port.out.ShipmentDataAccess
import com.mleczey.shipment.domain.Item
import com.mleczey.shipment.domain.Shipment
import com.mleczey.shipment.domain.value.ShipmentId

class ShipmentDataAccessAdapter(
  private val repository: ShipmentRepository
) : ShipmentDataAccess {
  override fun findById(id: ShipmentId): Shipment? {
    val entity = repository.findByUuid(id.toString())
    return if (null == entity) null else Shipment(ShipmentId.from(entity.uuid), entity.symbol, entity.items.map { Item(it.name, it.quantity) })
  }

  override fun save(shipment: Shipment): ShipmentId {
    val entity = ShipmentEntity(null, shipment.id.toString(), shipment.symbol, shipment.items.map { ItemEntity(it.name, it.quantity) })
    repository.save(entity)
    return shipment.id
  }
}