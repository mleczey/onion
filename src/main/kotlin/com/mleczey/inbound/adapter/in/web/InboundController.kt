package com.mleczey.inbound.adapter.`in`.web

import com.mleczey.inbound.core.port.`in`.UnloadItemCommand
import com.mleczey.inbound.core.port.`in`.UnloadItemUseCase
import com.mleczey.inbound.domain.value.ItemName
import com.mleczey.inbound.domain.value.ShipmentId
import com.mleczey.infrastracture.value.CommandId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InboundController(
  private val unloadItemUseCase: UnloadItemUseCase
) {

  @PutMapping("/inbounds/unload-item-commands/{uuid}")
  fun unloadItem(@PathVariable commandId: String, @RequestBody request: UnloadRequest): ResponseEntity<Unit> {
    unloadItemUseCase.unloadItem(
      UnloadItemCommand(
        CommandId.from(commandId),
        ShipmentId.from(request.shipmentId),
        ItemName(request.itemName),
        request.quantity
      )
    )
    return ResponseEntity.accepted().build()
  }
}