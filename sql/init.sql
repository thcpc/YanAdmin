use yan;
SET FOREIGN_KEY_CHECKS  = 0;
DROP TABLE if EXISTS yan_user;
CREATE TABLE yan_user
(
  id int auto_increment,
  name varchar(45) not null unique,
  nick_name varchar(45) not null,
  role varchar(45) not null comment 'admin, trainee',
  create_dt datetime,
  is_delete bit default 0 comment '',
  primary key (id)
);


DROP TABLE if EXISTS yan_trainee;
CREATE TABLE yan_trainee
(
    id int auto_increment,
    user_id int not null ,
    level int not null  comment '7, 6,5,4,3,2,1,-1,-2,-3,-4',
    latest_attendance_date datetime,
    create_dt datetime,
    is_delete bit default 0 comment '',
    primary key (id),
    constraint fk_yan_trainee_userid foreign key (user_id) references yan_user(id)
);

DROP TABLE if EXISTS yan_attendance;
CREATE TABLE yan_attendance
(
    id int auto_increment,
    trainee_id int not null,
    is_delete bit default 0 comment '',
    create_dt datetime,
    primary key (id),
    constraint fk_yan_attendance_userid foreign key (trainee_id) references yan_trainee(id)
)

DROP TABLE if EXISTS yan_attendance_review;
CREATE TABLE yan_attendance_review
(
    id int auto_increment,
    yan_attendance_id int not null,
    is_reviewed int default 0 comment '',
    reason varchar(255) default '' comment '如果 is_reviewed = 0, 则填写该值',
    create_dt datetime,
    primary key (id),
    constraint fk_yan_attendance_review foreign key (yan_attendance_id) references yan_attendance(id)
)

