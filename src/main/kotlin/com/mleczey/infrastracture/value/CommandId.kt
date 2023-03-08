package com.mleczey.infrastracture.value

import java.util.UUID

@JvmInline
value class CommandId(val value: UUID) {
  companion object {
    fun from(s: String): CommandId = CommandId(UUID.fromString(s))
  }
}