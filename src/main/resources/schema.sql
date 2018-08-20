create table collegue (
  id serial primary key
);

create table role_collegue (
  id serial primary key,
  collegue_id bigint unsigned,
  foreign key (collegue_id) references collegue(id)
);