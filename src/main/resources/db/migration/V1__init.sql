create table `gym` (
     `id` varchar(255) not null primary key,
     `gym_name` varchar(255),
     `created_by` varchar (255),
     `created_date` datetime(6),
     `last_modified_by` varchar (255),
     `last_modified_date` datetime(6),
     `version` int
);

create table `coach` (
    `id` varchar(255) not null primary key,
    `first_name` varchar(255),
    `last_name` varchar(255),
    `email` varchar(255),
    `phone_number` varchar(255),
    `created_by` varchar (255),
    `created_date` datetime(6),
    `last_modified_by` varchar (255),
    `last_modified_date` datetime(6),
    `version` int
);

create table `gym_coach` (
     `id` varchar(255) not null primary key,
     `gym_id` bigint,
     foreign key (gym_id) references gym(id),
     `coach_id` bigint,
     foreign key (coach_id) references coach(id),
     `created_by` varchar (255),
     `created_date` datetime(6),
     `last_modified_by` varchar (255),
     `last_modified_date` datetime(6),
    `version` int
);

create table `member` (
     `id` varchar(255) not null primary key,
     `first_name` varchar(255),
     `last_name` varchar(255),
     `email` varchar(255),
     `phone_number` varchar(255),
     `created_by` varchar (255),
     `created_date` datetime(6),
     `last_modified_by` varchar (255),
     `last_modified_date` datetime(6),
     `version` int
);

create table `exercise_session` (
     `id` varchar(255) not null primary key,
     `coach_id` bigint,
     foreign key (coach_id) references coach(id),
     `member_id` bigint,
     foreign key (member_id) references member(id),
     `gym_id` bigint,
     foreign key (gym_id) references gym(id),
     `created_by` varchar (255),
     `created_date` datetime(6),
     `last_modified_by` varchar (255),
     `last_modified_date` datetime(6),
     `version` int
);