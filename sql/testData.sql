INSERT INTO yan_user(name, nick_name, role, create_dt)
VALUES ('陈鹏程', 'cpc', 'admin', NOW()),
       ('张三', 'zhangsan', 'trainee', NOW()),
       ('李四', 'lisi', 'trainee', NOW());


INSERT INTO yan_trainee(user_id, level, latest_attendance_date, create_dt)
VALUES (2, 5, NOW(), NOW()),
       (3, -3, NOW(), NOW());