use ensolvers;
create table note
(
id_note int auto_increment primary key,
title varchar (20),
create_date date,
update_date date,
note_text blob,
status_note int 
);