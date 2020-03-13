package io.quee.api.develop.shared.exception

import io.quee.api.develop.shared.error.Error

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Oct, 2019**
 */
class InternalException(error: Error) : BaseException(error)