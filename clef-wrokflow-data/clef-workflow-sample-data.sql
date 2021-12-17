create table `clef-workflow`.stage_task
(
    uuid            varchar(255) not null
        primary key,
    creation_date   datetime(6)  not null,
    identity_status varchar(255) not null,
    task_key        varchar(255) not null,
    task_name       varchar(255) not null
);

create table `clef-workflow`.task_action
(
    uuid                  varchar(255) not null
        primary key,
    action_description    varchar(255) not null,
    action_key            varchar(255) not null,
    action_name           varchar(255) not null,
    creation_date         datetime(6)  not null,
    identity_status       varchar(255) not null,
    destination_task_uuid varchar(255) null,
    constraint FK6mrhwxeb3irgs80bgh0cf11x6
        foreign key (destination_task_uuid) references `clef-workflow`.stage_task (uuid)
);

create table `clef-workflow`.action_parameters
(
    task_action_uuid varchar(255) not null,
    parameter_key    varchar(255) not null,
    parameter_value  varchar(255) not null,
    constraint FK5ov4niv69fh7519a4161cjoqx
        foreign key (task_action_uuid) references `clef-workflow`.task_action (uuid)
);

create table `clef-workflow`.stage_task_actions
(
    stage_task_uuid varchar(255) not null,
    actions_uuid    varchar(255) not null,
    constraint UK_ixhf4w5j1uc4a08ni1t6t0xsc
        unique (actions_uuid),
    constraint FK2kja3wm52ej11fh2jic67cly5
        foreign key (actions_uuid) references `clef-workflow`.task_action (uuid),
    constraint FKdhnax7o3tl4hvmdgkfjffhxmi
        foreign key (stage_task_uuid) references `clef-workflow`.stage_task (uuid)
);

create table `clef-workflow`.workflow_stage
(
    uuid              varchar(255) not null
        primary key,
    creation_date     datetime(6)  not null,
    identity_status   varchar(255) not null,
    stage_key         varchar(255) not null,
    stage_name        varchar(255) not null,
    initial_task_uuid varchar(255) null,
    constraint FK7dhwa1j0byf5wiggk37dpshsy
        foreign key (initial_task_uuid) references `clef-workflow`.stage_task (uuid)
);

create table `clef-workflow`.workflow
(
    uuid                 varchar(255) not null
        primary key,
    creation_date        datetime(6)  not null,
    identity_status      varchar(255) not null,
    workflow_description varchar(255) not null,
    workflow_key         varchar(255) not null,
    workflow_name        varchar(255) not null,
    initial_stage_uuid   varchar(255) null,
    constraint FKgexdg2hmac88ptlxaj871y4b3
        foreign key (initial_stage_uuid) references `clef-workflow`.workflow_stage (uuid)
);

create table `clef-workflow`.element
(
    uuid               varchar(255) not null
        primary key,
    creation_date      datetime(6)  not null,
    element_key        varchar(255) not null,
    identity_status    varchar(255) not null,
    current_stage_uuid varchar(255) not null,
    current_task_uuid  varchar(255) not null,
    workflow_uuid      varchar(255) not null,
    constraint FK136wajjw249fco5uva8brf6c
        foreign key (current_stage_uuid) references `clef-workflow`.workflow_stage (uuid),
    constraint FK1646v1r8yq8r14j2d95jxv2ht
        foreign key (workflow_uuid) references `clef-workflow`.workflow (uuid),
    constraint FKdf09k4194nbvx8y1wt846hxyh
        foreign key (current_task_uuid) references `clef-workflow`.stage_task (uuid)
);

create table `clef-workflow`.element_flow
(
    uuid               varchar(255) not null
        primary key,
    creation_date      datetime(6)  not null,
    identity_status    varchar(255) not null,
    action_uuid        varchar(255) not null,
    from_stage_uuid    varchar(255) not null,
    from_task_uuid     varchar(255) not null,
    from_workflow_uuid varchar(255) not null,
    to_stage_uuid      varchar(255) not null,
    to_task_uuid       varchar(255) not null,
    to_workflow_uuid   varchar(255) not null,
    constraint FK20x7vj7k4nw6s5w6dgdb1ad3n
        foreign key (action_uuid) references `clef-workflow`.task_action (uuid),
    constraint FKeasv25ymhdtu7q69srk3iu8ko
        foreign key (from_stage_uuid) references `clef-workflow`.workflow_stage (uuid),
    constraint FKkcykf6rndt3jhpm41j7j83629
        foreign key (to_stage_uuid) references `clef-workflow`.workflow_stage (uuid),
    constraint FKqjfoi1j89g4osergxdd81yv4v
        foreign key (from_workflow_uuid) references `clef-workflow`.workflow (uuid),
    constraint FKqq1s0ll2us4yu94jkc7155tta
        foreign key (from_task_uuid) references `clef-workflow`.stage_task (uuid),
    constraint FKrm78t4rnthj892q24q51ec0sl
        foreign key (to_task_uuid) references `clef-workflow`.stage_task (uuid),
    constraint FKt49rbwwqa1javf4346ovr1c0r
        foreign key (to_workflow_uuid) references `clef-workflow`.workflow (uuid)
);

create table `clef-workflow`.element_flows
(
    element_uuid varchar(255) not null,
    flows_uuid   varchar(255) not null,
    constraint UK_7a04k2o27rd731adc2ybmjcd4
        unique (flows_uuid),
    constraint FKbplmtf0g86i7p4a5rnxpuo55s
        foreign key (element_uuid) references `clef-workflow`.element (uuid),
    constraint FKey0pq6j6iy57b7uf53jhdxlkc
        foreign key (flows_uuid) references `clef-workflow`.element_flow (uuid)
);

create table `clef-workflow`.workflow_stage_tasks
(
    workflow_stage_uuid varchar(255) not null,
    tasks_uuid          varchar(255) not null,
    constraint UK_lupflpuxed72m7lxmsdv2i7wg
        unique (tasks_uuid),
    constraint FKjehhtj2qi7t9nfvjtgea3j29m
        foreign key (workflow_stage_uuid) references `clef-workflow`.workflow_stage (uuid),
    constraint FKtjwotqq3mppdempgsekwce372
        foreign key (tasks_uuid) references `clef-workflow`.stage_task (uuid)
);

create table `clef-workflow`.workflow_stages
(
    workflow_uuid varchar(255) not null,
    stages_uuid   varchar(255) not null,
    constraint UK_ojc1ujghf5k4jrdb0dg3kx1jf
        unique (stages_uuid),
    constraint FK9vfirasqd9aaxymvn9fyhsik4
        foreign key (stages_uuid) references `clef-workflow`.workflow_stage (uuid),
    constraint FKdrg6x2x6jmtq3giaeywbbs1x4
        foreign key (workflow_uuid) references `clef-workflow`.workflow (uuid)
);

