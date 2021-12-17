package io.quee.clef.workflow.api.port.shared

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy
import org.hibernate.boot.model.naming.Identifier
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 2:35 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class ClefWorkflowNamingStrategy : CamelCaseToUnderscoresNamingStrategy() {
    override fun getIdentifier(name: String, quoted: Boolean, jdbcEnvironment: JdbcEnvironment?): Identifier {
        return super.getIdentifier("CLEFWF_$name", quoted, jdbcEnvironment)
    }
}