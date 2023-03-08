package com.mleczey.shipment.adapter.`in`.inbound

import com.mleczey.inbound.adapter.out.shipment.ShipmentInboundBridge
import com.mleczey.shipment.core.port.`in`.FindShipmentUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ShipmentInboundConfiguration {
  @Bean
  fun shipmentInboundBridge(findShipmentUseCase: FindShipmentUseCase): ShipmentInboundBridge = InboundBridge(findShipmentUseCase)
}