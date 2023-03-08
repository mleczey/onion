package com.mleczey.shipment.adapter.out.persistence

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface ShipmentRepository : MongoRepository<ShipmentEntity, Long> {
  @Query("{uuid:'?0'}")
  fun findByUuid(uuid: String): ShipmentEntity?
}