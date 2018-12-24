INSERT INTO BOOK (id, title, price) values (1, 'Harry Portter', 20.99);

insert into CALIBER_TRAINER (trainer_id, name, tier) values (100, 'Genesis', 'Role Trainer');
insert into CALIBER_BATCH (batch_id, start_date, trainer) values (1, '10-09-02 4:10:10.123000', 'Genesis');
INSERT INTO CALIBER_TRAINEE (TRAINEE_ID, FLAG_NOTES, FLAG_STATUS, TRAINEE_NAME,RESOURCE_ID, TRAINING_STATUS, BATCH_ID) values (10,'Good standing', 'Green', 'Howard Johnson', '20', 'TRAINING',1);
insert into CALIBER_NOTE (note_id, note_content, max_visibility, is_qc_feedback, qc_status, note_type, week_number, 
           batch_id, trainee_id) values (30, 'keep it up', 1, 2, 'good standing', 'normal', 9, 1, 10);

commit;