package com.mleczey.inbound.core.port.out

import com.mleczey.inbound.domain.Acceptance
import com.mleczey.inbound.domain.value.ItemName

interface AcceptanceDataAccess {
  fun findByItemName(itemName: ItemName): Collection<Acceptance>
  fun save(acceptance: Acceptance)
}
