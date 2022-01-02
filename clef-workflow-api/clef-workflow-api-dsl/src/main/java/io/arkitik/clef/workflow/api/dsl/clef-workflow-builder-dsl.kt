package io.arkitik.clef.workflow.api.dsl


/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 22 10:15 PM, **Wed, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class ClefWorkflowsBuilder {
    private val workflows = mutableListOf<WorkflowData>()

    fun workflow(
        workflowDataBuilder: WorkflowDataBuilder.() -> Unit,
    ): ClefWorkflowsBuilder {
        workflows.add(WorkflowDataBuilder().apply(workflowDataBuilder).build())
        return this
    }

    fun build(): List<WorkflowData> = workflows
}

class WorkflowDataBuilder {
    private lateinit var name: String
    private lateinit var key: String
    private lateinit var description: String
    private var initialStage: WorkflowStageData? = null
    private val stages: MutableList<WorkflowStageData> = ArrayList()


    infix fun name(name: String): WorkflowDataBuilder {
        this.name = name
        return this
    }

    infix fun key(key: String): WorkflowDataBuilder {
        this.key = key
        return this
    }

    infix fun description(description: String): WorkflowDataBuilder {
        this.description = description
        return this
    }

    infix fun initialStage(builder: WorkflowStageDataBuilder.() -> Unit): WorkflowDataBuilder {
        this.initialStage = WorkflowStageDataBuilder().apply(builder).build()
        return this
    }

    infix fun stage(builder: WorkflowStageDataBuilder.() -> Unit): WorkflowDataBuilder {
        this.stages.add(WorkflowStageDataBuilder().apply(builder).build())
        return this
    }

    fun build(): WorkflowData {
        return WorkflowData(name = name,
            key = key,
            description = description,
            initialStage = initialStage,
            stages = stages)
    }
}

data class WorkflowData(
    val name: String,
    val key: String,
    val description: String,
    val initialStage: WorkflowStageData? = null,
    val stages: MutableList<WorkflowStageData> = ArrayList(),
)

class WorkflowStageDataBuilder {
    private lateinit var key: String
    private lateinit var name: String
    private var initialTask: StageTaskData? = null
    private var tasks: MutableList<StageTaskData> = ArrayList()

    infix fun stageKey(stageKey: String): WorkflowStageDataBuilder {
        key = stageKey
        return this
    }

    infix fun stageName(stageName: String): WorkflowStageDataBuilder {
        name = stageName
        return this
    }

    infix fun stageInitialTask(builder: StageTaskDataBuilder.() -> Unit): WorkflowStageDataBuilder {
        initialTask = StageTaskDataBuilder().apply(builder).build()
        return this
    }

    infix fun stageTask(builder: StageTaskDataBuilder.() -> Unit): WorkflowStageDataBuilder {
        tasks.add(StageTaskDataBuilder().apply(builder).build())
        return this
    }

    fun build() = WorkflowStageData(
        key = key,
        name = name,
        initialTask = initialTask,
        tasks = tasks,
    )
}

data class WorkflowStageData(
    val key: String,
    val name: String,
    val initialTask: StageTaskData? = null,
    val tasks: MutableList<StageTaskData> = ArrayList(),
)

class StageTaskDataBuilder {
    private lateinit var key: String
    private lateinit var name: String
    private val actions = mutableListOf<TaskActionData>()

    fun taskKey(key: String): StageTaskDataBuilder {
        this.key = key
        return this
    }

    fun taskName(name: String): StageTaskDataBuilder {
        this.name = name
        return this
    }

    fun taskAction(builder: TaskActionDataBuilder.() -> Unit): StageTaskDataBuilder {
        this.actions.add(TaskActionDataBuilder().apply(builder).build())
        return this
    }

    fun build() = StageTaskData(key = key, name = name, actions = actions)
}

data class StageTaskData(
    val key: String,
    val name: String,
    val actions: MutableList<TaskActionData> = java.util.ArrayList(),
)


class TaskActionDataBuilder {
    private lateinit var key: String
    private lateinit var name: String
    private lateinit var description: String
    private lateinit var destinationTask: String
    private val parameters = mutableListOf<Pair<String, String>>()

    fun actionKey(key: String): TaskActionDataBuilder {
        this.key = key
        return this
    }

    fun actionName(name: String): TaskActionDataBuilder {
        this.name = name
        return this
    }


    fun actionDescription(description: String): TaskActionDataBuilder {
        this.description = description
        return this
    }

    fun actionDestinationTask(destinationTask: String): TaskActionDataBuilder {
        this.destinationTask = destinationTask
        return this
    }

    fun actionParam(param: Pair<String, String>): TaskActionDataBuilder {
        this.parameters.add(param)
        return this
    }

    fun build() = TaskActionData(key = key,
        name = name,
        description = description,
        destinationTask = destinationTask,
        parameters = parameters)
}

data class TaskActionData(
    val key: String,
    val name: String,
    val description: String,
    val destinationTask: String,
    val parameters: MutableList<Pair<String, String>> = java.util.ArrayList(),
)
