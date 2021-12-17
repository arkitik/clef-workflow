SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `clef-workflow`.element (uuid, creation_date, element_key, identity_status, current_stage_uuid,
                                     current_task_uuid, workflow_uuid)
VALUES ('4fc6bedf-08f2-42e7-a27e-b220f6b1f623', '2020-03-21 14:11:38.360938000', 'sample-element', 'ENABLED',
        '2abf7aa6-e63c-45bf-b83d-72635ec38723', '3adc61da-f8ce-4f72-8f49-2df3ec61f7b7',
        '2448528c-b4c5-4698-936e-c3f6b1341152');
INSERT INTO `clef-workflow`.element_flow (uuid, creation_date, identity_status, action_uuid, from_stage_uuid,
                                          from_task_uuid, from_workflow_uuid, to_stage_uuid, to_task_uuid,
                                          to_workflow_uuid)
VALUES ('fb13383d-47b4-41e8-b2e4-1fe931b895eb', '2020-03-27 13:53:28.818955000', 'ENABLED',
        'f52f5a96-8982-4c92-92e0-7b1334d94519', '0cc7d3cb-377c-4fbf-818e-fea371da0389',
        '25aa90cc-89ba-4368-9635-27098324e85e', '2448528c-b4c5-4698-936e-c3f6b1341152',
        '2abf7aa6-e63c-45bf-b83d-72635ec38723', '3adc61da-f8ce-4f72-8f49-2df3ec61f7b7',
        '2448528c-b4c5-4698-936e-c3f6b1341152');
INSERT INTO `clef-workflow`.element_flows (element_uuid, flows_uuid)
VALUES ('4fc6bedf-08f2-42e7-a27e-b220f6b1f623', 'fb13383d-47b4-41e8-b2e4-1fe931b895eb');
INSERT INTO `clef-workflow`.stage_task (uuid, creation_date, identity_status, task_key, task_name)
VALUES ('25aa90cc-89ba-4368-9635-27098324e85e', '2020-03-21 11:56:42.028000000', 'ENABLED', 'start-task', 'start Task');
INSERT INTO `clef-workflow`.stage_task (uuid, creation_date, identity_status, task_key, task_name)
VALUES ('39324df5-a0a4-4b9a-b9fb-bf8b38e8f827', '2020-03-21 11:58:47.986000000', 'ENABLED', 'forth-task', 'forth Task');
INSERT INTO `clef-workflow`.stage_task (uuid, creation_date, identity_status, task_key, task_name)
VALUES ('3adc61da-f8ce-4f72-8f49-2df3ec61f7b7', '2020-03-21 11:57:42.325000000', 'ENABLED', 'second-task',
        'second Task');
INSERT INTO `clef-workflow`.stage_task (uuid, creation_date, identity_status, task_key, task_name)
VALUES ('66f765e4-45b9-42ab-ac4d-b928fe029204', '2020-03-21 11:55:24.506000000', 'ENABLED', 'init-task',
        'Initial Task');
INSERT INTO `clef-workflow`.stage_task (uuid, creation_date, identity_status, task_key, task_name)
VALUES ('e5786912-0942-4953-bb28-0b6ffd3ac382', '2020-03-21 13:03:57.930000000', 'ENABLED', 'w2-s2-t1-task', 'Task 1');
INSERT INTO `clef-workflow`.stage_task (uuid, creation_date, identity_status, task_key, task_name)
VALUES ('e965bb99-0c90-4d44-96cf-0ca053e69c8a', '2020-03-21 11:58:01.482000000', 'ENABLED', 'third-task', 'third Task');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('25aa90cc-89ba-4368-9635-27098324e85e', 'f52f5a96-8982-4c92-92e0-7b1334d94519');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('39324df5-a0a4-4b9a-b9fb-bf8b38e8f827', '8b8922fa-7190-4fe8-802f-95d75155bf43');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('3adc61da-f8ce-4f72-8f49-2df3ec61f7b7', '1490c278-acc9-4d01-9d95-6275b49e0449');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('3adc61da-f8ce-4f72-8f49-2df3ec61f7b7', 'ea6b8da8-9bc5-4ae8-b8f6-55df254b4214');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('66f765e4-45b9-42ab-ac4d-b928fe029204', 'd3ad6156-611a-49b2-bdcd-0a827e52f93b');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('e5786912-0942-4953-bb28-0b6ffd3ac382', 'eae95e4d-7a8c-4e04-bd1e-071dd2cc0be4');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('e965bb99-0c90-4d44-96cf-0ca053e69c8a', 'f94f9fbe-dd12-45db-b8e6-f39d59f3f9a8');
INSERT INTO `clef-workflow`.stage_task_actions (stage_task_uuid, actions_uuid)
VALUES ('e965bb99-0c90-4d44-96cf-0ca053e69c8a', 'fbdcf253-32f4-4ba7-8bd1-e9d9b31bc01b');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('1490c278-acc9-4d01-9d95-6275b49e0449', 'Return to start task', 'back-start-task', 'back To start Task',
        '2020-03-21 12:38:50.094000000', 'ENABLED', '25aa90cc-89ba-4368-9635-27098324e85e');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('8b8922fa-7190-4fe8-802f-95d75155bf43', 'Secondary Stage', 'w2-t2-a2-action', 'To forth stage',
        '2020-03-21 13:05:58.303000000', 'ENABLED', 'e5786912-0942-4953-bb28-0b6ffd3ac382');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('d3ad6156-611a-49b2-bdcd-0a827e52f93b', 'Move to start task', 'to-start-task', 'To Start Task',
        '2020-03-21 12:36:30.163000000', 'ENABLED', '25aa90cc-89ba-4368-9635-27098324e85e');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('ea6b8da8-9bc5-4ae8-b8f6-55df254b4214', 'Goto third task', 'to-third-task', 'To third Task',
        '2020-03-21 12:44:03.667000000', 'ENABLED', 'e965bb99-0c90-4d44-96cf-0ca053e69c8a');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('eae95e4d-7a8c-4e04-bd1e-071dd2cc0be4', 'Secondary Stage', 'w2-w1-t2-a2-action', 'To forth stage',
        '2020-03-21 14:02:18.520348000', 'ENABLED', '25aa90cc-89ba-4368-9635-27098324e85e');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('f52f5a96-8982-4c92-92e0-7b1334d94519', 'Move to second task', 'to-second-task', 'To second Task',
        '2020-03-21 12:37:38.902000000', 'ENABLED', '3adc61da-f8ce-4f72-8f49-2df3ec61f7b7');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('f94f9fbe-dd12-45db-b8e6-f39d59f3f9a8', 'Goto forth task', 'to-forth-task', 'To forth Task',
        '2020-03-21 12:45:20.238000000', 'ENABLED', '39324df5-a0a4-4b9a-b9fb-bf8b38e8f827');
