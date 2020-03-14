package io.quee.api.develop.shared

import io.quee.api.develop.shared.error.Error

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Wed Aug, 2019**
 */
object MainErrors {
    val UNKNOWN_ERROR: Error = Error("QUEE-API-0000", "Unknown Error")
    val ENTITY_NOT_EXIST_ERROR: Error = Error("QUEE-API-0100", "Entity not exist")
    val DUPLICATE_ENTRY_ERROR: Error = Error("QUEE-API-0200", "Duplicate entry")
    val LANGUAGE_DOES_NOT_SUPPORTED: Error = Error("QUEE-API-0300", "Language does not support")

    object SharedApi {
        val INVALID_DATE_FORMAT: Error = Error("QUEE-API-SHRD-1000", "Invalid date format")
    }
}