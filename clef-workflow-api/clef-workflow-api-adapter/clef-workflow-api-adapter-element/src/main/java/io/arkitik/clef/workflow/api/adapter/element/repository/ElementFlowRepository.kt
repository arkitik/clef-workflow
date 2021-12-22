package io.arkitik.clef.workflow.api.adapter.element.repository

import io.arkitik.radix.adapter.shared.repository.RadixRepository
import io.arkitik.clef.workflow.api.entity.element.ElementFlow
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Repository
interface ElementFlowRepository : RadixRepository<String, ElementFlow>