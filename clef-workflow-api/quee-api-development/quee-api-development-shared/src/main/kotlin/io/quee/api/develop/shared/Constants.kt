package io.quee.api.develop.shared

import java.time.format.DateTimeFormatter

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
open class Constants {
    companion object {
        //language=RegExp
        const val PASSWORD_REGEX: String = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,}$"

        //language=RegExp
        const val USER_NAME_REGEX: String = "[a-zA-Z0-9]+([_-]?[a-zA-Z0-9]){4,}$"

        //language=RegExp
        const val URL_REGEX: String = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"
        const val DATE_FORMAT: String = "yyyy-MM-dd"
        const val TIME_FORMAT: String = "HH:mm:ss"
        val DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT)
        val TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT)
    }
}