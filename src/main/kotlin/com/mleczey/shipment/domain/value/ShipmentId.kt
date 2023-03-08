package com.mleczey.shipment.domain.value

import java.util.UUID

@JvmInline
value class ShipmentId(val value: UUID) {

  override fun toString(): String = value.toString()

  companion object {
    fun create(): ShipmentId = ShipmentId(UUID.randomUUID())
    fun from(s: String): ShipmentId = ShipmentId(UUID.fromString(s))
  }
}
