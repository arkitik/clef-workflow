package io.quee.api.develop.shared

import io.quee.api.develop.shared.error.Error

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Wed Aug, 2019**
 */
object MainErrors {
    val UNKNOWN_ERROR: Error = Error("PZR-STORE-0000", "Unknown Error")
    val ENTITY_NOT_EXIST_ERROR: Error = Error("PZR-STORE-0100", "Entity not exist")
    val LANGUAGE_DOES_NOT_SUPPORTED: Error = Error("PZR-STORE-0200", "Language does not supported")

    object SharedApi {
        val INVALID_DATE_FORMAT: Error = Error("PZR-STORE-SHRD-1000", "Invalid date format")
    }

    object AuthorizationApi {
        val AUTHORIZATION_FAILED: Error = Error("PZR-STORE-AUTH-1000", "Authorization failed")
        val INVALID_CREDENTIAL: Error = Error("PZR-STORE-AUTH-1100", "Invalid User Credential")
        val INVALID_ACCESS_TOKEN: Error = Error("PZR-STORE-AUTH-1200", "Invalid access token")
        val USER_NAME_EXIST: Error = Error("PZR-STORE-AUTH-1300", "User name already exists")
        val EMAIL_EXIST: Error = Error("PZR-STORE-AUTH-1400", "Email address already exits")
        val INVALID_OLD_PASSWORD: Error = Error("PZR-STORE-AUTH-1500", "Invalid password")
    }
}