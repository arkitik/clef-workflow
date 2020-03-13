package io.quee.api.develop.shared.exception

import io.quee.api.develop.shared.error.Error

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Mon Oct, 2019**
 */
abstract class BaseException(val error: Error) : RuntimeException() {
    override val message: String?
        get() = toString()

    override fun toString(): String {
        return "BaseException{" +
                "error=" + error +
                '}'
    }

}