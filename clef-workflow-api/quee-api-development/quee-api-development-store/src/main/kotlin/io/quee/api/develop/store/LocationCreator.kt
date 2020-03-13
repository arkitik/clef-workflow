package io.quee.api.develop.store

import io.quee.api.develop.shared.func.Creator
import io.quee.api.develop.shared.model.Location

interface LocationCreator : Creator<Location> {
    fun Double.longitude(): LocationCreator
    fun Double.latitude(): LocationCreator
}