package io.quee.api.develop.shared.error

import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
open class SharedException(val errors: List<Error> = ArrayList()) : RuntimeException() {
    override val message: String
        get() = errors.toString()

    open class Builder internal constructor() {
        private val errors: MutableList<Error> = ArrayList()
        fun with(code: String, message: String): Builder {
            return with(Error(code, message))
        }

        fun with(error: Error): Builder {
            errors.add(error)
            return this
        }

        fun throwMeIfNotEmpty() {
            if (errors.isNotEmpty()) throw SharedException(errors)
        }

        @Throws(SharedException::class)
        fun throwMe() {
            throw SharedException(errors)
        }

        fun build(): SharedException {
            return SharedException(errors)
        }

        companion object {
            fun get(): Builder {
                return Builder()
            }
        }
    }

    companion object {
        fun builder(): Builder {
            return Builder()
        }
    }
}