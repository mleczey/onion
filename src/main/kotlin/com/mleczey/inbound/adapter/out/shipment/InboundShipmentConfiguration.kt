package com.mleczey.inbound.adapter.out.shipment

import com.mleczey.inbound.core.port.out.CargoDataAccess
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InboundShipmentConfiguration {

  @Bean
  fun cargoDataAccess(bridge: ShipmentInboundBridge): CargoDataAccess = CargoAdapter(bridge)
}