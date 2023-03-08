package com.mleczey.inbound.domain

import com.mleczey.inbound.domain.value.ItemName

data class Acceptance(val itemName: ItemName, val unloadedQuantity: Int)