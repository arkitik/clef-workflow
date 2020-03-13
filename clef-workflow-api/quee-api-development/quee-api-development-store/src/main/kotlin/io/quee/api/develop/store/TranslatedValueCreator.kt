package io.quee.api.develop.store

import io.quee.api.develop.shared.func.Creator
import io.quee.api.develop.shared.model.TranslatedValue

interface TranslatedValueCreator : Creator<TranslatedValue> {
    fun String.nameAr(): TranslatedValueCreator
    fun String.nameEn(): TranslatedValueCreator
}