INSERT INTO `clef-workflow`.task_action (uuid, action_description, action_key, action_name, creation_date,
                                         identity_status, destination_task_uuid)
VALUES ('fbdcf253-32f4-4ba7-8bd1-e9d9b31bc01b', 'Return to second task', 'back-second-task', 'back To second Task',
        '2020-03-21 12:39:46.906000000', 'ENABLED', '3adc61da-f8ce-4f72-8f49-2df3ec61f7b7');
INSERT INTO `clef-workflow`.workflow (uuid, creation_date, identity_status, workflow_description, workflow_key,
                                      workflow_name, initial_stage_uuid)
VALUES ('14ab8846-f958-4791-8863-ed5446954721', '2020-03-21 13:02:39.050000000', 'ENABLED', 'Second Workflow',
        'second-workflow', 'Second Workflow', '740e8366-5048-40e2-866b-9ce82b713948');
INSERT INTO `clef-workflow`.workflow (uuid, creation_date, identity_status, workflow_description, workflow_key,
                                      workflow_name, initial_stage_uuid)
VALUES ('2448528c-b4c5-4698-936e-c3f6b1341152', '2020-03-21 11:54:15.468000000', 'ENABLED', 'Initial Workflow',
        'init-workflow', 'Initial Workflow', '0cc7d3cb-377c-4fbf-818e-fea371da0389');
INSERT INTO `clef-workflow`.workflow_stage (uuid, creation_date, identity_status, stage_key, stage_name,
                                            initial_task_uuid)
VALUES ('0cc7d3cb-377c-4fbf-818e-fea371da0389', '2020-03-21 11:54:46.288000000', 'ENABLED', 'init-stage', 'init-stage',
        '25aa90cc-89ba-4368-9635-27098324e85e');
INSERT INTO `clef-workflow`.workflow_stage (uuid, creation_date, identity_status, stage_key, stage_name,
                                            initial_task_uuid)
VALUES ('2abf7aa6-e63c-45bf-b83d-72635ec38723', '2020-03-21 11:56:09.373000000', 'ENABLED', 'start-stage',
        'start-stage', null);
INSERT INTO `clef-workflow`.workflow_stage (uuid, creation_date, identity_status, stage_key, stage_name,
                                            initial_task_uuid)
VALUES ('740e8366-5048-40e2-866b-9ce82b713948', '2020-03-21 13:03:10.810000000', 'ENABLED', 'w2-s2-stage',
        'Seocnd workflow stage', 'e5786912-0942-4953-bb28-0b6ffd3ac382');
INSERT INTO `clef-workflow`.workflow_stage_tasks (workflow_stage_uuid, tasks_uuid)
VALUES ('0cc7d3cb-377c-4fbf-818e-fea371da0389', '66f765e4-45b9-42ab-ac4d-b928fe029204');
INSERT INTO `clef-workflow`.workflow_stage_tasks (workflow_stage_uuid, tasks_uuid)
VALUES ('2abf7aa6-e63c-45bf-b83d-72635ec38723', '39324df5-a0a4-4b9a-b9fb-bf8b38e8f827');
INSERT INTO `clef-workflow`.workflow_stage_tasks (workflow_stage_uuid, tasks_uuid)
VALUES ('2abf7aa6-e63c-45bf-b83d-72635ec38723', '3adc61da-f8ce-4f72-8f49-2df3ec61f7b7');
INSERT INTO `clef-workflow`.workflow_stage_tasks (workflow_stage_uuid, tasks_uuid)
VALUES ('2abf7aa6-e63c-45bf-b83d-72635ec38723', 'e965bb99-0c90-4d44-96cf-0ca053e69c8a');
INSERT INTO `clef-workflow`.workflow_stages (workflow_uuid, stages_uuid)
VALUES ('2448528c-b4c5-4698-936e-c3f6b1341152', '2abf7aa6-e63c-45bf-b83d-72635ec38723');

SET FOREIGN_KEY_CHECKS=1;