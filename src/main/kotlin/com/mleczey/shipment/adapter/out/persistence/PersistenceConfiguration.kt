package com.mleczey.shipment.adapter.out.persistence

import com.mleczey.shipment.core.port.out.ShipmentDataAccess
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersistenceConfiguration {
  @Bean
  fun shipmentDataAccess(shipmentRepository: ShipmentRepository): ShipmentDataAccess = ShipmentDataAccessAdapter(shipmentRepository)
}