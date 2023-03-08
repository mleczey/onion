package com.mleczey.inbound.core.port.`in`

interface UnloadItemUseCase {
  fun unloadItem(command: UnloadItemCommand)
}
