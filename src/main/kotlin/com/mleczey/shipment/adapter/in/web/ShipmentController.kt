package com.mleczey.shipment.adapter.`in`.web

import com.mleczey.shipment.core.port.`in`.*
import com.mleczey.shipment.domain.value.ShipmentId
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest

@RestController
class ShipmentController(
  private val createShipmentUseCase: CreateShipmentUseCase, private val findShipmentUseCase: FindShipmentUseCase
) {

  @PostMapping("/shipments")
  fun createShipment(@RequestBody request: CreateShipmentRequest): ResponseEntity<Unit> {
    val id = createShipmentUseCase.createShipment(
      CreateShipmentCommand(request.symbol, request.items.map { CreateShipmentItemCommand(it.name, it.quantity) })
    )

    val uri = fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(id.value)
      .toUri();

    return created(uri).build()
  }

  @GetMapping("/shipments/{id}")
  fun findShipment(@PathVariable("id") id: String): ResponseEntity<FindShipmentResponse> {
    val shipment = findShipmentUseCase.findShipment(FindShipmentQuery(ShipmentId.from(id)))
    return if (null == shipment) {
      notFound().build()
    } else {
      ok(
        FindShipmentResponse(
          shipment.id.toString(),
          shipment.symbol,
          shipment.items.map { FindShipmentItemResponse(it.name, it.quantity) })
      )
    }
  }

}