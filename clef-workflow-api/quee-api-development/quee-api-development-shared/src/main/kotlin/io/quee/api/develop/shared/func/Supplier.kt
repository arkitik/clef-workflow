package io.quee.api.develop.shared.func

import java.util.function.Supplier as JavaSupplier

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
@FunctionalInterface
interface Supplier<T> : JavaSupplier<T> {
    override fun get(): T
}