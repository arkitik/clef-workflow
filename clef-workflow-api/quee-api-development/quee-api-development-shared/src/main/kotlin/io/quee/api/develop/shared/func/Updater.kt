package io.quee.api.develop.shared.func

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Thu Oct, 2019**
 */
@FunctionalInterface
interface Updater<T> {
    fun update(): T
}