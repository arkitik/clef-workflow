package io.quee.api.develop.shared

import io.quee.api.develop.shared.model.TranslatedValue

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Tue Sep, 2019**
 */
enum class SupportedLanguage {
    AR, EN;

    fun translate(value: TranslatedValue): String {
        return if (this == AR) value.arabicValue else value.englishValue
    }
}