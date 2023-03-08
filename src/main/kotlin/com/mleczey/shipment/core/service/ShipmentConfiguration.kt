package com.mleczey.shipment.core.service

import com.mleczey.shipment.core.port.`in`.CreateShipmentUseCase
import com.mleczey.shipment.core.port.`in`.FindShipmentUseCase
import com.mleczey.shipment.core.port.out.ShipmentDataAccess
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ShipmentConfiguration {
  @Bean
  fun createShipmentUseCase(shipmentDataAccess: ShipmentDataAccess): CreateShipmentUseCase = CreateShipmentService(shipmentDataAccess)

  @Bean
  fun findShipmentUseCase(shipmentDataAccess: ShipmentDataAccess): FindShipmentUseCase = FindShipmentService(shipmentDataAccess)
}