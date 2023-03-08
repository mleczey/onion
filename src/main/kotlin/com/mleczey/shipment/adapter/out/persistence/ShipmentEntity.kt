package com.mleczey.shipment.adapter.out.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("shipments")
class ShipmentEntity(
  @Id
  val id: String? = null,
  val uuid: String,
  val symbol: String,
  val items: Collection<ItemEntity>
)
