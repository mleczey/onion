package com.mleczey.inbound.domain.value

import java.util.UUID

@JvmInline
value class ShipmentId(val value: UUID) {
  companion object {
    fun from(s: String): ShipmentId = ShipmentId(UUID.fromString(s))
  }
}