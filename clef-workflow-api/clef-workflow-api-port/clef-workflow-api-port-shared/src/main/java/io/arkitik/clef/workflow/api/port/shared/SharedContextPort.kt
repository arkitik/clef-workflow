package io.arkitik.clef.workflow.api.port.shared

import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Configuration
class SharedContextPort {
    @Bean
    fun identityAccessValidation(): IdentityAccessValidation = IdentityAccessValidation()

    @Bean
    fun identityStatusValidation(): IdentityStatusValidation = IdentityStatusValidation()
}